package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryService {
    List<UsuarioDto> obtenerUsuarios();

    boolean agregarUsuario(UsuarioDto usuarioDto);
}
