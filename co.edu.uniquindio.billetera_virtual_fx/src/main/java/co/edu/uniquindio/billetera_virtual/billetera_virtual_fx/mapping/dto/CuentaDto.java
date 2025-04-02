package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.TipoCuenta;

public record CuentaDto(
        String id, String nombreBanco, String numeroCuenta,
        TipoCuenta tipoCuenta) {
}
