package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario.CategoriasController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;
import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.MetodosReutilizables.*;

public class CategoriasViewController {

    private UsuarioDto usuario;
    private CategoriasController categoriasController;
    ObservableList<CategoriaDto> listaCategorias = FXCollections.observableArrayList();
    CategoriaDto categoriaSeleccionada;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bt_eliminar;

    @FXML
    private TextField tf_nombreCategoria;

    @FXML
    private Label lb_idCategoria;

    @FXML
    private Button bt_actualizar;

    @FXML
    private Label lb_nombreCategoria;

    @FXML
    private Button bt_nuevo;

    @FXML
    private TextField tf_descripcion;

    @FXML
    private TextField tf_idCategoria;

    @FXML
    private Label lb_titulo;

    @FXML
    private TableColumn<CategoriaDto, String> cl_descripcion;

    @FXML
    private TableView<CategoriaDto> tb_categorias;

    @FXML
    private TableColumn<CategoriaDto, String> cl_nombre;

    @FXML
    private TableColumn<CategoriaDto, String> cl_presupuesto;

    @FXML
    private Label lb_descripcion;

    @FXML
    private Button bt_limpiar;

    @FXML
    private TableColumn<CategoriaDto, Integer> cl_idCategoria;

    @FXML
    void onNuevo() {
        agregarCategoria();
    }

    @FXML
    void onActualizar() {
        actualizarCategoria();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarCategoria();
    }

    @FXML
    void initialize() {
        categoriasController = new CategoriasController();
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
        initView();
    }

    private CategoriaDto crearCategoria() {
        return new CategoriaDto(Integer.parseInt(tf_idCategoria.getText()), usuario.idUsuario(),
                tf_nombreCategoria.getText(), tf_descripcion.getText(), null);
    }

    private void agregarCategoria() {
        if (validarCamposCompletos()) {
            if (validarCamposValidos()) {
                CategoriaDto categoria = crearCategoria();
                if (categoriasController.agregarCategoria(categoria, usuario.idUsuario())) {
                    listaCategorias.add(categoria);
                    tb_categorias.refresh();
                    limpiarSeleccion();
                    mostrarMensaje(TITULO_CATEGORIA_AGREGADA, BODY_CATEGORIA_AGREGADA, Alert.AlertType.INFORMATION);
                }
                else {
                    mostrarMensaje(TITULO_CATEGORIA_NO_AGREGADA, BODY_CATEGORIA_NO_AGREGADA, Alert.AlertType.ERROR);
                }
            }
            else {
                mostrarMensaje(TITULO_INCORRECTO, BODY_INCORRECTO, Alert.AlertType.WARNING);
            }
        }
        else {
            mostrarMensaje(TITULO_CATEGORIA_NO_AGREGADA, BODY_CATEGORIA_NO_AGREGADA, Alert.AlertType.WARNING);
        }
    }

    private void actualizarCategoria() {
        if (categoriaSeleccionada != null) {
            if (validarCamposCompletos()) {
                if (validarCamposValidos()) {
                    CategoriaDto categoriaNueva = crearCategoria();
                    if (categoriasController.actualizarCategoria(usuario.idUsuario(),
                            categoriaSeleccionada.idCategoria(), categoriaNueva)){
                        intercambiarCategorias(categoriaSeleccionada.idCategoria(), categoriaNueva);
                        limpiarSeleccion();
                        tb_categorias.refresh();
                        mostrarMensaje(TITULO_CATEGORIA_ACTUALIZADA,
                                BODY_CATEGORIA_ACTUALIZADA, Alert.AlertType.INFORMATION);
                    }
                    else {
                        mostrarMensaje(TITULO_CATEGORIA_NO_ACTUALIZADA,
                                BODY_CATEGORIA_NO_ACTUALIZADA, Alert.AlertType.ERROR);
                    }
                }
                else {
                    mostrarMensaje(TITULO_INCORRECTO, BODY_INCORRECTO, Alert.AlertType.WARNING);
                }
            }
            else {
                mostrarMensaje(TITULO_CATEGORIA_NO_AGREGADA,
                        BODY_CATEGORIA_NO_AGREGADA, Alert.AlertType.WARNING);
            }
        }
        else {
            mostrarMensaje(TITULO_CATEGORIA_NO_SELECCIONADA,
                    BODY_CATEGORIA_NO_SELECCIONADA, Alert.AlertType.WARNING);
        }
    }


    private void eliminarCategoria() {
        if (categoriaSeleccionada != null) {
            if (mostrarMensajeConfirmacion(BODY_CONFIRMACION_ELIMINAR_CATEGORIA) &&
                    categoriasController.
                            eliminarCategoria(usuario.idUsuario(), categoriaSeleccionada.idCategoria())) {
                listaCategorias.remove(categoriaSeleccionada);
                limpiarSeleccion();
                mostrarMensaje(TITULO_CATEGORIA_ELIMINADA, BODY_CATEGORIA_ELIMINADA, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_CATEGORIA_NO_ELIMINADA, BODY_CATEGORIA_NO_ELIMINADA, Alert.AlertType.ERROR);
            }
        }
        else {
            mostrarMensaje(TITULO_CATEGORIA_NO_SELECCIONADA,
                    BODY_CATEGORIA_NO_SELECCIONADA, Alert.AlertType.WARNING);
        }
    }

    private void intercambiarCategorias(int idCategoria, CategoriaDto categoriaNueva) {
        for (int i = 0; i < listaCategorias.size(); i++) {
            CategoriaDto categoria = listaCategorias.get(i);
            if (categoria.idCategoria() == idCategoria) {
                listaCategorias.set(i, categoriaNueva);
            }
        }
    }

    private boolean validarCamposCompletos() {
        return !tf_nombreCategoria.getText().isEmpty() &&
                !tf_idCategoria.getText().isEmpty();
    }

    private boolean validarCamposValidos(){
        return esTipoInteger(tf_idCategoria.getText());
    }

    private void mostrarInformacionCategoria(CategoriaDto categoria) {
        if (categoria != null) {
            tf_nombreCategoria.setText(categoria.nombre());
            tf_descripcion.setText(categoria.descripcion());
            tf_idCategoria.setText(String.valueOf(categoria.idCategoria()));
        }
    }

    private void initView() {
        initDataBinding();
        obtenerCategorias();
        tb_categorias.getItems().clear();
        tb_categorias.setItems(listaCategorias);
        listenerSelection();
    }

    private void initDataBinding() {
        cl_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        cl_idCategoria.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().idCategoria()).asObject());
        cl_descripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        cl_presupuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().presupuesto()));
    }

    private void obtenerCategorias() {
        listaCategorias.addAll(categoriasController.obtenerCategorias(usuario.idUsuario()));
    }

    private void listenerSelection(){
        tb_categorias.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            categoriaSeleccionada = newSelection;
            mostrarInformacionCategoria(categoriaSeleccionada);
        });
    }

    private void limpiarSeleccion() {
        tb_categorias.getSelectionModel().clearSelection();
        limpiarCamposTexto();
    }

    private void limpiarCamposTexto() {
        tf_nombreCategoria.clear();
        tf_idCategoria.clear();
        tf_descripcion.clear();
    }
}
