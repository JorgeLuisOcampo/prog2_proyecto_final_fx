package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.TipoTransaccion;

import java.time.LocalDate;

public record TransaccionDto(
        int idTransaccion, LocalDate fecha, double monto,
        String descripcion, String idUsuario, String numCuentaOrigen,
        String numCuentaDestino, TipoTransaccion tipoTransaccion
) {
}
