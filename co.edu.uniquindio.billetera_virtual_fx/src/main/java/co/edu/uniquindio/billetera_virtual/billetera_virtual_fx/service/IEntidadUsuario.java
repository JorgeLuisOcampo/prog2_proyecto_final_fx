package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public interface IEntidadUsuario {
    void iniciarSesion();
    void depositarDinero();
    void retirarDinero();
    void transferirDinero();
    void listarTransacciones();
    void listarPresupuestos();
    void consultarSaldo();
    void transaccionesCuenta();
}
