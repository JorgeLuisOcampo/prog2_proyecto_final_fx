package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;


import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;

import java.util.LinkedList;

public interface IBilleteraMapping {
    LinkedList<CategoriaDto> getListaCategorias(LinkedList<Categoria> listaCategorias);
    CategoriaDto categoriaToCategoriaDto(Categoria categoria);
    Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto, BilleteraVirtual billeteraVirtual, Usuario usuario);

    LinkedList<CuentaDto> getCuentasDto(LinkedList<Cuenta> listaCuentas);
    CuentaDto cuentaToCuentaDto(Cuenta cuenta);
    Cuenta cuentaDtoToCuenta(CuentaDto cuentaDto, BilleteraVirtual billeteraVirtual,
                             Usuario usuario, Presupuesto presupuesto);

    LinkedList<PresupuestoDto> getPresupuestosDto(LinkedList<Presupuesto> listaPresupuestos);
    PresupuestoDto presupuestoToPresupuestoDto(Presupuesto presupuesto);
    Presupuesto presupuestoDtoToPresupuesto(PresupuestoDto presupuestoDto, BilleteraVirtual billeteraVirtual,
                                            Usuario usuario, Cuenta cuenta, Categoria categoria);

    LinkedList<TransaccionDto> getTransaccionDto(LinkedList<Transaccion> listaTransaccion);
    TransaccionDto transaccionToTransaccionDto(Transaccion transaccion);
    Transaccion transaccionDtoToTransaccion(TransaccionDto transaccionDto,
                                            BilleteraVirtual billeteraVirtual, Usuario usuarioAsociado, Cuenta cuentaOrigen,
                                            Cuenta cuentaDestino);
    String mapperGetNumeroCuenta(Cuenta cuenta);

    LinkedList<UsuarioDto> getUsuariosDto(LinkedList<Usuario> listaUsuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto, BilleteraVirtual billeteraVirtual);
}
