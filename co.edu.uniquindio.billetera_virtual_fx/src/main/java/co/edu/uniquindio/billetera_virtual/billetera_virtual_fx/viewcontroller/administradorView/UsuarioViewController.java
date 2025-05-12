package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.administradorView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UsuarioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tc_contrasenia;

    @FXML
    private TableColumn<?, ?> tc_apellidos;

    @FXML
    private TextField txt_telefono;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private TableColumn<?, ?> tc_nombres;

    @FXML
    private TableColumn<?, ?> tc_direccion;

    @FXML
    private TableColumn<?, ?> tc_correo;

    @FXML
    private TextField txt_correo;

    @FXML
    private TableColumn<?, ?> tc_telefono;

    @FXML
    private TextField txt_contrasenia;

    @FXML
    private TableColumn<?, ?> tc_numero_id;

    @FXML
    private Button btn_eliminar_usuarios;

    @FXML
    private SplitPane sp_gestion_usuarios;

    @FXML
    private TextField txt_apellidos;

    @FXML
    private Button btn_actualizar_usuario;

    @FXML
    private AnchorPane ap_gestion_usuarios;

    @FXML
    private TextField txt_numero_id;

    @FXML
    private Button btn_agregar_usuario;

    @FXML
    private TextField txt_nombres;

    @FXML
    private TextField txt_direccion;

    @FXML
    void on_agregar_usuario() {

    }

    @FXML
    void on_actualizar_usuario() {

    }

    @FXML
    void on_limpiar_campos() {

    }

    @FXML
    void on_eliminar_usuarios() {

    }

    @FXML
    void initialize() {
        assert tc_contrasenia != null : "fx:id=\"tc_contrasenia\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert tc_apellidos != null : "fx:id=\"tc_apellidos\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert btn_limpiar_campos != null : "fx:id=\"btn_limpiar_campos\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert tc_nombres != null : "fx:id=\"tc_nombres\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert tc_direccion != null : "fx:id=\"tc_direccion\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert tc_correo != null : "fx:id=\"tc_correo\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert tc_telefono != null : "fx:id=\"tc_telefono\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_contrasenia != null : "fx:id=\"txt_contrasenia\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert tc_numero_id != null : "fx:id=\"tc_numero_id\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert btn_eliminar_usuarios != null : "fx:id=\"btn_eliminar_usuarios\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert sp_gestion_usuarios != null : "fx:id=\"sp_gestion_usuarios\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_apellidos != null : "fx:id=\"txt_apellidos\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert btn_actualizar_usuario != null : "fx:id=\"btn_actualizar_usuario\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert ap_gestion_usuarios != null : "fx:id=\"ap_gestion_usuarios\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_numero_id != null : "fx:id=\"txt_numero_id\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert btn_agregar_usuario != null : "fx:id=\"btn_agregar_usuario\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_nombres != null : "fx:id=\"txt_nombres\" was not injected: check your FXML file 'Usuario.fxml'.";
        assert txt_direccion != null : "fx:id=\"txt_direccion\" was not injected: check your FXML file 'Usuario.fxml'.";

    }
}

