package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.InicioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioViewController {

    InicioController inicioController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ap_principal;

    @FXML
    private SplitPane sp_login;

    @FXML
    private Tab tab_login;

    @FXML
    private TabPane tp_principal;

    @FXML
    private AnchorPane ap_login;

    @FXML
    private Tab tab_registro;

    @FXML
    private AnchorPane ap_registro;

    @FXML
    private SplitPane sp_registro;


    private void cargarVistaLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/LoginMenu.fxml"));
            AnchorPane nuevaVista = loader.load();
            sp_login.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarVistaRegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/RegistrarMenu.fxml"));
            AnchorPane nuevaVista = loader.load();
            sp_registro.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para configurar el cambio de tab
     */
    private void configurarCambioDeTab() {
        tp_principal.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == tab_login) {
                cargarVistaLogin();
            } else if (newTab == tab_registro) {
                cargarVistaRegistro();
            }
        });
    }

    /**
     * Metodo para inicializar el InicioViewController
     */
    @FXML
    void initialize() {
        configurarCambioDeTab();
        inicioController = new InicioController();
    }
}
