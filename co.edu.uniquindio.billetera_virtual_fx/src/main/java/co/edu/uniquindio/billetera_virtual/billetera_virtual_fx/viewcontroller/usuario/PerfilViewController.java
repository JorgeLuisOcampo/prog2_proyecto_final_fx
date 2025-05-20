package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario.PerfilController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;
import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.MetodosReutilizables.*;

public class PerfilViewController {

    private PerfilController perfilController;
    private MenuUsuarioViewController menuUsuarioViewController;
    private UsuarioDto usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lb_titulo;

    @FXML
    private TextField tf_telefono;

    @FXML
    private Label lb_nombre;

    @FXML
    private Button bt_actualizar;

    @FXML
    private TextField tf_correo;

    @FXML
    private TextField tf_nombre;

    @FXML
    private Label lb_telefono;

    @FXML
    private Button bt_limpiar;

    @FXML
    private Label lb_correo;

    @FXML
    private Label lb_clave;

    @FXML
    private TextField tf_clave;

    @FXML
    void onLimpiar() {
        limpiarCampos();
    }

    @FXML
    void onActualizar() {
        actualizar();
    }

    public void setUsuario(UsuarioDto usuarioDto) {
        usuario = usuarioDto;
        limpiarCampos();
    }

    public void setParentController(MenuUsuarioViewController menuUsuarioViewController) {
        this.menuUsuarioViewController = menuUsuarioViewController;
    }

    private UsuarioDto crearUsuario() {
        return new UsuarioDto(tf_nombre.getText(), usuario.idUsuario(), tf_correo.getText(), tf_telefono.getText(),
                usuario.direccion(), Integer.parseInt(tf_clave.getText()));
    }

    public void limpiarCampos() {
        tf_clave.setText(String.valueOf(usuario.clave()));
        tf_correo.setText(usuario.correoElectronico());
        tf_nombre.setText(usuario.nombreCompleto());
        tf_telefono.setText(usuario.numeroTelefono());
    }

    private void actualizar() {
        if (validarCamposCompletos()) {
            if (validarCamposValidos()){
                UsuarioDto usuarioNuevo = crearUsuario();
                if (perfilController.actualizarUsuario(usuario.idUsuario(), usuarioNuevo)) {
                    usuario = usuarioNuevo;
                    menuUsuarioViewController.setUsuario(usuario);
                    limpiarCampos();
                    mostrarMensaje(TITULO_USUARIO_ACTUALIZADO,
                            BODY_USUARIO_ACTUALIZADO, Alert.AlertType.INFORMATION);
                }
                else{
                    mostrarMensaje(TITULO_USUARIO_NO_ACTUALIZADO,
                            BODY_USUARIO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
                }
            }
            else{
                mostrarMensaje(TITULO_INCORRECTO,
                        BODY_INCORRECTO, Alert.AlertType.WARNING);
            }
        }
        else{
            mostrarMensaje(TITULO_INCOMPLETO,
                    BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private boolean validarCamposCompletos() {
        if (tf_correo.getText().isEmpty() || tf_telefono.getText().isEmpty()||
                tf_clave.getText().isEmpty() || tf_nombre.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean validarCamposValidos(){
        if (esTipoInteger(tf_clave.getText()) && esTipoLong(tf_telefono.getText()) && validarCorreo(tf_correo.getText())) {
            return true;
        }
        return false;
    }

    public static boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return correo.matches(regex);
    }

    @FXML
    void initialize() {
        perfilController = new PerfilController();
    }
}
