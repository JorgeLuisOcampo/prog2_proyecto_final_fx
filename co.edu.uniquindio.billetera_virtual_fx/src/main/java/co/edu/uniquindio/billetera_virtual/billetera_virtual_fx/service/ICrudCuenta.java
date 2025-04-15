package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;

public interface ICrudCuenta {
    boolean agregarCuenta(CuentaDto cuentaDto);

    boolean eliminarCuenta(CuentaDto cuentaDto);

    boolean actualizarCuenta(CuentaDto cuentaDto);

    boolean detallesCuenta(CuentaDto cuentaDto);
}
