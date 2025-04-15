package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactory {
    public List<UsuarioDto> obtenerUsuarios();
    public boolean agregarUsuario(UsuarioDto usuarioDto);
    public boolean actualizarUsuario(UsuarioDto usuarioDto);
    public boolean eliminarUsuario(UsuarioDto usuarioDto);

}
