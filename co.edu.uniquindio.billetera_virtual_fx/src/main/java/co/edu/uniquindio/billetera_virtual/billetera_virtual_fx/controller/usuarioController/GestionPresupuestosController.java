package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuarioController;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.PresupuestoDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.ArrayList;

public class GestionPresupuestosController {
    ModelFactory modelFactory;
    public GestionPresupuestosController(){
        modelFactory = ModelFactory.getInstance();
    }


    public ArrayList<PresupuestoDto> obtenerPresupuestos(UsuarioDto usuarioDto) {
        return modelFactory.obtenerPresupuestos(usuarioDto);
    }
}
