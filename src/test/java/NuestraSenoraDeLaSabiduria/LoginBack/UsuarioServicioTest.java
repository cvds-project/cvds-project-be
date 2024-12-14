package NuestraSenoraDeLaSabiduria.LoginBack;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.AuthResponse;
import NuestraSenoraDeLaSabiduria.LoginBack.Excepciones.Excepciones;
import NuestraSenoraDeLaSabiduria.LoginBack.Jwt.JwtService;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.ResponsableEconomico;
import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.ResponsableEconomicoRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Repositorio.UsuarioRepository;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServicioTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private ResponsableEconomicoRepository responsableEconomicoRepository;

    @InjectMocks
    private UsuarioServicio usuarioServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarEstudiante() {
        Estudiante estudiante = new Estudiante();
        String result = usuarioServicio.registrarEstudiante(estudiante);
        verify(usuarioRepository, times(1)).save(estudiante);
        assertEquals("Estudiante registrado", result);
    }



    @Test
    void testRegistrarBibliotecario() {
        Bibliotecario bibliotecario = new Bibliotecario();
        String result = usuarioServicio.registrarBibliotecario(bibliotecario);
        verify(usuarioRepository, times(1)).save(bibliotecario);
        assertEquals("Bibliotecario registrado", result);
    }

    @Test
    void testLoginUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("testUser");
        usuario.setContrasena("password");
        when(usuarioRepository.findByNombreUsuario("testUser")).thenReturn(Optional.of(usuario));
        when(jwtService.getToken(usuario)).thenReturn("token");

        AuthResponse result = usuarioServicio.loginUsuario("testUser", "password");
        assertEquals("token", result.getToken());
        assertEquals("Usuario", result.getRol());
        assertEquals("testUser", result.getNombreUsuario());
    }

    @Test
    void testLoginUsuarioThrowsExceptionForInvalidUser() {
        when(usuarioRepository.findByNombreUsuario("invalidUser")).thenReturn(Optional.empty());

        Exception exception = assertThrows(Excepciones.class, () -> {
            usuarioServicio.loginUsuario("invalidUser", "password");
        });

        assertEquals(Excepciones.USUARIO_INEXISTENTE, exception.getMessage());
    }

    @Test
    void testLoginUsuarioThrowsExceptionForInvalidPassword() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("testUser");
        usuario.setContrasena("password");
        when(usuarioRepository.findByNombreUsuario("testUser")).thenReturn(Optional.of(usuario));

        Exception exception = assertThrows(Excepciones.class, () -> {
            usuarioServicio.loginUsuario("testUser", "wrongPassword");
        });

        assertEquals(Excepciones.LOGIN_INVALIDO, exception.getMessage());
    }

    @Test
    void testListarUsuarios() {
        usuarioServicio.listarUsuarios();
        verify(usuarioRepository, times(1)).findAll();
    }


    @Test
    void testObtenerNombreEstudiante() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("testUser");
        when(usuarioRepository.findByCodigoEstudiante("123")).thenReturn(usuario);

        String result = usuarioServicio.obtenerNombreEstudiante("123");
        assertEquals("testUser", result);
    }
}