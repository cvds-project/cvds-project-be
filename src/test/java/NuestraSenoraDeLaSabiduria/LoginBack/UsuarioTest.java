package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsuarioTest {

    @Test
    public void testUsuarioCreation() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        assertNotNull(usuario, "El objeto Usuario debería ser creado correctamente.");
        assertEquals("usuarioTest", usuario.getNombreUsuario(), "El nombre de usuario debería ser 'usuarioTest'.");
        assertEquals("passwordTest", usuario.getContrasena(), "La contraseña debería ser 'passwordTest'.");
        assertEquals("Juan Perez", usuario.getNombreCompleto(), "El nombre completo debería ser 'Juan Perez'.");
    }

    @Test
    public void testObtenerDetallesUsuario() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        String detallesEsperados = "Usuario: Juan Perez";
        assertEquals(detallesEsperados, usuario.obtenerDetallesUsuario(), "Los detalles del usuario deberían ser 'Usuario: Juan Perez'.");
    }

    @Test
    public void testGetAuthorities() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
        assertNotNull(authorities, "Las autoridades no deberían ser nulas.");
        assertEquals(1, authorities.size(), "Debería haber una autoridad.");
        assertEquals("Usuario", authorities.iterator().next().getAuthority(), "La autoridad debería ser 'Usuario'.");
    }

    @Test
    public void testGetPassword() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        assertEquals("passwordTest", usuario.getPassword(), "La contraseña debería ser 'passwordTest'.");
    }

    @Test
    public void testGetUsername() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        assertEquals("usuarioTest", usuario.getUsername(), "El nombre de usuario debería ser 'usuarioTest'.");
    }

    @Test
    public void testGetAuthorities1() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
        assertNotNull(authorities, "Las autoridades no deberían ser nulas.");
        assertEquals(1, authorities.size(), "Debería haber una autoridad.");
        assertEquals("Usuario", authorities.iterator().next().getAuthority(), "La autoridad debería ser 'Usuario'.");
    }

    @Test
    public void testGetPassword1() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        assertEquals("passwordTest", usuario.getPassword(), "La contraseña debería ser 'passwordTest'.");
    }

    @Test
    public void testGetUsername1() {
        Usuario usuario = new Usuario("usuarioTest", "passwordTest", "Juan Perez");

        assertEquals("usuarioTest", usuario.getUsername(), "El nombre de usuario debería ser 'usuarioTest'.");
    }
}