package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.AdministradorController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class AdministradorViewController {

    AdministradorController administradorController;
    ObservableList<UsuarioDto> listaUsuarios = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarUsuario;

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private TableView<UsuarioDto> tableUsuarios;

    @FXML
    private TableColumn<UsuarioDto, String> tcApellidos;

    @FXML
    private TableColumn<UsuarioDto, String> tcDireccion;

    @FXML
    private TableColumn<UsuarioDto, String> tcEmail;

    @FXML
    private TableColumn<UsuarioDto, String> tcIdUsuario;

    @FXML
    private TableColumn<UsuarioDto, String> tcNombre;

    @FXML
    private TableColumn<UsuarioDto, String> tcTelefono;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtIdUsuario;



    @FXML
    void initialize() {
        administradorController = new AdministradorController();
        initView();
    }

    @FXML
    void OnCrearUsuario(ActionEvent event) {
        crearUsuario();
    }

    @FXML
    void OnActualizarUsuario(ActionEvent event) {
        actualizaUsuario();

    }

    private void actualizaUsuario() {
        UsuarioDto usuarioDto = crearUsuarioDto();
        if(datosValidos(usuarioDto)){
            if(administradorController.actualizarUsuario(usuarioDto)){
                tableUsuarios.refresh();
                limpiarDatos();
                mostrarMensaje(TITULO_USUARIO_ACTUALIZADO, HEADER, CUERPO_USUARIO_ACTUALIZADO, Alert.AlertType.INFORMATION);

            } else {
                mostrarMensaje(TITULO_USUARIO_NO_EXISTE, HEADER, CUERPO_USUARIO_NO_EXISTE, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, CUERPO_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void OnEliminarUsuario(ActionEvent event) {
        eliminarUsuario();
    }

    private void eliminarUsuario() {
        UsuarioDto usuarioDto = crearUsuarioDto();
        if(datosValidos(usuarioDto)){
            if(administradorController.elimiarUsuario(usuarioDto)){
                listaUsuarios.remove(usuarioDto);
                limpiarDatos();
                mostrarMensaje(TITULO_USUARIO_ELIMINADO, HEADER, CUERPO_USUARIO_ELIMIADO, Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje(TITULO_USUARIO_NO_EXISTE, HEADER, CUERPO_USUARIO_NO_EXISTE, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, CUERPO_INCOMPLETO, Alert.AlertType.WARNING);
        }

    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    private void initView() {
        initDataBinding();
        obtenerUsuarios();
        tableUsuarios.getItems().clear();
        tableUsuarios.setItems(listaUsuarios);
        listenerSelection();
    }

    private void obtenerUsuarios() {
        listaUsuarios.addAll(administradorController.obtenerUsuarios());

    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellidos()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefono()));
        tcIdUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idUsuario()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
    }

    private void listenerSelection() {
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }

    private void crearUsuario() {
        UsuarioDto usuarioDto = crearUsuarioDto();
        if(datosValidos(usuarioDto)){
            if(administradorController.crearUsuario(usuarioDto)){
                listaUsuarios.addAll(usuarioDto);
                limpiarDatos();
            } else {
                mostrarMensaje(TITULO_USUARIO_NO_CREADO, HEADER, CUERPO_USUARIO_NO_CREADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, CUERPO_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void limpiarDatos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtIdUsuario.setText("");
        txtDireccion.setText("");
    }

    private UsuarioDto crearUsuarioDto() {
        return new UsuarioDto(
                txtNombre.getText(),
                txtApellidos.getText(),
                txtEmail.getText(),
                txtTelefono.getText(),
                txtIdUsuario.getText(),
                txtDireccion.getText());
    }

    private boolean datosValidos(UsuarioDto usuarioDto) {
        if(usuarioDto.nombre().isEmpty() ||
                usuarioDto.apellidos().isEmpty() ||
                usuarioDto.email().isEmpty() ||
                usuarioDto.telefono().isEmpty() ||
                usuarioDto.idUsuario().isEmpty() ||
                usuarioDto.direccion().isEmpty()){
            return false;
        }
        return true;
    }

    private void mostrarInformacionUsuario(UsuarioDto usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtNombre.setText(usuarioSeleccionado.nombre());
            txtApellidos.setText(usuarioSeleccionado.apellidos());
            txtEmail.setText(usuarioSeleccionado.email());
            txtTelefono.setText(usuarioSeleccionado.telefono());
            txtIdUsuario.setText(usuarioSeleccionado.idUsuario());
            txtDireccion.setText(usuarioSeleccionado.direccion());
        }
    }
}
