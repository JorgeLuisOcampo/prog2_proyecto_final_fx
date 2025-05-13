package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuarioController;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.ArrayList;


public class GestionCategoriasController {
    ModelFactory modelFactory;
    public GestionCategoriasController(){
        modelFactory = ModelFactory.getInstance();
    }

    public ArrayList<CategoriaDto> obtenerCategorias(UsuarioDto usuarioDto) {
        return modelFactory.obtenerCategorias(usuarioDto);
    }

    public boolean agregarCategoria(CategoriaDto categoriaDto, UsuarioDto usuarioDto) {
        return modelFactory.agregarCategoria(categoriaDto, usuarioDto);
    }
}
