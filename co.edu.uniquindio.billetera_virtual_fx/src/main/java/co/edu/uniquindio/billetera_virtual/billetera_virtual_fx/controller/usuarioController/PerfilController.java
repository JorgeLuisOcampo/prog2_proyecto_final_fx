package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuarioController;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

public class PerfilController {
    ModelFactory modelFactory;
    public PerfilController(){
        modelFactory = ModelFactory.getInstance();
    }

    public boolean actualizarUsuario(UsuarioDto usuarioDto) {
        return modelFactory.actualizarUsuario(usuarioDto);

    }

    public String contraseniaDto(UsuarioDto usuarioDto) {
        return modelFactory.contraseniaDto(usuarioDto);
    }
}
