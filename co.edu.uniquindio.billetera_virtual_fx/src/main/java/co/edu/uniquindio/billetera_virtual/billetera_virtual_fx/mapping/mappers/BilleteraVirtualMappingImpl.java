package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.PresupuestoDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Categoria;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Presupuesto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.IBilleteraVirtualMapping;

import java.util.ArrayList;
import java.util.List;

public class BilleteraVirtualMappingImpl implements IBilleteraVirtualMapping {
    /**
     * Metodo para obtener los usuarios en formato dto
     * @param listaUsuarios
     * @return
     */
    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios){
        if(listaUsuarios == null) {
            return null;
        }
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for(Usuario usuario : listaUsuarios) {
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }

        return listaUsuariosDto;
    }

    /**
     * Metodo para convertir un usuario a un usuarioDto
     * @param usuario
     * @return
     */
    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto (usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getIdUsuario(),
                usuario.getDireccion());
    }

    /**
     * Metodo para convertir un usuarioDto a un usuario
     * @param usuarioDto
     * @return
     */
    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDto.idUsuario());
        usuario.setNombre(usuarioDto.nombre());
        usuario.setApellidos(usuarioDto.apellidos());
        usuario.setEmail(usuarioDto.correo());
        usuario.setTelefono(usuarioDto.telefono());
        usuario.setDireccion(usuarioDto.direccion());
        return usuario;
    }

    @Override
    public ArrayList<CategoriaDto> getCategoriaDto(ArrayList<Categoria> listaCategoria) {
        if(listaCategoria == null) {
            return null;
        }
        ArrayList<CategoriaDto> listaCategoriaDto = new ArrayList<CategoriaDto>(listaCategoria.size());
        for(Categoria categoria : listaCategoria) {
            listaCategoriaDto.add(categoriaToCategoriaDto(categoria));
        }

        return listaCategoriaDto;
    }

    @Override
    public Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        return new Categoria (
                categoriaDto.id(),
                categoriaDto.nombre(),
                categoriaDto.descripcion(),
                null

        );
    }

    @Override
    public CategoriaDto categoriaToCategoriaDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getPresupuestoAsociado().getNombre()
        );
    }

    @Override
    public ArrayList<PresupuestoDto> getPresupuestoDto(ArrayList<Presupuesto> listaPresupuestos) {
        if(listaPresupuestos == null) {
            return null;
        }
        ArrayList<PresupuestoDto> listaPresupuestosDto = new ArrayList<PresupuestoDto>(listaPresupuestos.size());
        for(Presupuesto presupuesto : listaPresupuestos){
            listaPresupuestosDto.add((presupuestoToPresupuestoDto(presupuesto)));
        }
        return listaPresupuestosDto;
    }

    @Override
    public Presupuesto presupuestoDtoToPresupuesto(PresupuestoDto presupuestoDto) {
        return new Presupuesto(
                presupuestoDto.nombre(),
                presupuestoDto.id(),
                null,
                presupuestoDto.montoLimite(),
                presupuestoDto.montoGastado(),
                null

        );
    }

    @Override
    public PresupuestoDto presupuestoToPresupuestoDto(Presupuesto presupuesto) {
        return new PresupuestoDto(
                presupuesto.getNombre(),
                presupuesto.getId(),
                presupuesto.getCuentaAsociada().getNumeroCuenta(),
                presupuesto.getMontoLimite(),
                presupuesto.getMontoGastado(),
                presupuesto.getCategoria().getNombre()
        );
    }


}
