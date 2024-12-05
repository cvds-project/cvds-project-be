package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.UsuarioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioDTOTest {

    private UsuarioDTO usuarioDTO;

    @BeforeEach
    public void setUp() {
        usuarioDTO = new UsuarioDTO("usuarioDTO", "passwordDTO", "Maria Lopez");
    }

    @Test
    public void testUsuarioDTOCreation() {
        assertNotNull(usuarioDTO, "El objeto UsuarioDTO debería ser creado correctamente.");
        assertEquals("usuarioDTO", usuarioDTO.getNombreUsuario(), "El nombre de usuario debería ser 'usuarioDTO'.");
        assertEquals("passwordDTO", usuarioDTO.getContrasena(), "La contraseña debería ser 'passwordDTO'.");
        assertEquals("Maria Lopez", usuarioDTO.getNombreCompleto(), "El nombre completo debería ser 'Maria Lopez'.");
    }

    @Test
    public void testGetNombreUsuario() {
        assertEquals("usuarioDTO", usuarioDTO.getNombreUsuario(), "El nombre de usuario debería ser 'usuarioDTO'.");
    }

    @Test
    public void testGetContrasena() {
        assertEquals("passwordDTO", usuarioDTO.getContrasena(), "La contraseña debería ser 'passwordDTO'.");
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Maria Lopez", usuarioDTO.getNombreCompleto(), "El nombre completo debería ser 'Maria Lopez'.");
    }

    @Test
    public void testSetNombreUsuario() {
        usuarioDTO.setNombreUsuario("nuevoUsuarioDTO");
        assertEquals("nuevoUsuarioDTO", usuarioDTO.getNombreUsuario(), "El nombre de usuario debería actualizarse a 'nuevoUsuarioDTO'.");
    }

    @Test
    public void testSetContrasena() {
        usuarioDTO.setContrasena("nuevaPasswordDTO");
        assertEquals("nuevaPasswordDTO", usuarioDTO.getContrasena(), "La contraseña debería actualizarse a 'nuevaPasswordDTO'.");
    }

    @Test
    public void testSetNombreCompleto() {
        usuarioDTO.setNombreCompleto("Carlos Martinez");
        assertEquals("Carlos Martinez", usuarioDTO.getNombreCompleto(), "El nombre completo debería actualizarse a 'Carlos Martinez'.");
    }
}