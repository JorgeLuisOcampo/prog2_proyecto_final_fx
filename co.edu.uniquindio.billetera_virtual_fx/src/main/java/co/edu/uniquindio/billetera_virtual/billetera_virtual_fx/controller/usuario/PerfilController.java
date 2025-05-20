package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

public class PerfilController {
    ModelFactory modelFactory;

    public PerfilController() {
        modelFactory = ModelFactory.getInstance();
    }

    /**
     * Metodo par aactualizar un usuario de la lista de usuarios de la billetera virtual
     * @param idUsuario id del usuario a actualizar
     * @param usuarioNuevo Usuario con los datos nuevos
     * @return Booleano sobre si la accion fue completada exitosamente o no
     */
    public boolean actualizarUsuario(String idUsuario, UsuarioDto usuarioNuevo) {
        return modelFactory.actualizarUsuario(idUsuario, usuarioNuevo);
    }
}
