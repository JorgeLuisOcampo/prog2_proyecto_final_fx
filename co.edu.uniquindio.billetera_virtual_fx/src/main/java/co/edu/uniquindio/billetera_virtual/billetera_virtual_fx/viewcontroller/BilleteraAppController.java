package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BilleteraAppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField txtContraseñaInicioSesion;

    @FXML
    private TextField txtCorreoElectronicoInicioSesion;

    @FXML
    private Button btnRecuperarDatos;

    @FXML
    private Button btnRegistrarse;

    @FXML
    void OnIniciarSesion(ActionEvent event) {

    }


    @FXML
    void OnRecuperar(ActionEvent event) {


    }

    @FXML
    void OnRegistrarse(ActionEvent event) {


    }

    @FXML
    void initialize() {
        assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'BilleteraApp.fxml'.";
        assert txtContraseñaInicioSesion != null : "fx:id=\"txtContraseñaInicioSesion\" was not injected: check your FXML file 'BilleteraApp.fxml'.";
        assert txtCorreoElectronicoInicioSesion != null : "fx:id=\"txtCorreoElectronicoInicioSesion\" was not injected: check your FXML file 'BilleteraApp.fxml'.";
        assert btnRecuperarDatos != null : "fx:id=\"btnRecuperarDatos\" was not injected: check your FXML file 'BilleteraApp.fxml'.";
        assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'BilleteraApp.fxml'.";

    }
}
