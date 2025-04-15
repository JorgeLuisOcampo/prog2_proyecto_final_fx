package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers.BilleteraVirtualMappingImpl;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.BilleteraVirtual;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactory {
    private static ModelFactory modelFactory;
    private BilleteraVirtual billetera;
    private IBilleteraVirtualMapping mapper;

    private ModelFactory() {
        mapper = new BilleteraVirtualMappingImpl();
        billetera = DataUtil.inicializarDatos();
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

}
