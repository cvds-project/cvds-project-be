package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Privado;

import NuestraSenoraDeLaSabiduria.LoginBack.Controlador.BuscandoEstudiantePorIdDTO;
import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioDatosControlador {

  @Autowired
  private UsuarioServicio usuarioServicio;

  @PostMapping("/buscandoEstudiantePorId")
  public String datosUsuario(
    @RequestBody BuscandoEstudiantePorIdDTO usuarioId
  ) {
    System.out.println("usuarioId: " + usuarioId);
    return usuarioServicio.obtenerNombreEstudiante(usuarioId.getIdEstudiante());
  }
}
