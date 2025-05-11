package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.principalView;


import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.principalController.LoginController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.AdministradorMenuViewController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.UsuarioMenuViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;
import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.MetodosReutilizables.mostrarMensaje;

public class LoginViewController {

    LoginController loginController;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ap_login;
    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_contrasenia;

    @FXML
    private Button btn_iniciar_sesion;

    @FXML
    void on_iniciar_sesion() {
        ingresar();
    }




    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    @FXML
    private void vistaUsuario(UsuarioDto usuarioDto) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/billetera_virtual/" +
                    "billetera_virtual_fx/UsuarioMenu.fxml"));
            AnchorPane menuUsuario = fxmlLoader.load();
            UsuarioMenuViewController usuarioMenuViewController = fxmlLoader.getController();
            usuarioMenuViewController.setUsuario(usuarioDto);

            SplitPane splitPane = (SplitPane) ap_login.getParent().getParent();
            splitPane.getItems().setAll(menuUsuario);
        } catch (IOException e) {
                System.err.println("Error al cambiar la vista: " + e.getMessage());
                e.printStackTrace();
        }
    }


    private void vistaAdministrador(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/billetera_virtual/" +
                    "billetera_virtual_fx/AdministradorMenu.fxml"));
            AnchorPane menuAdministrador = fxmlLoader.load();
            AdministradorMenuViewController administradorMenuViewController = fxmlLoader.getController();

            SplitPane splitPane = (SplitPane) ap_login.getParent().getParent();
            splitPane.getItems().setAll(menuAdministrador);
        } catch (IOException e) {
            System.err.println("Error al cambiar la vista: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void ingresar() {
        if(camposLlenos()){
            String usuario = txt_correo.getText();
            String clave = txt_contrasenia.getText();

            if(iniciarSesionUsuario(usuario, clave)){
                return;
            } else {
                if(!iniciarSesionAdministrador(usuario, clave)){
                    mostrarMensaje(TITULO_INFORMACION_INCORRECTAS,
                            CUERPO_INFORMACION_INCORRECTAS, Alert.AlertType.WARNING);
                }
            }
        }
        else {
            mostrarMensaje(TITULO_INFORMACION_INVALIDA,
                    CUERPO_INFORMACION_INVALIDA, Alert.AlertType.WARNING);
        }
    }

    private boolean iniciarSesionAdministrador(String usuario, String clave){
        if(loginController.verificarInfoAdministrador(usuario, clave)){
    mostrarMensaje( TITULO_BIENVENIDA_ADM, CUERPO_BIENVENIDA_ADM + "Administrador",
            Alert.AlertType.INFORMATION);
            vistaAdministrador();
            return true;
        }
        return false;
    }

    private boolean iniciarSesionUsuario(String usuario, String clave){
        if(loginController.verificarInfoUsuario(usuario, clave)){
            UsuarioDto usuarioDto = loginController.obtenerUsuario(usuario, clave);
            if(usuarioDto == null){
                mostrarMensaje(TITULO_INFORMACION_INCORRECTAS + usuarioDto.nombre(),
                        CUERPO_INFORMACION_INCORRECTAS, Alert.AlertType.WARNING);
                return false;
            }
            mostrarMensaje(TITULO_BIENVENIDA_USUARIO, CUERPO_BIENVENIDA_USUARIO ,
                    Alert.AlertType.INFORMATION);
            vistaUsuario(usuarioDto);
            return true;
        }
        return false;
    }

    private boolean camposLlenos(){
        return !txt_correo.getText().isEmpty()&&!txt_contrasenia.getText().isEmpty();
    }


}
