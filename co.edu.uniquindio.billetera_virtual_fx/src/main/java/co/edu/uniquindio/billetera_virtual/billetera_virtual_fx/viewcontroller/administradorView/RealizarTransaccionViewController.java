package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.administradorView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class RealizarTransaccionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_realizar_transaccion;

    @FXML
    private TableColumn<?, ?> tc_id_transaccion;

    @FXML
    private ComboBox<?> cbx_tipo_transaccion;

    @FXML
    private TextField txt_descripcion;

    @FXML
    private TableColumn<?, ?> tc_tipo_transaccion;

    @FXML
    private TableColumn<?, ?> tc_cuenta_destino;

    @FXML
    private ComboBox<?> cbx_cuentas_origen;

    @FXML
    private ComboBox<?> cbx_usuario;

    @FXML
    private TextField txt_id_transaccion;

    @FXML
    private DatePicker dp_fecha;

    @FXML
    private TableColumn<?, ?> tc_monto;

    @FXML
    private TableColumn<?, ?> tc_fecha;

    @FXML
    private SplitPane sp_centro_transacciones;

    @FXML
    private TableColumn<?, ?> tc_descripcion;

    @FXML
    private TableColumn<?, ?> tc_cuenta_origen;

    @FXML
    private ComboBox<?> cbx_cuentas_destino;

    @FXML
    void on_realizar_transaccion() {

    }

    @FXML
    void initialize() {
        assert btn_realizar_transaccion != null : "fx:id=\"btn_realizar_transaccion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_id_transaccion != null : "fx:id=\"tc_id_transaccion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert cbx_tipo_transaccion != null : "fx:id=\"cbx_tipo_transaccion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert txt_descripcion != null : "fx:id=\"txt_descripcion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_tipo_transaccion != null : "fx:id=\"tc_tipo_transaccion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_cuenta_destino != null : "fx:id=\"tc_cuenta_destino\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert cbx_cuentas_origen != null : "fx:id=\"cbx_cuentas_origen\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert cbx_usuario != null : "fx:id=\"cbx_usuario\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert txt_id_transaccion != null : "fx:id=\"txt_id_transaccion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert dp_fecha != null : "fx:id=\"dp_fecha\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_monto != null : "fx:id=\"tc_monto\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_fecha != null : "fx:id=\"tc_fecha\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert sp_centro_transacciones != null : "fx:id=\"sp_centro_transacciones\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_descripcion != null : "fx:id=\"tc_descripcion\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert tc_cuenta_origen != null : "fx:id=\"tc_cuenta_origen\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";
        assert cbx_cuentas_destino != null : "fx:id=\"cbx_cuentas_destino\" was not injected: check your FXML file 'RealizarTransaccion.fxml'.";

    }
}

