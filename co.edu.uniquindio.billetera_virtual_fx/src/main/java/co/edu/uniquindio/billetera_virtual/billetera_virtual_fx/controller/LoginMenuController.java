package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

public class LoginMenuController {
    ModelFactory modelFactory;

    public LoginMenuController() {
        modelFactory = ModelFactory.getInstance();
    }

    public boolean verificarCredencialesUsuario(String id, int clave) {
        return modelFactory.verificarCredencialesUsuario(id, clave);
    }

    public UsuarioDto obtenerUsuario(String id) {
        return modelFactory.obtenerUsuarioToUsuarioDto(id);
    }

    public boolean verificarCredencialesAdmin(int clave) {
        return modelFactory.verificarClaveAdmin(clave);
    }
}
