package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView.GestionCategoriasViewController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView.PerfilViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class UsuarioMenuViewController {

    UsuarioDto usuarioDto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tab_categorias;

    @FXML
    private Tab tab_presupuesto;

    @FXML
    private Tab tab_reportes_financieros;

    @FXML
    private Tab tab_cuentas;

    @FXML
    private Tab tab_transacciones;

    @FXML
    private Tab tab_perfil;

    @FXML
    private SplitPane ap_transaccion;

    @FXML
    private void initialize() {

    }

    public void setUsuario(UsuarioDto usuarioDto){
        this.usuarioDto = usuarioDto;
        cargarVistaPerfil();
        cargarVistaGestionCategorias();
    }

    private void cargarVistaGestionCategorias() {
        try {
            FXMLLoader fxmlCategorias = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/GestionCategorias.fxml"));
            AnchorPane categoriasContent = fxmlCategorias.load();
            GestionCategoriasViewController gestionCategoriasViewController = fxmlCategorias.getController();
            gestionCategoriasViewController.setUsuario(usuarioDto);
            tab_categorias.setContent(categoriasContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarVistaPerfil() {
        try {
            FXMLLoader fxmlPerfil = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/Perfil.fxml"));
            AnchorPane perfilContent = fxmlPerfil.load();
            PerfilViewController perfilViewController = fxmlPerfil.getController();
            perfilViewController.setUsuario(usuarioDto);
            tab_perfil.setContent(perfilContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

