package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;

import java.util.LinkedList;

public class CuentasUsuarioController {
    ModelFactory modelFactory;

    public CuentasUsuarioController() {
        modelFactory = ModelFactory.getInstance();
    }

    public LinkedList<CuentaDto> obtenerCuentas(String idUsuario) {
        return modelFactory.obtenerCuentasUsuario(idUsuario);
    }

    public boolean agregarCuentaUsuario(String idUsuario, CuentaDto cuentaDto) {
        return modelFactory.agregarCuentaUsuario(idUsuario, cuentaDto);
    }

    public boolean eliminarCuentaUsuario(String idUsuario, int idCuenta, String numCuenta) {
        return modelFactory.eliminarCuentaUsuario(idUsuario, idCuenta, numCuenta);
    }

    public boolean actualizarCuentaUsuario(String idUsuario, CuentaDto cuentaVieja, CuentaDto cuentaNueva) {
        return modelFactory.actualizarCuentaUsuario(idUsuario, cuentaVieja, cuentaNueva);
    }

    public boolean verificarNumeroCuenta(String numCuenta) {
        return modelFactory.verificarNumeroCuenta(numCuenta);
    }

    public boolean verificarCuentaId(int id) {
        return modelFactory.verificarCuentaId(id);
    }

    public LinkedList<String> obtenerPresupuestosDisponiblesNombres(String idUsuario) {
        return modelFactory.obtenerPresupuestoDisponiblesNombres(idUsuario);
    }
}
