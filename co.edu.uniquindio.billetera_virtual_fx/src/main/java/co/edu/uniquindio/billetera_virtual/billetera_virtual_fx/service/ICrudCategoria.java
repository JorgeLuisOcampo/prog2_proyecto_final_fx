package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Categoria;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Presupuesto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public interface ICrudCategoria {
    boolean agregarCategoria(Categoria categoria);
    boolean actualizarCategoria(int idCategoria, Categoria nuevaCategoria);
    boolean eliminarCategoria(int idCategoria);
    Categoria obtenerCategoria(int idCategoria);
}
