package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

public class RegistrarUsuarioController {
    ModelFactory modelFactory;

    public RegistrarUsuarioController() {
        modelFactory = ModelFactory.getInstance();
    }

    public boolean agregarUsuario(UsuarioDto usuarioDto){
        return modelFactory.agregarUsuario(usuarioDto);
    }
}
