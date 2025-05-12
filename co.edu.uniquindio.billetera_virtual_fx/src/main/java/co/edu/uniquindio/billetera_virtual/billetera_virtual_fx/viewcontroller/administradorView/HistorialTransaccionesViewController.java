package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.administradorView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;

public class HistorialTransaccionesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_filtar;

    @FXML
    private TableColumn<?, ?> tc_descripccion_busqueda;

    @FXML
    private TableColumn<?, ?> tc_cuenta_destino_busqueda;

    @FXML
    private ComboBox<?> cbx_usuario;

    @FXML
    private DatePicker dp_fecha_inicial;

    @FXML
    private DatePicker dp_fecha_final;

    @FXML
    private SplitPane sp_historial_transacciones;

    @FXML
    private Button btn_limpiar;

    @FXML
    private TableColumn<?, ?> tc_fecha_busqueda;

    @FXML
    private TableColumn<?, ?> tc_id_transaccion_busqueda;

    @FXML
    private TableColumn<?, ?> tc_tipo_transaccion_busqueda;

    @FXML
    private ComboBox<?> cbx_tipo_transaccion_busqueda;

    @FXML
    private TableColumn<?, ?> tc_cuenta_origen_busqueda;

    @FXML
    private TableColumn<?, ?> tc_monto_busqueda;

    @FXML
    void on_filtrar_transaccion() {

    }

    @FXML
    void on_limpiar_campos() {

    }

    @FXML
    void initialize() {
        assert btn_filtar != null : "fx:id=\"btn_filtar\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_descripccion_busqueda != null : "fx:id=\"tc_descripccion_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_cuenta_destino_busqueda != null : "fx:id=\"tc_cuenta_destino_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert cbx_usuario != null : "fx:id=\"cbx_usuario\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert dp_fecha_inicial != null : "fx:id=\"dp_fecha_inicial\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert dp_fecha_final != null : "fx:id=\"dp_fecha_final\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert sp_historial_transacciones != null : "fx:id=\"sp_historial_transacciones\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert btn_limpiar != null : "fx:id=\"btn_limpiar\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_fecha_busqueda != null : "fx:id=\"tc_fecha_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_id_transaccion_busqueda != null : "fx:id=\"tc_id_transaccion_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_tipo_transaccion_busqueda != null : "fx:id=\"tc_tipo_transaccion_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert cbx_tipo_transaccion_busqueda != null : "fx:id=\"cbx_tipo_transaccion_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_cuenta_origen_busqueda != null : "fx:id=\"tc_cuenta_origen_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";
        assert tc_monto_busqueda != null : "fx:id=\"tc_monto_busqueda\" was not injected: check your FXML file 'HistorialTransacciones.fxml'.";

    }
}
