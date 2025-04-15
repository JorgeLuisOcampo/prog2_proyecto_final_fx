package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;

public interface IMetodosBilletera {
    public void agregarAdministrador(Administrador administrador);
    public void filtrarTransaccion();
    public void estadoPresupuesto();
    public void montoGastado();
    public void eliminarCuentasDesuso();
    public void listarUsuarios();
    public void listarCategorias();
}
