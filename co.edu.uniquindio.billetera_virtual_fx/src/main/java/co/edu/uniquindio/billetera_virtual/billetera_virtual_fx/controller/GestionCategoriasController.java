package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;

import java.util.LinkedList;

public class GestionCategoriasController {
    ModelFactory modelFactory;

    public GestionCategoriasController() {
        modelFactory = ModelFactory.getInstance();
    }

    public LinkedList<CategoriaDto> obtenerCategorias(String idUsuario) {
        return modelFactory.obtenerCategorias(idUsuario);
    }

    public boolean agregarCategoria(CategoriaDto categoria, String idUsuario) {
        return modelFactory.agregarCategoria(categoria, idUsuario);
    }

    public boolean actualizarCategoria(String idUsuario, int idCategoriaVieja, CategoriaDto categoriaNueva) {
        return modelFactory.actualizarCategoria(idUsuario, idCategoriaVieja, categoriaNueva);
    }

    public boolean eliminarCategoria(String idUsuario, int idCategoria) {
        return modelFactory.eliminarCategoria(idUsuario, idCategoria);
    }
}
