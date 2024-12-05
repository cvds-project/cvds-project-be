package NuestraSenoraDeLaSabiduria.LoginBack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import NuestraSenoraDeLaSabiduria.LoginBack.Modelo.Estudiante;
import org.junit.jupiter.api.Test;

public class EstudianteTest {

    @Test
    public void testEstudianteCreation() {
        Estudiante estudiante = new Estudiante(
                "usuarioEstudiante",
                "passwordEstudiante",
                "Ana Gomez",
                "12345",
                "10A",
                "2023",
                "resp123"
        );

        assertNotNull(estudiante, "El objeto Estudiante debería ser creado correctamente.");
        assertEquals("usuarioEstudiante", estudiante.getNombreUsuario(), "El nombre de usuario debería ser 'usuarioEstudiante'.");
        assertEquals("passwordEstudiante", estudiante.getContrasena(), "La contraseña debería ser 'passwordEstudiante'.");
        assertEquals("Ana Gomez", estudiante.getNombreCompleto(), "El nombre completo debería ser 'Ana Gomez'.");
        assertEquals("12345", estudiante.getCodigoEstudiante(), "El código de estudiante debería ser '12345'.");
        assertEquals("10A", estudiante.getCurso(), "El curso debería ser '10A'.");
        assertEquals("2023", estudiante.getAnoAcademico(), "El año académico debería ser '2023'.");
        assertEquals("resp123", estudiante.getResponsableId(), "El ID del responsable debería ser 'resp123'.");
    }

    @Test
    public void testObtenerDetallesUsuario() {
        Estudiante estudiante = new Estudiante(
                "usuarioEstudiante",
                "passwordEstudiante",
                "Ana Gomez",
                "12345",
                "10A",
                "2023",
                "resp123"
        );

        String detallesEsperados = "Usuario: Ana Gomez - Código Estudiante: 12345 - Curso: 10A - Año Académico: 2023";
        assertEquals(detallesEsperados, estudiante.obtenerDetallesUsuario(), "Los detalles del estudiante deberían ser 'Usuario: Ana Gomez - Código Estudiante: 12345 - Curso: 10A - Año Académico: 2023'.");
    }

    @Test
    public void testBuilder() {
        Estudiante estudiante = new Estudiante.Builder("usuarioEstudiante", "passwordEstudiante", "Ana Gomez")
                .codigoEstudiante("12345")
                .curso("10A")
                .anoAcademico("2023")
                .responsableId("resp123")
                .build();

        assertNotNull(estudiante, "El objeto Estudiante debería ser creado correctamente.");
        assertEquals("usuarioEstudiante", estudiante.getNombreUsuario(), "El nombre de usuario debería ser 'usuarioEstudiante'.");
        assertEquals("passwordEstudiante", estudiante.getContrasena(), "La contraseña debería ser 'passwordEstudiante'.");
        assertEquals("Ana Gomez", estudiante.getNombreCompleto(), "El nombre completo debería ser 'Ana Gomez'.");
        assertEquals("12345", estudiante.getCodigoEstudiante(), "El código de estudiante debería ser '12345'.");
        assertEquals("10A", estudiante.getCurso(), "El curso debería ser '10A'.");
        assertEquals("2023", estudiante.getAnoAcademico(), "El año académico debería ser '2023'.");
        assertEquals("resp123", estudiante.getResponsableId(), "El ID del responsable debería ser 'resp123'.");
    }
}