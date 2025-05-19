package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.TipoCuenta;

public record CuentaDto(
        int idCuenta, String nombreBanco, String numCuenta, String idUsuarioAsociado,
        TipoCuenta tipoCuenta, double saldo, String presupuestoAsociado
) {
}
