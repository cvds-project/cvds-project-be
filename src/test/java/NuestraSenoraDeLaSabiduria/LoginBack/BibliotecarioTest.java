package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Bibliotecario;
import org.junit.jupiter.api.Test;

public class BibliotecarioTest {

  @Test
  public void testBibliotecarioCreation() {
    Bibliotecario bibliotecario = new Bibliotecario(
            "usuarioBiblio",
            "passBiblio",
            "Carlos Perez"
    );

    assertNotNull(
            bibliotecario,
            "El objeto Bibliotecario debería ser creado correctamente."
    );
    assertEquals(
            "usuarioBiblio",
            bibliotecario.getNombreUsuario(),
            "El nombre de usuario debería ser 'usuarioBiblio'."
    );
    assertEquals(
            "passBiblio",
            bibliotecario.getContrasena(),
            "La contraseña debería ser 'passBiblio'."
    );
    assertEquals(
            "Carlos Perez",
            bibliotecario.getNombreCompleto(),
            "El nombre completo debería ser 'Carlos Perez'."
    );
  }

  @Test
  public void testObtenerDetallesUsuario() {
    Bibliotecario bibliotecario = new Bibliotecario(
            "usuarioBiblio",
            "passBiblio",
            "Carlos Perez"
    );

    String detallesEsperados = "Usuario: Carlos Perez - Bibliotecario";
    assertEquals(
            detallesEsperados,
            bibliotecario.obtenerDetallesUsuario(),
            "Los detalles del usuario deberían ser 'Usuario: Carlos Perez - Bibliotecario'."
    );
  }
}