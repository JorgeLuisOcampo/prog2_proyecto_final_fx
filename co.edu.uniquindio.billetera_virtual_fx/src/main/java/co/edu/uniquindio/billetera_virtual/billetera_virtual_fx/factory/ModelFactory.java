package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers.BilleteraMappingImpl;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.DataUtil;

import java.time.LocalDate;
import java.util.LinkedList;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private BilleteraVirtual billetera;
    private Administrador administrador;
    private IBilleteraMapping mapper;

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory() {
        mapper = new BilleteraMappingImpl();
        billetera = DataUtil.inicializarDatos();
        administrador = billetera.getAdministrador();
    }

    public boolean validarContraseniaAdministrador(int contrasenia) {
        return billetera.validarContraseniaAdministrador(contrasenia);
    }

    public boolean verificarCredencialesUsuario(String id, int contrasenia) {
        return billetera.validarDatosUsuario(id, contrasenia);
    }

    @Override
    public LinkedList<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuariosDto(billetera.getListaUsuarios());
    }

    public boolean agregarUsuario(UsuarioDto usuario) {
        return administrador.agregarUsuario(usuarioDtoToUsuario(usuario));
    }

    public boolean eliminarUsuario(String id) {
        return administrador.eliminarUsuario(id);
    }

    public boolean actualizarUsuario(String id, UsuarioDto usuarioNuevo) {
        return administrador.actualizarUsuario(id, usuarioDtoToUsuario(usuarioNuevo));
    }

    public UsuarioDto obtenerUsuarioToUsuarioDto(String id) {
        return mapper.usuarioToUsuarioDto(administrador.obtenerUsuario(id));
    }

    @Override
    public LinkedList<CuentaDto> obtenerCuentas() {
        return mapper.getCuentasDto(billetera.getListaCuentas());
    }

    public boolean agregarCuenta(CuentaDto cuenta) {
        return administrador.agregarCuenta(cuentaDtoToCuenta(cuenta));
    }

    public boolean eliminarCuenta(int idCuenta, String numeroCuenta) {
        return administrador.eliminarCuenta(idCuenta, numeroCuenta);
    }

    public boolean actualizarCuenta(CuentaDto cuentaAntigua, CuentaDto cuentaNueva) {
        return administrador.actualizarCuenta(cuentaDtoToCuenta(cuentaAntigua), cuentaAntigua.idUsuarioAsociado(),
                cuentaNueva.idUsuarioAsociado(), cuentaDtoToCuenta(cuentaNueva));
    }

    public LinkedList<String> obtenerUsuariosId() {
        return billetera.obtenerUsuariosId();
    }

    public boolean verificarCuentaId(int id) {
        return billetera.verificarIDCuenta(id);
    }

    public boolean verificarNumeroCuenta(String numeroCuenta) {
        return billetera.verificarNumeroCuenta(numeroCuenta);
    }

    public boolean agregarCuentaUsuario(String idUsuario, CuentaDto cuentaDto) {
        return obtenerUsuario(idUsuario).agregarCuenta(cuentaDtoToCuenta(cuentaDto));
    }

    public boolean actualizarCuentaUsuario(String idUsuario, CuentaDto cuentaAntigua, CuentaDto cuentaNueva) {
        return obtenerUsuario(idUsuario).actualizarCuenta(cuentaDtoToCuenta(cuentaAntigua),
                cuentaDtoToCuenta(cuentaNueva));
    }

    public boolean eliminarCuentaUsuario(String idUsuario, int idCuenta, String numeroCuenta) {
        return obtenerUsuario(idUsuario).eliminarCuenta(idCuenta, numeroCuenta);
    }

    public LinkedList<CuentaDto> obtenerCuentasUsuario(String idUsuario) {
        return mapper.getCuentasDto(obtenerUsuario(idUsuario).getListaCuentas());
    }

    public LinkedList<String> obtenerNumeroCuentasUsuario(String idUsuario) {
        return billetera.obtenerNumeroCuentasUsuario(idUsuario);
    }

    public int obtenerNuevoIdTransaccion() {
        return billetera.obtenerNuevoIdTransaccion();
    }

    public boolean agregarTransaccion(TransaccionDto transaccion, String idUsuario) {
        return obtenerUsuario(idUsuario).
                agregarTransaccion(transaccionDtoToTransaccion(transaccion));
    }

    public boolean saldoCuentaEsSuficiente(TransaccionDto transaccion) {
        return billetera.validarSaldo(transaccionDtoToTransaccion(transaccion));
    }

    public boolean agregarCategoria(CategoriaDto categoria, String idUsuario) {
        return obtenerUsuario(idUsuario).
                agregarCategoria(categoriaDtoToCategoria(categoria));
    }

    public boolean eliminarCategoria(String idUsuario, int idCategoria) {
        return obtenerUsuario(idUsuario).eliminarCategoria(idCategoria);
    }

    public boolean actualizarCategoria(String idUsuario, int idCategoria, CategoriaDto nuevaCategoria) {
        return obtenerUsuario(idUsuario).actualizarCategoria(idCategoria, categoriaDtoToCategoria(nuevaCategoria));
    }

    private Usuario obtenerUsuario(String idUsuario) {
        return billetera.obtenerUsuario(idUsuario);
    }

    private Categoria obtenerCategoria(int idCategoria) {
        return billetera.obtenerCategoria(idCategoria);
    }

    private Categoria obtenerCategoriaPorNombre(String nombreCategoria) {
        return billetera.obtenerCategoriaPorNombre(nombreCategoria);
    }

    private Presupuesto obtenerPresupuesto(int idPresupuesto) {
        return billetera.obtenerPresupuesto(idPresupuesto);
    }

    public LinkedList<String> obtenerPresupuestoDisponiblesNombres(String idUsuario) {
        return obtenerUsuario(idUsuario).obtenerPresupuestosDisponiblesNombres();
    }

    private Presupuesto obtenerPresupuestoNombre(String nombrePresupuesto, String idUsuario) {
        return obtenerUsuario(idUsuario).obtenerPresupuestoNombre(nombrePresupuesto);
    }

    private Cuenta obtenerCuentaNumeroCuenta(String numeroCuenta) {
        return billetera.obtenerCuentaNumeroCuenta(numeroCuenta);
    }

    @Override
    public LinkedList<CategoriaDto> obtenerCategorias(String idUsuario) {
        return mapper.getListaCategorias(obtenerUsuario(idUsuario).getListaCategorias());
    }

    public LinkedList<String> obtenerPresupuestosNombres(String idUsuario) {
        return obtenerUsuario(idUsuario).obtenerPresupuestosNombres();
    }

    public LinkedList<String> obtenerPresupuestosDisponiblesUsuario(String idUsuario) {
        return obtenerUsuario(idUsuario).obtenerPresupuestosDisponiblesNombres();
    }

    public boolean validarPresupuesto(TransaccionDto transaccion) {
        return billetera.validarPresupuesto(transaccionDtoToTransaccion(transaccion));
    }

    public boolean agregarPresupuesto(PresupuestoDto presupuestoDto) {
        return obtenerUsuario(presupuestoDto.idUsuario())
                .agregarPresupuesto(presupuestoDtoToPresupuesto(presupuestoDto));
    }

    public boolean eliminarPresupuesto(int idPresupuesto, String idUsuario) {
        return obtenerUsuario(idUsuario).eliminarPresupuesto(idPresupuesto);
    }

    public boolean actualizarPresupuesto(int idPresupuestoViejo, PresupuestoDto presupuestoDto) {
        return obtenerUsuario(presupuestoDto.idUsuario())
                .actualizarPresupuesto(idPresupuestoViejo, presupuestoDtoToPresupuesto(presupuestoDto));
    }

    private Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return mapper.usuarioDtoToUsuario(usuarioDto, billetera);
    }

    private Cuenta cuentaDtoToCuenta(CuentaDto cuentaDto) {
        return mapper.cuentaDtoToCuenta(cuentaDto, billetera,
                obtenerUsuario(cuentaDto.idUsuarioAsociado()),
                obtenerPresupuestoNombre(cuentaDto.presupuestoAsociado(), cuentaDto.idUsuarioAsociado()));
    }

    private Transaccion transaccionDtoToTransaccion(TransaccionDto transaccion) {
        return mapper.transaccionDtoToTransaccion(transaccion, billetera,
                obtenerUsuario(transaccion.idUsuario()),
                obtenerCuentaNumeroCuenta(transaccion.numCuentaOrigen()),
                obtenerCuentaNumeroCuenta(transaccion.numCuentaDestino()));
    }

    private Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        return mapper.categoriaDtoToCategoria(categoriaDto, billetera,
                obtenerUsuario(categoriaDto.idUsuario()));
    }

    private Presupuesto presupuestoDtoToPresupuesto(PresupuestoDto presupuestoDto) {
        return mapper.presupuestoDtoToPresupuesto(presupuestoDto, billetera,
                obtenerUsuario(presupuestoDto.idUsuario()),
                obtenerCuentaNumeroCuenta(presupuestoDto.cuentaAsociada()),
                obtenerCategoriaPorNombre(presupuestoDto.categoria()));
    }

    public LinkedList<PresupuestoDto> obtenerPresupuestos(String idUsuario) {
        return mapper.getPresupuestosDto(obtenerUsuario(idUsuario).getListaPresupuestos());
    }


    public LinkedList<TransaccionDto> obtenerTransacciones(String idUsuario) {
        return mapper.getTransaccionDto(obtenerUsuario(idUsuario).getListaTransacciones());
    }

    public LinkedList<TransaccionDto> obtenerTransacciones() {
        return mapper.getTransaccionDto(billetera.getListaTransacciones());
    }

    public LinkedList<TransaccionDto> obtenerListaTransaccionesGastos(String idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        return mapper.getTransaccionDto(obtenerUsuario(idUsuario).obtenerListaTransaccionesGastos(fechaInicio, fechaFin));
    }

    public LinkedList<TransaccionDto> obtenerListaTransaccionesIngresos(String idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        return mapper.getTransaccionDto(obtenerUsuario(idUsuario).obtenerListaTransaccionesIngresos(fechaInicio, fechaFin));
    }

    public LinkedList<String> obtenerCategoriasDisponibles(String idUsuario) {
        return obtenerUsuario(idUsuario).obtenerCategoriasDisponibles();
    }
}
