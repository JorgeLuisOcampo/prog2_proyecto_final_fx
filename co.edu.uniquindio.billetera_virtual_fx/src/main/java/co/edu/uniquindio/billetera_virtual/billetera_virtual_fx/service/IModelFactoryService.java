package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.LinkedList;


public interface IModelFactoryService {
    LinkedList<UsuarioDto> obtenerUsuarios();
    LinkedList<CuentaDto> obtenerCuentas();
    LinkedList<CategoriaDto> obtenerCategorias(String idUsuario);
}
