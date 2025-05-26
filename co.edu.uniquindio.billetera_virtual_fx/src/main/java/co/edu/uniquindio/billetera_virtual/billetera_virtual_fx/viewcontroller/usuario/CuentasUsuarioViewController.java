package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario.CuentasUsuarioController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.TipoCuenta;
import javafx.beans.property.SimpleDoubleProperty;
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

public class CuentasUsuarioViewController {

    private UsuarioDto usuario;
    private CuentasUsuarioController cuentasUsuarioController;
    ObservableList<CuentaDto> listaCuentas = FXCollections.observableArrayList();
    CuentaDto cuentaSeleccionada;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bt_eliminar;

    @FXML
    private TableColumn<CuentaDto, String> cl_numeroCuenta;

    @FXML
    private ComboBox<String> cb_presupuestoAsociado;

    @FXML
    private TextField tf_nombreBanco;

    @FXML
    private Button bt_actualizar;

    @FXML
    private TableView<CuentaDto> tb_cuentas;

    @FXML
    private TableColumn<CuentaDto, String> cl_nombreBanco;

    @FXML
    private TableColumn<CuentaDto, Double> cl_saldo;

    @FXML
    private TableColumn<CuentaDto, Integer> cl_idCuenta;

    @FXML
    private TextField tf_numeroCuenta;

    @FXML
    private ComboBox<TipoCuenta> cb_tipoCuenta;

    @FXML
    private Button bt_nuevo;

    @FXML
    private TableColumn<CuentaDto, String> cl_tipoCuenta;

    @FXML
    private Label lb_numeroCuent;

    @FXML
    private TextField tf_idCuenta;

    @FXML
    private Button bt_limpiar;

    @FXML
    private Label lb_nombreBanc;

    @FXML
    private TableColumn<CuentaDto, String> cl_presupuestoAsociado;

    @FXML
    void onNuevo() {
        agregar();
    }

    @FXML
    void onActualizar() {
        actualizar();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminar();
    }

    @FXML
    void initialize() {
        cuentasUsuarioController = new CuentasUsuarioController();
        cb_tipoCuenta.getItems().addAll(TipoCuenta.values());
    }

    public void setUsuario(UsuarioDto usuarioDto) {
        usuario = usuarioDto;
        initView();
        setCBoxPresupuestos();
    }

    private void setCBoxPresupuestos() {
        cb_presupuestoAsociado.getItems().clear();
        cb_presupuestoAsociado.getItems().addAll(cuentasUsuarioController.obtenerPresupuestosDisponiblesNombres(usuario.idUsuario()));
    }

    private CuentaDto crearCuenta() {
        return new CuentaDto(Integer.parseInt(tf_idCuenta.getText()), tf_nombreBanco.getText(),
                tf_numeroCuenta.getText(), usuario.idUsuario(), cb_tipoCuenta.getValue(),
                0, cb_presupuestoAsociado.getValue());
    }

    private CuentaDto crearCuentaSaldo(Double saldo) {
        return new CuentaDto(Integer.parseInt(tf_idCuenta.getText()), tf_nombreBanco.getText(),
                tf_numeroCuenta.getText(), usuario.idUsuario(), cb_tipoCuenta.getValue(),
                saldo, cb_presupuestoAsociado.getValue());
    }

    private void agregar() {
        if (validarCamposCompletos()) {
            if (validarCamposValidos()) {
                CuentaDto cuenta = crearCuenta();
                if (cuentasUsuarioController.agregarCuentaUsuario(usuario.idUsuario(), cuenta)) {
                    listaCuentas.add(cuenta);
                    tb_cuentas.refresh();
                    setCBoxPresupuestos();
                    limpiarSeleccion();
                    mostrarMensaje(TITLE_ACCOUNT_AGREGADA, BODY_ACCOUNT_AGREGADA, Alert.AlertType.INFORMATION);
                }
                else{
                    mostrarMensaje(TITLE_ACCOUNT_NO_AGREGADA, BODY_ACCOUNT_NO_AGREGADA, Alert.AlertType.ERROR);
                }
            }
            else{
                mostrarMensaje(TITLE_INCORRECTO, BODY_INCORRECTO, Alert.AlertType.WARNING);
            }
        }
        else {
            mostrarMensaje(TITLE_INCOMPLETO, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }


    private void actualizar() {
        if (cuentaSeleccionada != null) {
            if (validarCamposCompletos()) {
                if (validarCamposValidos()) {
                    CuentaDto cuentaNueva = crearCuentaSaldo(cuentaSeleccionada.saldo());
                    if (cuentasUsuarioController.
                            actualizarCuentaUsuario(usuario.idUsuario(), cuentaSeleccionada, cuentaNueva)) {
                        intercambiarCuentas(cuentaSeleccionada.idCuenta(), cuentaNueva);
                        setCBoxPresupuestos();
                        limpiarSeleccion();
                        tb_cuentas.refresh();
                        mostrarMensaje(TITLE_ACCOUNT_ACTUALIZADA,
                                BODY_ACCOUNT_ACTUALIZADA, Alert.AlertType.INFORMATION);
                    }
                    else {
                        mostrarMensajeNoActualizarCuenta(cuentaSeleccionada);
                    }
                }
                else {
                    mostrarMensaje(TITLE_INCORRECTO, BODY_INCORRECTO, Alert.AlertType.WARNING);
                }
            }
            else {
                mostrarMensaje(TITLE_INCOMPLETO, BODY_INCOMPLETO, Alert.AlertType.WARNING);
            }
        }
        else {
            mostrarMensaje(TITLE_ACCOUNT_NO_SELECCIONADA,
                    BODY_ACCOUNT_NO_SELECCIONADA, Alert.AlertType.WARNING);
        }
    }

    private void mostrarMensajeNoActualizarCuenta(CuentaDto cuenta) {
        int idCuenta = Integer.parseInt(tf_idCuenta.getText());
        String numCuenta = tf_numeroCuenta.getText();
        if (cuentasUsuarioController.verificarCuentaId(idCuenta)
                && cuenta.idCuenta() != idCuenta) {
            mostrarMensaje(TITLE_ACCOUNT_NO_ACTUALIZADA, BODY_ACCOUNT_NO_ACTUALIZADA_ID, Alert.AlertType.ERROR);
        }
        if (cuentasUsuarioController.verificarNumeroCuenta(numCuenta)
                && !cuenta.numCuenta().equals(numCuenta)) {
            mostrarMensaje(TITLE_ACCOUNT_NO_ACTUALIZADA,
                    BODY_ACCOUNT_NO_ACTUALIZADA_NUM_CUENTA, Alert.AlertType.ERROR);
        }
    }

    private void intercambiarCuentas(int idCuenta, CuentaDto cuentaNueva) {
        for (int i = 0; i < listaCuentas.size(); i++) {
            CuentaDto cuenta = listaCuentas.get(i);
            if (cuenta.idCuenta() == idCuenta) {
                listaCuentas.set(i, cuentaNueva);
            }
        }
    }

    private void eliminar() {
        if (cuentaSeleccionada != null) {
            if (mostrarMensajeConfirmacion(BODY_CONFIRM_ELIMINAR_CUENTA) &&
                    cuentasUsuarioController.eliminarCuentaUsuario(usuario.idUsuario(),
                            cuentaSeleccionada.idCuenta(), cuentaSeleccionada.numCuenta())) {
                listaCuentas.remove(cuentaSeleccionada);
                setCBoxPresupuestos();
                limpiarSeleccion();
                mostrarMensaje(TITLE_ACCOUNT_ELIMINADA, BODY_ACCOUNT_ELIMINADA, Alert.AlertType.INFORMATION);
            }
        }
        else {
            mostrarMensaje(TITLE_ACCOUNT_NO_SELECCIONADA, BODY_ACCOUNT_NO_SELECCIONADA, Alert.AlertType.WARNING);
        }
    }

    private boolean validarCamposCompletos() {
        return !tf_numeroCuenta.getText().isEmpty() && !tf_idCuenta.getText().isEmpty()
                && !tf_nombreBanco.getText().isEmpty() && !cb_tipoCuenta.getSelectionModel().isEmpty()
                && !cb_presupuestoAsociado.getSelectionModel().getSelectedItem().isEmpty();
    }

    private boolean validarCamposValidos(){
        return esTipoInteger(tf_idCuenta.getText()) && esTipoLong(tf_numeroCuenta.getText());
    }

    private void mostrarInformacionCuenta(CuentaDto cuenta) {
        if (cuenta != null) {
            tf_idCuenta.setText(String.valueOf(cuenta.idCuenta()));
            tf_nombreBanco.setText(cuenta.nombreBanco());
            tf_numeroCuenta.setText(cuenta.numCuenta());
            cb_tipoCuenta.getSelectionModel().select(cuenta.tipoCuenta());
            cb_presupuestoAsociado.getSelectionModel().select(cuenta.presupuestoAsociado());
        }
    }

    private void initView() {
        initDataBinding();
        obtenerCuentas();
        tb_cuentas.getItems().clear();
        tb_cuentas.setItems(listaCuentas);
        listenerSelection();
    }

    private void initDataBinding() {
        cl_idCuenta.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().idCuenta()).asObject());
        cl_nombreBanco.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreBanco()));
        cl_numeroCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numCuenta()));
        cl_presupuestoAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().presupuestoAsociado()));
        cl_tipoCuenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipoCuenta().name()));
        cl_saldo.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().saldo()).asObject());
    }

    private void obtenerCuentas() {
        listaCuentas.addAll(cuentasUsuarioController.obtenerCuentas(usuario.idUsuario()));
    }

    private void listenerSelection(){
        tb_cuentas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cuentaSeleccionada = newSelection;
            mostrarInformacionCuenta(cuentaSeleccionada);
        });
    }

    private void limpiarSeleccion() {
        tb_cuentas.getSelectionModel().clearSelection();
        limpiarCamposTexto();
    }

    private void limpiarCamposTexto() {
        tf_numeroCuenta.clear();
        tf_idCuenta.clear();
        tf_nombreBanco.clear();
        cb_tipoCuenta.getSelectionModel().clearSelection();
        cb_presupuestoAsociado.getSelectionModel().select(null);
    }
}
