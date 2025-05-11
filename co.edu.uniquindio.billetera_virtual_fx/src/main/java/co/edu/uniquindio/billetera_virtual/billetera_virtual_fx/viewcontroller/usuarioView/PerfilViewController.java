package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PerfilViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private SplitPane sp_perfil_usuario;

    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_contrasenia;

    @FXML
    private Button btn_actualizar_datos;

    @FXML
    private TextField txt_telefono;

    @FXML
    private TextField txt_apellido;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private AnchorPane ap_perfil;

    @FXML
    private TextField txt_nombre;

    @FXML
    void on_actualizar_datos() {

    }

    @FXML
    void on_limpiar_campos() {

    }

    @FXML
    void initialize() {
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert txt_contrasenia != null : "fx:id=\"txt_contrasenia\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert btn_actualizar_datos != null : "fx:id=\"btn_actualizar_datos\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert txt_apellido != null : "fx:id=\"txt_apellido\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert btn_limpiar_campos != null : "fx:id=\"btn_limpiar_campos\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert ap_perfil != null : "fx:id=\"ap_perfil\" was not injected: check your FXML file 'Perfil.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'Perfil.fxml'.";

    }
}
