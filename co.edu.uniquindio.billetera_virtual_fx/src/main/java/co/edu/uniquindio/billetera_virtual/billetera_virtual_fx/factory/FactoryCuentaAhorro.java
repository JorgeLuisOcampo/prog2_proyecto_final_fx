package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;

public class FactoryCuentaAhorro extends CuentaFactory{
    @Override
    public Cuenta crearCuenta(int idCuenta, String nombreBanco, String numeroCuenta, Usuario usuarioAsociado, BilleteraVirtual billeteraVirtual, Presupuesto presupuestoAsociado) {
        return new Cuenta(idCuenta, nombreBanco, numeroCuenta, usuarioAsociado, TipoCuenta.AHORRO, billeteraVirtual, presupuestoAsociado);
    }
}
