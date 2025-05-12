package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;

public class UsuarioMenuViewController {

    UsuarioDto usuario;

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
    void initialize() {

    }

    public void setUsuario(UsuarioDto usuario){
        this.usuario = usuario;
    }


}

