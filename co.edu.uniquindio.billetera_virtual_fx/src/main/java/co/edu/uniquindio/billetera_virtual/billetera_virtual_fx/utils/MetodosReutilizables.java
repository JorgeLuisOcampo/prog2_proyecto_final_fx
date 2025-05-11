package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import javafx.scene.control.Alert;

import static co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.BilleteraVirtualConstantes.HEADER;

public class MetodosReutilizables {
    public static void mostrarMensaje(String titulo, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(HEADER);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
