package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

import java.util.List;

public interface ICrudUsuario {
   // List<UsuarioDto> obtenerUsuarios();
    Usuario buscarUsuario(String id);
    boolean agregarUsuario(Usuario nuevoUsuario);
    boolean actualizarUsuario(Usuario usuarioActualizado);
    boolean eliminarUsuario(Usuario usuarioEliminado);
}
