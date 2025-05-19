package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.IBilleteraMapping;

import java.util.LinkedList;

public class BilleteraMappingImpl implements IBilleteraMapping {
    @Override
    public LinkedList<CategoriaDto> getListaCategorias(LinkedList<Categoria> listaCategorias) {
        if (listaCategorias == null) {
            return null;
        }
        LinkedList<CategoriaDto> listaCategoriasDto = new LinkedList<>();
        for (Categoria categoria : listaCategorias) {
            listaCategoriasDto.add(categoriaToCategoriaDto(categoria));
        }
        return listaCategoriasDto;
    }

    @Override
    public CategoriaDto categoriaToCategoriaDto(Categoria categoria) {
        String presupuestoAsociado = categoria.getPresupuestoAsociado() != null
                ? categoria.getPresupuestoAsociado().getNombre() : null;

        return new CategoriaDto(categoria.getId(), categoria.getUsuarioAsociado().getId(),
                categoria.getNombre(), categoria.getDescripcion(), presupuestoAsociado);
    }

    @Override
    public Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto, BilleteraVirtual billeteraVirtual,
                                             Usuario usuario) {
        Categoria categoria = new Categoria();
        categoria.setBilleteraVirtual(billeteraVirtual);
        categoria.setUsuarioAsociado(usuario);
        categoria.setNombre(categoriaDto.nombre());
        categoria.setDescripcion(categoriaDto.descripcion());
        categoria.setId(categoriaDto.idCategoria());
        return categoria;
    }

    @Override
    public LinkedList<CuentaDto> getCuentasDto(LinkedList<Cuenta> listaCuentas) {
        if (listaCuentas == null) {
            return null;
        }
        LinkedList<CuentaDto> listaCuentasDto = new LinkedList<>();
        for (Cuenta cuenta : listaCuentas) {
            listaCuentasDto.add(cuentaToCuentaDto(cuenta));
        }
        return listaCuentasDto;
    }

    @Override
    public CuentaDto cuentaToCuentaDto(Cuenta cuenta) {
        return new CuentaDto(cuenta.getIdCuenta(), cuenta.getBanco(), cuenta.getNumeroCuenta(),
                cuenta.getUsuarioAsociado().getId(), cuenta.getTipoCuenta(), cuenta.getSaldo(),
                cuenta.getPresupuestoAsociado().getNombre());
    }

    @Override
    public Cuenta cuentaDtoToCuenta(CuentaDto cuentaDto, BilleteraVirtual billeteraVirtual,
                                    Usuario usuario, Presupuesto presupuesto) {
        FactoryCuentas factoryCuentas = obtenerCuentaFactory(cuentaDto.tipoCuenta());
        return factoryCuentas.crearCuenta(cuentaDto.idCuenta(), cuentaDto.nombreBanco(), cuentaDto.numCuenta(), usuario, billeteraVirtual, presupuesto);
    }

    private FactoryCuentas obtenerCuentaFactory(TipoCuenta tipoCuenta) {
        if (tipoCuenta.equals(TipoCuenta.AHORRO)) {
            return new FactoryCuentasAhorro();
        } else if (tipoCuenta.equals(TipoCuenta.CORRIENTE)) {
            return new FactoryCuentasCorriente();
        }
        throw new IllegalArgumentException("El tipo de cuenta no existe");
    }

    @Override
    public LinkedList<PresupuestoDto> getPresupuestosDto(LinkedList<Presupuesto> listaPresupuestos) {
        if (listaPresupuestos == null) {
            listaPresupuestos = new LinkedList<>();
        }
        LinkedList<PresupuestoDto> listaPresupuestosDto = new LinkedList<>();
        for (Presupuesto presupuesto : listaPresupuestos) {
            listaPresupuestosDto.add(presupuestoToPresupuestoDto(presupuesto));
        }
        return listaPresupuestosDto;
    }

    @Override
    public PresupuestoDto presupuestoToPresupuestoDto(Presupuesto presupuesto) {
        String numCuenta = presupuesto.getCuentaAsociada() != null ? presupuesto.getCuentaAsociada().getNumeroCuenta() : null;
        String categoria = presupuesto.getCategoriaAsociada() != null ? presupuesto.getCategoriaAsociada().getNombre() : null;

        return new PresupuestoDto(
                presupuesto.getIdPresupuesto(),
                presupuesto.getNombre(),
                presupuesto.getMontoTotal(),
                presupuesto.getMontoGastado(),
                presupuesto.getUsuarioAsociado().getId(),
                numCuenta,
                categoria);
    }

    @Override
    public Presupuesto presupuestoDtoToPresupuesto(PresupuestoDto presupuestoDto, BilleteraVirtual billeteraVirtual,
                                                   Usuario usuario, Cuenta cuenta, Categoria categoria) {
        Presupuesto presupuesto = new Presupuesto();
        presupuesto.setBilleteraVirtual(billeteraVirtual);
        presupuesto.setIdPresupuesto(presupuestoDto.idPresupuesto());
        presupuesto.setNombre(presupuestoDto.nombre());
        presupuesto.setMontoTotal(presupuestoDto.montoTotalAsignado());
        presupuesto.setMontoGastado(presupuestoDto.montoGastado());
        presupuesto.setUsuarioAsociado(usuario);
        presupuesto.setCuentaAsociada(cuenta);
        presupuesto.setCategoriaAsociada(categoria);
        return presupuesto;
    }

    @Override
    public LinkedList<TransaccionDto> getTransaccionDto(LinkedList<Transaccion> listaTransaccion) {
        if (listaTransaccion == null) {
            return null;
        }
        LinkedList<TransaccionDto> listaTransaccionesDto = new LinkedList<>();
        for (Transaccion transaccion : listaTransaccion) {
            listaTransaccionesDto.add(transaccionToTransaccionDto(transaccion));
        }
        return listaTransaccionesDto;
    }

    @Override
    public TransaccionDto transaccionToTransaccionDto(Transaccion transaccion) {
        return new TransaccionDto(
                transaccion.getId(),
                transaccion.getFecha(),
                transaccion.getMonto(),
                transaccion.getDetalle(),
                transaccion.getUsuarioAsociado().getId(),
                transaccion.getCuentaOrigen().getNumeroCuenta(),
                mapperGetNumeroCuenta(transaccion.getCuentaDestino()),
                transaccion.getTipoTransaccion());
    }

    @Override
    public Transaccion transaccionDtoToTransaccion(TransaccionDto transaccionDto,
                                                   BilleteraVirtual billeteraVirtual, Usuario usuarioAsociado,
                                                   Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        return Transaccion.builder()
                .billeteraVirtual(billeteraVirtual)
                .idTransaccion(transaccionDto.idTransaccion())
                .fecha(transaccionDto.fecha())
                .monto(transaccionDto.monto())
                .descripcionOpcional(transaccionDto.descripcion())
                .usuarioAsociado(usuarioAsociado)
                .tipoTransaccion(transaccionDto.tipoTransaccion())
                .cuentaOrigen(cuentaOrigen)
                .cuentaDestino(cuentaDestino)
                .build();
    }

    @Override
    public String mapperGetNumeroCuenta(Cuenta cuenta) {
        return (cuenta != null) ? cuenta.getNumeroCuenta() : null;
    }

    @Override
    public LinkedList<UsuarioDto> getUsuariosDto(LinkedList<Usuario> listaUsuarios) {
        if (listaUsuarios == null){
            return  null;
        }
        LinkedList<UsuarioDto> listaUsuariosDto = new LinkedList<UsuarioDto>();
        for (Usuario usuario : listaUsuarios){
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getNombre(), usuario.getId(),
                usuario.getEmail(), usuario.getTelefono(),
                usuario.getDomicilio(), usuario.getContrasenia());
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto, BilleteraVirtual billeteraVirtual) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.nombreCompleto());
        usuario.setId(usuarioDto.idUsuario());
        usuario.setEmail(usuarioDto.correoElectronico());
        usuario.setTelefono(usuarioDto.numeroTelefono());
        usuario.setDomicilio(usuarioDto.direccion());
        usuario.setContrasenia(usuarioDto.clave());
        usuario.setBilleteraVirtual(billeteraVirtual);
        return usuario;
    }
}