package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Categoria;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface IBilleteraVirtualMapping {
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);
    UsuarioDto  usuarioToUsuarioDto (Usuario usuario);
    Usuario usuarioDtoToUsuario (UsuarioDto usuarioDto);

    ArrayList<CategoriaDto> getCategoriaDto(ArrayList<Categoria> listaCategoria);
    Categoria categoriaDtoToCategoria (CategoriaDto categoriaDto);
    CategoriaDto categoriaToCategoriaDto (Categoria categoria);

}
