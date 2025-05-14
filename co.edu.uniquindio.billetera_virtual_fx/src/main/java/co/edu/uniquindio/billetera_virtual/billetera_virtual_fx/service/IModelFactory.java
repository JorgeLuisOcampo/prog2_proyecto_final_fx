package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.PresupuestoDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.ArrayList;
import java.util.List;

public interface IModelFactory {
    public List<UsuarioDto> obtenerUsuarios();
    public boolean agregarUsuario(UsuarioDto usuarioDto);
    public boolean actualizarUsuario(UsuarioDto usuarioDto);
    public boolean eliminarUsuario(UsuarioDto usuarioDto);

    String contraseniaDto(UsuarioDto usuarioDto);

    List<CategoriaDto> obtenerCategorias(UsuarioDto usuarioDto);
    boolean agregarCategoria(CategoriaDto categoriaDto, UsuarioDto usuarioDto);

    boolean actualizarCategoria(CategoriaDto categoriaDto, UsuarioDto usuarioDto);

    boolean eliminarCategoria(CategoriaDto categoriaDto, UsuarioDto usuarioDto);

    ArrayList<PresupuestoDto> obtenerPresupuestos(UsuarioDto usuarioDto);
}
