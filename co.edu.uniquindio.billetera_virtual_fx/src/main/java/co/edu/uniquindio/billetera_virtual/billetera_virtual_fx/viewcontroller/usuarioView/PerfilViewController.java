package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuarioController.PerfilController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;
import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.MetodosReutilizables.mostrarMensaje;

public class PerfilViewController {
    PerfilController perfilController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ap_perfil;

    @FXML
    private Button btn_actualizar_datos;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private Label label_numeroIdentificacion;

    @FXML
    private SplitPane sp_perfil_usuario;

    @FXML
    private TextField txt_apellido;

    @FXML
    private TextField txt_contrasenia;

    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_direccion;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_telefono;



    @FXML
    void on_actualizar_datos() {
        actualizar();

    }

    @FXML
    void on_limpiar_campos() {
        limpiarCampos();

    }

    private void actualizar() {
        UsuarioDto usuario = crearUsuarioDto();
        if(validarDatos(usuario)){
            if(perfilController.actualizarUsuario(usuario)){
                System.out.println("bien");
                setUsuario(usuario);
                mostrarMensaje(TITULO_USUARIO_ACTUALIZADO, CUERPO_USUARIO_ACTUALIZADO, Alert.AlertType.INFORMATION);


            }


        }
    }

    private UsuarioDto crearUsuarioDto() {
        return new UsuarioDto(
                txt_nombre.getText(),
                txt_apellido.getText(),
                txt_correo.getText(),
                txt_telefono.getText(),
                label_numeroIdentificacion.getText(),
                txt_direccion.getText());
    }

    private boolean validarDatos(UsuarioDto usuarioDto) {
        if(!txt_nombre.getText().isEmpty() &&
                !txt_apellido.getText().isEmpty() &&
                !txt_correo.getText().isEmpty() &&
                !txt_telefono.getText().isEmpty() &&
                !txt_contrasenia.getText().isEmpty() &&
                !txt_direccion.getText().isEmpty()){
            return true;
        }
        return false;
    }

    private void limpiarCampos() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");
        txt_contrasenia.setText("");
        txt_direccion.setText("");
    }

    @FXML
    void initialize() {
        perfilController = new PerfilController();

    }

    private void initView() {
        String contraseniaDto = perfilController.contraseniaDto(usuarioDto);
        if (usuarioDto != null) {
            txt_nombre.setText(usuarioDto.nombre());
            txt_apellido.setText(usuarioDto.apellidos());
            txt_correo.setText(usuarioDto.correo());
            txt_telefono.setText(usuarioDto.telefono());
            label_numeroIdentificacion.setText(usuarioDto.idUsuario());
            txt_direccion.setText(usuarioDto.direccion());
            txt_contrasenia.setText(contraseniaDto);
        }
    }

    private UsuarioDto usuarioDto;

    public void setUsuario(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
        limpiarCampos();
        initView();
    }
}
