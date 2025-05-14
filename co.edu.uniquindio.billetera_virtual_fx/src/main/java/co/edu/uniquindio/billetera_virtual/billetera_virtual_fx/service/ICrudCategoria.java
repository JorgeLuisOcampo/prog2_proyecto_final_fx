package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Categoria;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Presupuesto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public interface ICrudCategoria {
    boolean agregarCategoria(Categoria categoria, Usuario usuario);
    boolean actualizarCategoria(Categoria categoria, Usuario usuario);
    boolean eliminarCategoria(Categoria categoria, Usuario usuario);
}
