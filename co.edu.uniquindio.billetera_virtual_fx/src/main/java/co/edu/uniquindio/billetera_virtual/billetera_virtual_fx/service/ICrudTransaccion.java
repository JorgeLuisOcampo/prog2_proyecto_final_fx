package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Transaccion;


public interface ICrudTransaccion {
    boolean agregarTransaccion(Transaccion transaccion);
    Transaccion obtenerTransaccion(int idTransaccion);
}
