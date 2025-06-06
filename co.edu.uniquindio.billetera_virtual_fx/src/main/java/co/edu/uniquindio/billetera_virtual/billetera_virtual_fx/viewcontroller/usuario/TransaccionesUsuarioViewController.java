package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario.TransaccionesUsuarioController;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.TipoTransaccion;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.*;
import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.MetodosReutilizables.*;

public class TransaccionesUsuarioViewController {

    private UsuarioDto usuario;
    private TransaccionesUsuarioController transaccionesUsuarioController;
    ObservableList<TransaccionDto> listaTransacciones = FXCollections.observableArrayList();
    TransaccionDto transaccionSeleccionada;
    private FilteredList<String> filtroCuentasDestino;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<TipoTransaccion> cb_tipoTransaccion;

    @FXML
    private Button bt_realizarTransaccion;

    @FXML
    private TableColumn<TransaccionDto, String> cl_cuentaOrigen;

    @FXML
    private TableColumn<TransaccionDto, String> cl_cuentaDestino;

    @FXML
    private TextField tf_monto;

    @FXML
    private TextField tf_descripcion;

    @FXML
    private DatePicker dp_fecha;

    @FXML
    private TableColumn<TransaccionDto, Integer> cl_idTransaccion;

    @FXML
    private TableColumn<TransaccionDto, String> cl_descripcion;

    @FXML
    private ComboBox<String> cb_cuentaOrigen;

    @FXML
    private TableColumn<TransaccionDto, Double> cl_monto;

    @FXML
    private TableView<TransaccionDto> tb_transacciones;

    @FXML
    private TableColumn<TransaccionDto, String> cl_fecha;

    @FXML
    private TableColumn<TransaccionDto, String> cl_tipoCategoria;

    @FXML
    private ComboBox<String> cb_cuentaDestino;

    @FXML
    private Button bt_limpiar;

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onRealizarTransaccion() {
        realizarMovimiento();
    }

    @FXML
    void initialize() {
        transaccionesUsuarioController = new TransaccionesUsuarioController();
        seleccionCategoria();
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
        initView();
        initCBoxes();
    }

    private void listaFiltrada(LinkedList<String> listaCuentasDestino) {
        ObservableList<String> listaCuentasDestinoFiltrada = FXCollections.observableArrayList(listaCuentasDestino);
        filtroCuentasDestino = new FilteredList<>(listaCuentasDestinoFiltrada, cuentas -> true);
        cb_cuentaDestino.setItems(filtroCuentasDestino);
    }

    private void initView() {
        initDataBinding();
        obtenerTransacciones();
        tb_transacciones.getItems().clear();
        tb_transacciones.setItems(listaTransacciones);
        listenerSelection();
    }

    private void obtenerTransacciones() {
        listaTransacciones.addAll(transaccionesUsuarioController.obtenerTransacciones(usuario.idUsuario()));
    }

    private void listenerSelection(){
        tb_transacciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            transaccionSeleccionada = newSelection;
            mostrarInformacionTransaccion(transaccionSeleccionada);
        });
    }

    private void mostrarInformacionTransaccion(TransaccionDto transaccionSeleccionada) {
        if (transaccionSeleccionada != null) {
            cb_tipoTransaccion.getSelectionModel().select(transaccionSeleccionada.tipoTransaccion());
            dp_fecha.setValue(transaccionSeleccionada.fecha());
            tf_monto.setText(Double.toString(transaccionSeleccionada.monto()));
            tf_descripcion.setText(transaccionSeleccionada.descripcion());
            cb_cuentaOrigen.getSelectionModel().select(transaccionSeleccionada.numCuentaOrigen());
            cb_cuentaDestino.getSelectionModel().select(transaccionSeleccionada.numCuentaDestino());
        }
    }

    private TransaccionDto crearTransaccion(){
        return new TransaccionDto(
                transaccionesUsuarioController.obtenerNuevoIdTransaccion(),
                dp_fecha.getValue(),
                Double.parseDouble(tf_monto.getText()),
                tf_descripcion.getText(),
                usuario.idUsuario(),
                cb_cuentaOrigen.getSelectionModel().getSelectedItem(),
                cb_cuentaDestino.getSelectionModel().getSelectedItem(),
                cb_tipoTransaccion.getSelectionModel().getSelectedItem());
    }

    private void initCBoxes() {
        cb_tipoTransaccion.getItems().addAll();
        cb_tipoTransaccion.getItems().addAll(TipoTransaccion.values());
        cb_tipoTransaccion.setOnAction(event -> seleccionCategoria());
        cb_cuentaOrigen.setOnAction(event -> seleccionCuentaOrigen());
        LinkedList<String> listaNumCuentas = transaccionesUsuarioController.obtenerNumCuentasUsuario(usuario.idUsuario());
        cb_cuentaOrigen.getItems().addAll(listaNumCuentas);
        listaFiltrada(listaNumCuentas);
    }

    private void realizarMovimiento() {
        if (validarCamposCompletos()) {
            if (validarCamposValidos()) {
                TipoTransaccion tipoTransaccion = cb_tipoTransaccion.getSelectionModel().getSelectedItem();
                TransaccionDto transaccionDto = crearTransaccion();
                if (tipoTransaccion.equals(TipoTransaccion.DEPOSITO)) {
                    realizarDeposito(transaccionDto);
                }
                else if (tipoTransaccion.equals(TipoTransaccion.TRANSFERENCIA)) {
                    realizarTransferencia(transaccionDto);
                }
                else if (tipoTransaccion.equals(TipoTransaccion.RETIRO)) {
                    realizarRetiro(transaccionDto);
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

    private void realizarDeposito(TransaccionDto transaccionDto) {
        if (transaccionesUsuarioController.agregarTransaccion(transaccionDto, usuario.idUsuario())){
            mostrarMensajeTransaccionExitosa(transaccionDto);
            listaTransacciones.add(transaccionDto);
        }
        else {
            mostrarMensaje(TITLE_DEPOSIT_NO_EXITOSO, BODY_DEPOSIT_NO_EXITOSO, Alert.AlertType.ERROR);
        }
    }

    private boolean falloSacarDinero(TransaccionDto transaccionDto) {
        if (transaccionesUsuarioController.saldoCuentaEsSuficiente(transaccionDto)) {
            if (transaccionesUsuarioController.validarPresupuesto(transaccionDto)) {
                if (transaccionesUsuarioController.agregarTransaccion(transaccionDto, usuario.idUsuario())){
                    mostrarMensajeTransaccionExitosa(transaccionDto);
                    listaTransacciones.add(transaccionDto);
                }
            }
            else {
                mostrarMensaje(TITLE_BUDGET_SUPERADO, BODY_BUDGET_SUPERADO, Alert.AlertType.ERROR);
            }
            return false;
        }
        return true;
    }

    private void realizarRetiro(TransaccionDto transaccionDto) {
        if (falloSacarDinero(transaccionDto)) {
            mostrarMensaje(TITLE_WITHDRAWAL_NO_EXITOSO,
                    BODY_WITHDRAWAL_NO_EXITOSO, Alert.AlertType.ERROR);
        }
    }

    private void realizarTransferencia(TransaccionDto transaccionDto) {
        if (falloSacarDinero(transaccionDto)) {
            mostrarMensaje(TITLE_TRANSFER_NO_EXITOSA,
                    BODY_TRANSFER_NO_EXITOSA_NO_BALANCE, Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensajeTransaccionExitosa(TransaccionDto transaccionDto) {
        String mensajeMonto = transaccionDto.monto() + " pesos.";
        if (transaccionDto.tipoTransaccion().equals(TipoTransaccion.DEPOSITO)) {
            mostrarMensaje(TITLE_DEPOSIT_EXITOSO,
                    BODY_DEPOSIT_EXITOSO + mensajeMonto,
                    Alert.AlertType.INFORMATION);
        }
        else if (transaccionDto.tipoTransaccion().equals(TipoTransaccion.TRANSFERENCIA)) {
            mostrarMensaje(TITLE_TRANSFER_EXITOSA,
                    BODY_TRANSFER_EXITOSA + mensajeMonto,
                    Alert.AlertType.INFORMATION);

        }
        else if (transaccionDto.tipoTransaccion().equals(TipoTransaccion.RETIRO)) {
            mostrarMensaje(TITLE_WITHDRAWAL_EXITOSO,
                    BODY_WITHDRAWAL_EXITOSO + mensajeMonto,
                    Alert.AlertType.INFORMATION);
        }
        limpiarSeleccion();
    }

    private void limpiarSeleccion() {
        cb_tipoTransaccion.getSelectionModel().clearSelection();
        cb_cuentaOrigen.getSelectionModel().clearSelection();
        cb_tipoTransaccion.getSelectionModel().clearSelection();
        dp_fecha.setValue(null);
        cb_cuentaDestino.getSelectionModel().clearSelection();
        tf_monto.setText(null);
        tf_descripcion.setText(null);
        tb_transacciones.getSelectionModel().clearSelection();
        filtroCuentasDestino.setPredicate(cuenta -> true);
    }

    private void seleccionCuentaOrigen() {
        String cuentaOrigen = cb_cuentaOrigen.getSelectionModel().getSelectedItem();
        if (cuentaOrigen != null && cb_tipoTransaccion.getValue().equals(TipoTransaccion.TRANSFERENCIA)) {
            filtroCuentasDestino.setPredicate(cuenta -> !cuenta.equalsIgnoreCase(cuentaOrigen));
            cb_cuentaDestino.setDisable(false);
        }
    }

    private void seleccionCategoria() {
        TipoTransaccion tipoTransaccion = cb_tipoTransaccion.getSelectionModel().getSelectedItem();
        cb_cuentaOrigen.setDisable(false);
        cb_cuentaDestino.setDisable(false);
        tf_monto.setDisable(false);
        dp_fecha.setDisable(false);
        tf_descripcion.setDisable(false);
        if (tipoTransaccion == null) {
            cb_cuentaOrigen.setDisable(true);
            cb_cuentaDestino.setDisable(true);
            tf_monto.setDisable(true);
            dp_fecha.setDisable(true);
            tf_descripcion.setDisable(true);
        } else {
            limpiarCampos();
            cb_cuentaDestino.setDisable(true);
        }
    }

    private void limpiarCampos() {
        cb_cuentaOrigen.getSelectionModel().clearSelection();
        dp_fecha.setValue(null);
        cb_cuentaDestino.getSelectionModel().clearSelection();
        tf_monto.clear();
        tf_descripcion.clear();
    }

    private boolean validarCamposCompletos() {
        if (!cb_tipoTransaccion.getSelectionModel().isEmpty()
                && !cb_cuentaOrigen.getSelectionModel().isEmpty()
                && dp_fecha.getValue() != null
                && !tf_monto.getText().isEmpty()) {
            if (cb_tipoTransaccion.getValue().equals(TipoTransaccion.TRANSFERENCIA)) {
                return !cb_cuentaDestino.getSelectionModel().isEmpty();
            }
            return true;
        }
        return false;
    }

    private boolean validarCamposValidos(){
        return esTipoDouble(tf_monto.getText());
    }

    private void initDataBinding() {
        cl_idTransaccion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().idTransaccion()).asObject());
        cl_fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha().toString()));
        cl_monto.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().monto()).asObject());
        cl_descripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        cl_cuentaDestino.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numCuentaDestino()));
        cl_cuentaOrigen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numCuentaOrigen()));
        cl_tipoCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tipoTransaccion().name()));
    }
}
