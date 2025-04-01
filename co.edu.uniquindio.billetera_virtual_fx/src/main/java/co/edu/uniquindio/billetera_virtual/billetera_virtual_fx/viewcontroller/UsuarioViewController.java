package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.scene.control.Alert;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;

public class UsuarioViewController {

    private void agregarUsuario() {
        UsuarioDto usuarioDto = crearUsuarioDto();
        if(datosValidos(usuarioDto)){

        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, CUERPO_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private UsuarioDto crearUsuarioDto() {
        return new UsuarioDto(
                txtNombre.getText(),
                txtApellidos.getText(),
                txtEmail.getText(),
                txtTelefono.getText(),
                txtIdUsuario.getText(),
                txtDireccion.getText());
    }

    private boolean datosValidos(UsuarioDto usuarioDto) {
        if(usuarioDto.nombre().isEmpty() ||
                usuarioDto.apellidos().isEmpty() ||
                usuarioDto.email().isEmpty() ||
                usuarioDto.telefono().isEmpty() ||
                usuarioDto.idUsuario().isEmpty() ||
                usuarioDto.direccion().isEmpty()){
            return false;
        }
        return true;
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
