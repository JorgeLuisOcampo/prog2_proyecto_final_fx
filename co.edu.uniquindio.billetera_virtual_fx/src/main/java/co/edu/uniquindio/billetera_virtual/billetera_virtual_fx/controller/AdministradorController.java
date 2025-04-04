package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

import java.util.List;

public class AdministradorController {
    ModelFactory modelFactory;
    public AdministradorController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean crearUsuario(UsuarioDto usuarioDto) {
        return modelFactory.agregarUsuario(usuarioDto);
    }

    public boolean actualizarUsuario(UsuarioDto usuarioDto) {
        return modelFactory.actualizarUsuario(usuarioDto);
    }

    public boolean elimiarUsuario(UsuarioDto usuarioDto) {
        return modelFactory.eliminarUsuario(usuarioDto);
    }
}
