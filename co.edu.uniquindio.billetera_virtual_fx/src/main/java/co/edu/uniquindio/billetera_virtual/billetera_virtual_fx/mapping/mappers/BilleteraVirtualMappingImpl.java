package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
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
        usuario.setEmail(usuarioDto.email());
        usuario.setTelefono(usuarioDto.telefono());
        usuario.setDireccion(usuarioDto.direccion());
        return usuario;
    }

}
