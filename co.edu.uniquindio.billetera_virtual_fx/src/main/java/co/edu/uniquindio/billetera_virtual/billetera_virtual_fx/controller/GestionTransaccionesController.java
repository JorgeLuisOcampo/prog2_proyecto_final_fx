package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;

import java.util.LinkedList;

public class GestionTransaccionesController {
    ModelFactory modelFactory;

    public GestionTransaccionesController() {
        modelFactory = ModelFactory.getInstance();
    }

    public LinkedList<TransaccionDto> obtenerTransacciones() {
        return modelFactory.obtenerTransacciones();
    }

    public LinkedList<String> obtenerNumCuentasUsuario(String idUsuario) {
        return modelFactory.obtenerNumeroCuentasUsuario(idUsuario);
    }

    public int obtenerNuevoIdTransaccion() {
        return modelFactory.obtenerNuevoIdTransaccion();
    }

    public boolean agregarTransaccion(TransaccionDto transaccionDto, String idUsuario) {
        return modelFactory.agregarTransaccion(transaccionDto, idUsuario);
    }

    public boolean saldoCuentaEsSuficiente(TransaccionDto transaccion) {
        return modelFactory.saldoCuentaEsSuficiente(transaccion);
    }

    public boolean validarPresupuesto(TransaccionDto transaccion) {
        return modelFactory.validarPresupuesto(transaccion);
    }

    public LinkedList<String> obtenerUsuariosId() {
        return modelFactory.obtenerUsuariosId();
    }
}
