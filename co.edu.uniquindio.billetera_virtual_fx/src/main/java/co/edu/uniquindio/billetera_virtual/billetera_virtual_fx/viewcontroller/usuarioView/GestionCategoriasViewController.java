package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuarioController.GestionCategoriasController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class GestionCategoriasViewController {

    GestionCategoriasController gestionCategoriasController;
    ObservableList<CategoriaDto> listaCategorias = FXCollections.observableArrayList();
    CategoriaDto categoriaSeleccionada;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_agregar_categoria;

    @FXML
    private TableView<CategoriaDto> tableCategoria;

    @FXML
    private TextField txt_descripcion;

    @FXML
    private Button btn_limpiar_campos;

    @FXML
    private TextField txt_nombre_categoria;

    @FXML
    private Button btn_eliminar_categoria;

    @FXML
    private TableColumn<CategoriaDto, String> tc_id_categoria;

    @FXML
    private TextField txt_id_categoria;

    @FXML
    private TableColumn<CategoriaDto, String> tc_presupuesto_asociado;

    @FXML
    private AnchorPane ap_gestion_categorias;

    @FXML
    private SplitPane sp_gestion_categorias;

    @FXML
    private TableColumn<CategoriaDto, String> tc_nombre_categoria;

    @FXML
    private TableColumn<CategoriaDto, String> tc_descripcion;

    @FXML
    private Button btn_actualizar_categoria;

    @FXML
    void on_agregar_categoria() {
        agregarCategoria();

    }

    private void agregarCategoria() {
        CategoriaDto categoriaDto = crearCategoriaDto();
        if(validarDatos(categoriaDto)){
            if(gestionCategoriasController.agregarCategoria(categoriaDto, usuarioDto)){
                listaCategorias.add(categoriaDto);
                limpiarCampos();


            }

        }
    }

    private boolean validarDatos(CategoriaDto categoriaDto) {
        if(!txt_id_categoria.getText().isEmpty() &&
                !txt_descripcion.getText().isEmpty() &&
                !txt_nombre_categoria.getText().isEmpty()){
            return true;
        }
        return false;
    }

    private CategoriaDto crearCategoriaDto() {
        CategoriaDto categoriaDto = new CategoriaDto(
                txt_id_categoria.getText(),
                txt_nombre_categoria.getText(),
                txt_descripcion.getText(),
                null
        );
        return categoriaDto;
    }

    @FXML
    void on_limpiar_campos() {
        limpiarCampos();

    }

    private void limpiarCampos() {
        txt_nombre_categoria.setText("");
        txt_id_categoria.setText("");
        txt_descripcion.setText("");
    }

    @FXML
    void on_actualizar_categoria() {
        actualizarCategoria();

    }

    private void actualizarCategoria() {
    }

    @FXML
    void on_eliminar_categoria() {

    }

    @FXML
    void initialize() {
        gestionCategoriasController = new GestionCategoriasController();

    }

    private UsuarioDto usuarioDto;

    public void setUsuario(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerCategorias();
        tableCategoria.getItems().clear();
        tableCategoria.setItems(listaCategorias);
        listenerSelection();
    }

    private void obtenerCategorias() {
        listaCategorias.clear();
        listaCategorias.addAll(gestionCategoriasController.obtenerCategorias(usuarioDto));

    }

    private void initDataBinding() {
        tc_id_categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tc_nombre_categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tc_descripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        tc_presupuesto_asociado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().presupuestoAsociado()));
    }

    private void listenerSelection() {
        tableCategoria.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            categoriaSeleccionada = newSelection;
            mostrarInformacionCategoria(categoriaSeleccionada);
        });
    }

    private void mostrarInformacionCategoria(CategoriaDto categoriaSeleccionada) {
        if(categoriaSeleccionada != null){
            txt_nombre_categoria.setText(categoriaSeleccionada.nombre());
            txt_id_categoria.setText(categoriaSeleccionada.id());
            txt_descripcion.setText(categoriaSeleccionada.descripcion());
        }
    }

}

