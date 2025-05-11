package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.principalController;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public class LoginController {
    ModelFactory modelFactory;
    public LoginController() {
        modelFactory = ModelFactory.getInstance();
    }

    public boolean verificarInfoAdministrador(String usuario, String contrasenia) {
        return modelFactory.verificarInfoAdm(usuario,contrasenia);
    }

    public boolean verificarInfoUsuario(String usuario, String contrasenia){
        return modelFactory.verificarInfoUsuario(usuario,contrasenia);
    }

    public UsuarioDto obtenerUsuario(String correo, String contrasenia){
        Usuario usuario = modelFactory.buscarUsuarioPorCredenciales(correo, contrasenia);
        if(usuario != null){
            return modelFactory.obtenerUsuarioToUsuarioDto(usuario);
        }
        return null;
    }


}
