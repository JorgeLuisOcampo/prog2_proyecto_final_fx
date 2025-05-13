package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers.BilleteraVirtualMappingImpl;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.BilleteraVirtual;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.DataUtil;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory implements IModelFactory {
    private static ModelFactory modelFactory;
    private BilleteraVirtual billetera;
    private IBilleteraVirtualMapping mapper;
    private Administrador administrador;

    private ModelFactory() {
        mapper = new BilleteraVirtualMappingImpl();
        billetera = DataUtil.inicializarDatos();
        administrador = billetera.getAdministrador();
    }

    public static ModelFactory getInstance() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuariosDto(billetera.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return billetera.agregarUsuario(mapper.usuarioDtoToUsuario(usuarioDto));
    }

    @Override
    public boolean actualizarUsuario(UsuarioDto usuarioDto) {
        return billetera.actualizarUsuario(mapper.usuarioDtoToUsuario(usuarioDto));
    }

    @Override
    public boolean eliminarUsuario(UsuarioDto usuarioDto) {
        return billetera.eliminarUsuario(mapper.usuarioDtoToUsuario(usuarioDto));
    }

    @Override
    public String contraseniaDto(UsuarioDto usuarioDto) {
        return billetera.contraseniaDto(mapper.usuarioDtoToUsuario(usuarioDto));
    }

    @Override
    public ArrayList<CategoriaDto> obtenerCategorias(UsuarioDto usuarioDto) {
        Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
        return mapper.getCategoriaDto(billetera.obtenerCategorias(usuario));
    }

    @Override
    public boolean agregarCategoria(CategoriaDto categoriaDto, UsuarioDto usuarioDto) {
        return billetera.agregarCategoriaAUsuario(mapper.categoriaDtoToCategoria(categoriaDto), mapper.usuarioDtoToUsuario(usuarioDto));
    }

    public boolean verificarInfoAdm(String usuario, String contrasenia){
        return billetera.verificarInfoAdm(usuario, contrasenia);
    }

    public boolean verificarInfoUsuario(String correo, String contrasenia){
        return billetera.verificarInfoUsuario(correo, contrasenia);
    }

    public UsuarioDto obtenerUsuarioToUsuarioDto(Usuario usuario){
        return mapper.usuarioToUsuarioDto(usuario);
    }

    public Usuario buscarUsuarioPorCredenciales(String correo, String contrasenia){
        return billetera.obtenerUsuarioPorCredenciales(correo, contrasenia);
    }
}
