package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.ReporteFinancieroViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuUsuarioViewController {

    UsuarioDto usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tab_editarPerfil;

    @FXML
    private Tab tab_categorias;

    @FXML
    private Tab tab_reporteFinanciero;

    @FXML
    private Tab tab_cuentas;

    @FXML
    private SplitPane sp_reporteFinanciero;

    @FXML
    private Tab tab_transacciones;

    @FXML
    private SplitPane sp_presupuestos;

    @FXML
    private SplitPane sp_editarPerfil;

    @FXML
    private AnchorPane ap_menuAdmin;

    @FXML
    private Tab tab_presupuestos;

    @FXML
    private SplitPane sp_transacciones;

    @FXML
    private SplitPane sp_cuentas;

    @FXML
    private TabPane tp_menuUsuario;

    @FXML
    private SplitPane sp_categorias;

    @FXML
    void initialize() {
        configurarCambioDeTab();
    }

    public void setUsuario(UsuarioDto usuarioDto) {
        usuario = usuarioDto;
        mostrarVistaPerfil();
        mostrarVistaGestionCategorias();
        mostrarVistaGestionPresupuestos();
        mostrarVistaCuentasUsuario();
        mostrarVistaGestionTransaccionesUsuario();
        mostrarVistaReporteFinanciero();
    }



    private void mostrarVistaPerfil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/Perfil.fxml"));
            AnchorPane nuevaVista = loader.load();
            PerfilViewController viewController = loader.getController();
            viewController.setUsuario(usuario);
            viewController.setParentController(this);
            sp_editarPerfil.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarVistaGestionCategorias() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/Categorias.fxml"));
            AnchorPane nuevaVista = loader.load();
            CategoriasViewController viewController = loader.getController();
            viewController.setUsuario(usuario);
            sp_categorias.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarVistaGestionPresupuestos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/Presupuestos.fxml"));
            AnchorPane nuevaVista = loader.load();
            PresupuestosViewController viewController = loader.getController();
            viewController.setUsuario(usuario);
            sp_presupuestos.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarVistaCuentasUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/CuentasUsuario.fxml"));
            AnchorPane nuevaVista = loader.load();
            CuentasUsuarioViewController viewController = loader.getController();
            viewController.setUsuario(usuario);
            sp_cuentas.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarVistaGestionTransaccionesUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/TransaccionesUsuario.fxml"));
            AnchorPane nuevaVista = loader.load();
            TransaccionesUsuarioViewController viewController = loader.getController();
            viewController.setUsuario(usuario);
            sp_transacciones.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarVistaReporteFinanciero() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/usuario/ReporteFinanciero.fxml"));
            AnchorPane nuevaVista = loader.load();
            ReporteFinancieroViewController viewController = loader.getController();
            viewController.setUsuario(usuario);
            sp_reporteFinanciero.getItems().setAll(nuevaVista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void configurarCambioDeTab() {
        tp_menuUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == tab_editarPerfil) {
                mostrarVistaPerfil();
            } else if (newTab == tab_reporteFinanciero) {
                mostrarVistaReporteFinanciero();
            } else if (newTab == tab_cuentas) {
                mostrarVistaCuentasUsuario();
            } else if (newTab == tab_categorias) {
                mostrarVistaGestionCategorias();
            } else if (newTab == tab_presupuestos) {
                mostrarVistaGestionPresupuestos();
            } else if (newTab == tab_transacciones) {
                mostrarVistaGestionTransaccionesUsuario();
            }
        });
    }
}
