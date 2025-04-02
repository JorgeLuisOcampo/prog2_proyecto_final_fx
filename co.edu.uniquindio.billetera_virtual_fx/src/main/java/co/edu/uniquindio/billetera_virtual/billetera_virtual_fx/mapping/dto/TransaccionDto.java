package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Cuenta;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.TipoTransaccion;

import java.time.LocalDate;

public record TransaccionDto(
        String id, LocalDate fechaTransaccion, TipoTransaccion tipoTransaccion,
        double monto, String descripcion, Cuenta cuentaOrigen, Cuenta cuentaDestino
) {
}
