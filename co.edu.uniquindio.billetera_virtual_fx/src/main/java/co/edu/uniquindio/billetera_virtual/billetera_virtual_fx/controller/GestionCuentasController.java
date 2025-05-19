package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;

import java.util.LinkedList;

public class GestionCuentasController {
    ModelFactory modelFactory;

    public GestionCuentasController() {
        modelFactory = ModelFactory.getInstance();
    }

    public LinkedList<CuentaDto> obtenerCuentas() {
        return modelFactory.obtenerCuentas();
    }

    public boolean agregarCuenta(CuentaDto cuentaDto) {
        return modelFactory.agregarCuenta(cuentaDto);
    }

    public boolean eliminarCuenta(int idCuenta, String numCuenta) {
        return modelFactory.eliminarCuenta(idCuenta, numCuenta);
    }

    public boolean actualizarCuenta(CuentaDto cuentaVieja, CuentaDto cuentaNueva) {
        return modelFactory.actualizarCuenta(cuentaVieja, cuentaNueva);
    }

    public LinkedList<String> obtenerUsuariosId() {
        return modelFactory.obtenerUsuariosId();
    }

    public boolean verificarCuentaNumCuenta(String numCuenta) {
        return modelFactory.verificarCuentaNumCuenta(numCuenta);
    }

    public boolean verificarCuentaId(int id) {
        return modelFactory.verificarCuentaId(id);
    }

    public LinkedList<String> obtenerPresupuestosDisponiblesUsuario(String usuario) {
        return modelFactory.obtenerPresupuestosDisponiblesUsuario(usuario);
    }
}
