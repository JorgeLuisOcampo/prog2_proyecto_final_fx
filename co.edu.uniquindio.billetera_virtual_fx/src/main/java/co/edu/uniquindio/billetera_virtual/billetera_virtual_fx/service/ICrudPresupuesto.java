package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Presupuesto;

public interface ICrudPresupuesto {
    boolean agregarPresupuesto(Presupuesto presupuesto);
    boolean eliminarPresupuesto(int idPresupuesto);
    boolean actualizarPresupuesto(int id, Presupuesto nuevoPresupuesto);
    Presupuesto obtenerPresupuesto(int id);
}
