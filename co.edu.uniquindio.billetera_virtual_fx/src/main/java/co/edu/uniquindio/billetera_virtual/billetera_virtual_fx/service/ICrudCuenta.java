package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Cuenta;

public interface ICrudCuenta {
    boolean agregarCuenta(Cuenta cuenta);
    boolean eliminarCuenta(int id, String numCuenta);
    boolean actualizarCuenta(Cuenta cuentaVieja, String idUsuarioViejo, String idUsuarioNuevo, Cuenta nuevaCuenta);
    Cuenta obtenerCuenta(int id, String numCuenta);
}
