package NuestraSenoraDeLaSabiduria.LoginBack.Controlador.Privado;

import NuestraSenoraDeLaSabiduria.LoginBack.Servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioDatosControlador {

  final UsuarioServicio usuarioServicio;

  @RequestMapping("/datosUsuario")
  public String datosUsuario(@RequestParam String usuarioId) {
    return usuarioServicio.obtenerNombreEstudiante(usuarioId);
  }
}
