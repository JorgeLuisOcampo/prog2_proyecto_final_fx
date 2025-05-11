package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.principalView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;

public class RegistroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_contraseña;

    @FXML
    private Button btn_registrarse;

    @FXML
    private TextField txt_telefono;

    @FXML
    private TextField txt_apellido;

    @FXML
    private SplitPane sp_registro;

    @FXML
    private TextField txt_id_usuario;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_direccion;

    @FXML
    void on_registrarse() {

    }

    @FXML
    void initialize() {
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'registro.fxml'.";
        assert txt_contraseña != null : "fx:id=\"txt_contraseña\" was not injected: check your FXML file 'registro.fxml'.";
        assert btn_registrarse != null : "fx:id=\"btn_registrarse\" was not injected: check your FXML file 'registro.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'registro.fxml'.";
        assert txt_apellido != null : "fx:id=\"txt_apellido\" was not injected: check your FXML file 'registro.fxml'.";
        assert sp_registro != null : "fx:id=\"sp_registro\" was not injected: check your FXML file 'registro.fxml'.";
        assert txt_id_usuario != null : "fx:id=\"txt_id_usuario\" was not injected: check your FXML file 'registro.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'registro.fxml'.";
        assert txt_direccion != null : "fx:id=\"txt_direccion\" was not injected: check your FXML file 'registro.fxml'.";

    }
}
