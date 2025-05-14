package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuarioController.GestionPresupuestosController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.PresupuestoDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.CategoriaObserver;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GestionPresupuestosViewController{

    GestionPresupuestosController gestionPresupuestosController;
    ObservableList<PresupuestoDto> listaPresupuestos = FXCollections.observableArrayList();
    PresupuestoDto presupuestoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ap_presupuestos;

    @FXML
    private Button btn_actualizar_presupuesto;

    @FXML
    private Button btn_agregar_presupuesto;

    @FXML
    private Button btn_eliminar_presupuesto;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private ComboBox<?> cbx_categoria;

    @FXML
    private SplitPane sp_gestion_presupuestos;

    @FXML
    private TableView<PresupuestoDto> tablePresupuesto;

    @FXML
    private TableColumn<PresupuestoDto, String> tc_categoria;

    @FXML
    private TableColumn<PresupuestoDto, String> tc_cuenta_asociada;

    @FXML
    private TableColumn<PresupuestoDto, String> tc_id_presupuesto;

    @FXML
    private TableColumn<PresupuestoDto, String> tc_monto_gastado;

    @FXML
    private TableColumn<PresupuestoDto, String> tc_monto_limite;

    @FXML
    private TableColumn<PresupuestoDto, String> tc_nombre;

    @FXML
    private TextField txt_id_presupuesto;

    @FXML
    private TextField txt_monto_limite;

    @FXML
    private TextField txt_nombre_presupuesto;

    @FXML
    void on_actualizar_presupuesto(ActionEvent event) {

    }

    @FXML
    void on_agregar_presupuesto(ActionEvent event) {

    }

    @FXML
    void on_cbx_categoria(ActionEvent event) {

    }

    @FXML
    void on_eliminar_presupuesto(ActionEvent event) {

    }

    @FXML
    void on_limpiar_campos(ActionEvent event) {

    }

    @FXML
    void initialize() {
        gestionPresupuestosController = new GestionPresupuestosController();

    }

    private UsuarioDto usuarioDto;

    public void setUsuario(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerPresupuestos();
        tablePresupuesto.getItems().clear();
        tablePresupuesto.setItems(listaPresupuestos);
        listenerSelection();
    }

    private void initDataBinding() {
        tc_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tc_id_presupuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tc_categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria()));
        tc_cuenta_asociada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cuentaAsociada()));
        tc_monto_gastado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().montoGastado())));
        tc_monto_limite.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().montoLimite())));

    }

    private void obtenerPresupuestos() {
        listaPresupuestos.clear();
        listaPresupuestos.addAll(gestionPresupuestosController.obtenerPresupuestos(usuarioDto));
    }

    private void listenerSelection() {
        tablePresupuesto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            presupuestoSeleccionado = newSelection;
            mostrarInformacionPresupuesto(presupuestoSeleccionado);
        });
    }

    private void mostrarInformacionPresupuesto(PresupuestoDto presupuestoSeleccionado) {
        if(presupuestoSeleccionado!= null){
            txt_nombre_presupuesto.setText(presupuestoSeleccionado.nombre());
            txt_id_presupuesto.setText(presupuestoSeleccionado.id());
            txt_monto_limite.setText(String.valueOf(presupuestoSeleccionado.montoLimite()));
        }

    }


}

