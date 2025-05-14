package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Categoria;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Presupuesto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

import java.util.ArrayList;

public interface IMetodosBilletera {
    public void filtrarTransaccion();
    public void estadoPresupuesto();
    public void montoGastado();
    public void eliminarCuentasDesuso();
    public void listarUsuarios();
    public void listarCategorias();

    Presupuesto buscarPresupuestoAsociado(Categoria categoria, Usuario usuario);

    ArrayList<Presupuesto> obtenerPresupuestos(Usuario usuario);
}
