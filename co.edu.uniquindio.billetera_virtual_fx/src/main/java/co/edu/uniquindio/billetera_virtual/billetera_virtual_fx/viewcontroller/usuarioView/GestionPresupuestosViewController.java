package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GestionPresupuestosViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tc_monto_gastado;

    @FXML
    private TextField txt_nombre_presupuesto;

    @FXML
    private Button btn_eliminar_presupuesto;

    @FXML
    private SplitPane sp_gestion_presupuestos;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private TableColumn<?, ?> tc_categoria;

    @FXML
    private TextField txt_id_presupuesto;

    @FXML
    private AnchorPane ap_presupuestos;

    @FXML
    private TableColumn<?, ?> tc_nombre;

    @FXML
    private TableColumn<?, ?> tc_cuenta_asociada;

    @FXML
    private Button btn_actualizar_presupuesto;

    @FXML
    private TableColumn<?, ?> tc_monto_limite;

    @FXML
    private TextField txt_monto_limite;

    @FXML
    private Button btn_agregar_presupuesto;

    @FXML
    private ComboBox<?> cbx_categoria;

    @FXML
    private TableColumn<?, ?> tc_id_presupuesto;

    @FXML
    void on_agregar_presupuesto() {

    }

    @FXML
    void on_actualizar_presupuesto() {

    }

    @FXML
    void on_limpiar_campos() {

    }

    @FXML
    void on_eliminar_presupuesto() {

    }

    @FXML
    void initialize() {
        assert tc_monto_gastado != null : "fx:id=\"tc_monto_gastado\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert txt_nombre_presupuesto != null : "fx:id=\"txt_nombre_presupuesto\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert btn_eliminar_presupuesto != null : "fx:id=\"btn_eliminar_presupuesto\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert sp_gestion_presupuestos != null : "fx:id=\"sp_gestion_presupuestos\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert btn_limpiar_campos != null : "fx:id=\"btn_limpiar_campos\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert tc_categoria != null : "fx:id=\"tc_categoria\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert txt_id_presupuesto != null : "fx:id=\"txt_id_presupuesto\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert ap_presupuestos != null : "fx:id=\"ap_presupuestos\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert tc_nombre != null : "fx:id=\"tc_nombre\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert tc_cuenta_asociada != null : "fx:id=\"tc_cuenta_asociada\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert btn_actualizar_presupuesto != null : "fx:id=\"btn_actualizar_presupuesto\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert tc_monto_limite != null : "fx:id=\"tc_monto_limite\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert txt_monto_limite != null : "fx:id=\"txt_monto_limite\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert btn_agregar_presupuesto != null : "fx:id=\"btn_agregar_presupuesto\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert cbx_categoria != null : "fx:id=\"cbx_categoria\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";
        assert tc_id_presupuesto != null : "fx:id=\"tc_id_presupuesto\" was not injected: check your FXML file 'GestionPresupuestos.fxml'.";

    }
}

