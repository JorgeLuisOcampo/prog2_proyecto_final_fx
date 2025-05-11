package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GestionCategoriasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_agregar_categoria;

    @FXML
    private TextField txt_descripcion;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private TextField txt_nombre_categoria;

    @FXML
    private Button btn_eliminar_categoria;

    @FXML
    private TableColumn<?, ?> tc_id_categoria;

    @FXML
    private TextField txt_id_categoria;

    @FXML
    private TableColumn<?, ?> tc_presupuesto_asociado;

    @FXML
    private AnchorPane ap_gestion_categorias;

    @FXML
    private SplitPane sp_gestion_categorias;

    @FXML
    private TableColumn<?, ?> tc_nombre_categoria;

    @FXML
    private TableColumn<?, ?> tc_descripcion;

    @FXML
    private Button btn_actualizar_categoria;

    @FXML
    void on_agregar_categoria() {

    }

    @FXML
    void on_limpiar_campos() {

    }

    @FXML
    void on_actualizar_categoria() {

    }

    @FXML
    void on_eliminar_categoria() {

    }

    @FXML
    void initialize() {
        assert btn_agregar_categoria != null : "fx:id=\"btn_agregar_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert txt_descripcion != null : "fx:id=\"txt_descripcion\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert btn_limpiar_campos != null : "fx:id=\"btn_limpiar_campos\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert txt_nombre_categoria != null : "fx:id=\"txt_nombre_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert btn_eliminar_categoria != null : "fx:id=\"btn_eliminar_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert tc_id_categoria != null : "fx:id=\"tc_id_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert txt_id_categoria != null : "fx:id=\"txt_id_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert tc_presupuesto_asociado != null : "fx:id=\"tc_presupuesto_asociado\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert ap_gestion_categorias != null : "fx:id=\"ap_gestion_categorias\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert sp_gestion_categorias != null : "fx:id=\"sp_gestion_categorias\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert tc_nombre_categoria != null : "fx:id=\"tc_nombre_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert tc_descripcion != null : "fx:id=\"tc_descripcion\" was not injected: check your FXML file 'GestionCategorias.fxml'.";
        assert btn_actualizar_categoria != null : "fx:id=\"btn_actualizar_categoria\" was not injected: check your FXML file 'GestionCategorias.fxml'.";

    }
}

