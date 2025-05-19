package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

import java.util.List;

public interface ICrudUsuario {
    boolean agregarUsuario(Usuario usuario);
    boolean eliminarUsuario(String id);
    boolean actualizarUsuario(String id, Usuario nuevoUsuario);
    Usuario obtenerUsuario(String id);
}
