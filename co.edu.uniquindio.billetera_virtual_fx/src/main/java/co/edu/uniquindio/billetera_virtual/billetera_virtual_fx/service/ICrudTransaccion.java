package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;



public interface ICrudTransaccion {

    boolean agregarTransaccion(TransaccionDto transaccionDto);

    boolean eliminarTransaccion(TransaccionDto transaccionDto);
}
