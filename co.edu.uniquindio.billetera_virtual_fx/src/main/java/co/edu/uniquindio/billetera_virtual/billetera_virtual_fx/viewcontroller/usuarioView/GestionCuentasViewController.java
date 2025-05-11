package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class GestionCuentasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> cbx_tipo_cuenta;

    @FXML
    private TableColumn<?, ?> tc_id_cuenta;

    @FXML
    private TableColumn<?, ?> tc_nombre_banco;

    @FXML
    private TextField txt_nombre_banco;

    @FXML
    private Button btn_eliminar_cuenta;

    @FXML
    private TableColumn<?, ?> tc_numero_cuenta;

    @FXML
    private TableColumn<?, ?> tc_presupuesto_asociado;

    @FXML
    private Button btn_agregar_cuenta;

    @FXML
    private TableColumn<?, ?> tc_tipo_cuenta;

    @FXML
    private Button btn_limpiar_cuenta;

    @FXML
    private TextField txt_id_cuenta;

    @FXML
    private TableColumn<?, ?> tc_saldo;

    @FXML
    private Button btn_actualizar_cuenta;

    @FXML
    private ComboBox<?> cbx_presupuesto_asociado;

    @FXML
    private TextField txt_numero_cuenta;

    @FXML
    private SplitPane sp_gestion_cuentas;

    @FXML
    void on_agregar_cuenta() {

    }

    @FXML
    void on_actualizar_cuenta() {

    }

    @FXML
    void on_limpiar_cuenta() {

    }

    @FXML
    void on_eliminar_cuenta() {

    }

    @FXML
    void initialize() {
        assert cbx_tipo_cuenta != null : "fx:id=\"cbx_tipo_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert tc_id_cuenta != null : "fx:id=\"tc_id_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert tc_nombre_banco != null : "fx:id=\"tc_nombre_banco\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert txt_nombre_banco != null : "fx:id=\"txt_nombre_banco\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert btn_eliminar_cuenta != null : "fx:id=\"btn_eliminar_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert tc_numero_cuenta != null : "fx:id=\"tc_numero_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert tc_presupuesto_asociado != null : "fx:id=\"tc_presupuesto_asociado\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert btn_agregar_cuenta != null : "fx:id=\"btn_agregar_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert tc_tipo_cuenta != null : "fx:id=\"tc_tipo_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert btn_limpiar_cuenta != null : "fx:id=\"btn_limpiar_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert txt_id_cuenta != null : "fx:id=\"txt_id_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert tc_saldo != null : "fx:id=\"tc_saldo\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert btn_actualizar_cuenta != null : "fx:id=\"btn_actualizar_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert cbx_presupuesto_asociado != null : "fx:id=\"cbx_presupuesto_asociado\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert txt_numero_cuenta != null : "fx:id=\"txt_numero_cuenta\" was not injected: check your FXML file 'GestionCuentas.fxml'.";
        assert sp_gestion_cuentas != null : "fx:id=\"sp_gestion_cuentas\" was not injected: check your FXML file 'GestionCuentas.fxml'.";

    }
}
