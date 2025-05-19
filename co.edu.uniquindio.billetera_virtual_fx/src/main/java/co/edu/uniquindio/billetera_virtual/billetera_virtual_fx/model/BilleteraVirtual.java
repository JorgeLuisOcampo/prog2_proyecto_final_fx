package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.*;

import java.util.LinkedList;

public class BilleteraVirtual implements ICrudUsuario, ICrudCuenta, ICrudCategoria, ICrudPresupuesto, ICrudTransaccion {
    private String nombre;
    private Administrador administrador;
    private LinkedList<Usuario> listaUsuarios;
    private LinkedList<Categoria> listaCategorias;
    private LinkedList<Presupuesto> listaPresupuestos;
    private LinkedList<Cuenta> listaCuentas;
    private LinkedList<Transaccion> listaTransacciones;



    public BilleteraVirtual(String nombre){
        this.nombre = nombre;
        this.administrador = new Administrador(this, 182);
        this.listaUsuarios = new LinkedList<>();
        this.listaCategorias = new LinkedList<>();
        this.listaPresupuestos = new LinkedList<>();
        this.listaCuentas = new LinkedList<>();
        this.listaTransacciones = new LinkedList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public LinkedList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(LinkedList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public LinkedList<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(LinkedList<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public LinkedList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(LinkedList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        if (obtenerUsuario(usuario.getId()) == null
                && !usuario.getId().equals(String.valueOf(administrador.getContrasenia()))){
            listaUsuarios.add(usuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        Usuario usuario = obtenerUsuario(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
            eliminarCuentasUsuario(usuario);
            eliminarPresupuestosUsuario(usuario);
            eliminarCategoriasUsuario(usuario);
            return true;
        }
        return false;
    }

    private void eliminarCategoriasUsuario(Usuario usuario) {
        for (Categoria categoria : listaCategorias) {
            listaCategorias.remove(categoria);
        }
    }

    private void eliminarCuentasUsuario(Usuario usuario) {
        for (Cuenta cuenta : usuario.getListaCuentas()) {
            listaCuentas.remove(cuenta);
        }
    }

    private void eliminarPresupuestosUsuario(Usuario usuario) {
        for (Presupuesto presupuesto : usuario.getListaPresupuestos()) {
            listaPresupuestos.remove(presupuesto);
        }
    }

    @Override
    public boolean actualizarUsuario(String id, Usuario nuevoUsuario) {
        for (Usuario usuario : listaUsuarios){
            if (usuario.getId().equalsIgnoreCase(id)){
                if (obtenerUsuario(nuevoUsuario.getId()) == null || nuevoUsuario.getId().equalsIgnoreCase(id)){
                    usuario.setId(nuevoUsuario.getId());
                    usuario.setContrasenia(nuevoUsuario.getContrasenia());
                    usuario.setNombre(nuevoUsuario.getNombre());
                    usuario.setDomicilio(nuevoUsuario.getDomicilio());
                    usuario.setEmail(nuevoUsuario.getEmail());
                    usuario.setTelefono(nuevoUsuario.getTelefono());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        for (Usuario usuario : listaUsuarios){
            if (usuario.getId().equalsIgnoreCase(id)){
                return usuario;
            }
        }
        return null;
    }


    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        if (obtenerCuenta(cuenta.getIdCuenta(), cuenta.getNumeroCuenta()) == null){
            listaCuentas.add(cuenta);
            cuenta.getUsuarioAsociado().getListaCuentas().add(cuenta);
            cuenta.getPresupuestoAsociado().setCuentaAsociada(cuenta);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarCuenta(int id, String numCuenta) {
        Cuenta cuenta = obtenerCuenta(id, numCuenta);
        if (cuenta != null){
            listaCuentas.remove(cuenta);
            cuenta.getUsuarioAsociado().getListaCuentas().remove(cuenta);
            cuenta.getPresupuestoAsociado().setCuentaAsociada(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarCuenta(Cuenta cuentaVieja, String idUsuarioViejo, String idUsuarioNuevo, Cuenta nuevaCuenta) {
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getIdCuenta() == cuentaVieja.getIdCuenta()){
                if ((obtenerCuentaId(nuevaCuenta.getIdCuenta()) == null
                        || nuevaCuenta.getIdCuenta() == cuentaVieja.getIdCuenta()) &&
                        (obtenerCuentaNumeroCuenta(nuevaCuenta.getNumeroCuenta()) == null
                                || nuevaCuenta.getNumeroCuenta().equals(cuentaVieja.getNumeroCuenta()))){
                    cuenta.setIdCuenta(nuevaCuenta.getIdCuenta());
                    cuenta.setBanco(nuevaCuenta.getBanco());
                    cuenta.setNumeroCuenta(nuevaCuenta.getNumeroCuenta());
                    cambiarUsuarioCuenta(cuenta, nuevaCuenta);
                    cuenta.setTipoCuenta(nuevaCuenta.getTipoCuenta());
                    cuenta.setUsuarioAsociado(nuevaCuenta.getUsuarioAsociado());
                    cambiarPresupuestosCuentas(cuenta, nuevaCuenta);
                    return true;
                }
            }
        }
        return false;
    }

    private void cambiarPresupuestosCuentas(Cuenta cuenta, Cuenta nuevaCuenta) {
        Presupuesto presupuesto = cuenta.getPresupuestoAsociado();
        Presupuesto presupuestoNuevo = nuevaCuenta.getPresupuestoAsociado();
        if (presupuesto.getIdPresupuesto() != presupuestoNuevo.getIdPresupuesto()){
            cuenta.setPresupuestoAsociado(presupuestoNuevo);
            presupuesto.setCuentaAsociada(null);
            presupuestoNuevo.setCuentaAsociada(cuenta);
        }
    }

    private Cuenta obtenerCuentaId(int id){
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getIdCuenta() == id){
                return cuenta;
            }
        }
        return null;
    }

    public Cuenta obtenerCuentaNumeroCuenta(String numCuenta){
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numCuenta)){
                return cuenta;
            }
        }
        return null;
    }

    public boolean verificarIDCuenta(int id) {
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getIdCuenta() == id){
                return true;
            }
        }
        return false;
    }

    public boolean verificarNumeroCuenta(String numCuenta) {
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numCuenta)){
                return true;
            }
        }
        return false;
    }

    private void cambiarUsuarioCuenta(Cuenta cuenta, Cuenta nuevaCuenta) {
        Usuario usuarioViejo = cuenta.getUsuarioAsociado();
        Usuario usuarioNuevo = nuevaCuenta.getUsuarioAsociado();
        if (!usuarioViejo.getId().equals(usuarioNuevo.getId())){
            usuarioViejo.getListaCuentas().remove(cuenta);
            usuarioNuevo.getListaCuentas().add(cuenta);
        }
    }

    @Override
    public Cuenta obtenerCuenta(int id, String numCuenta) {
        for (Cuenta cuenta : listaCuentas){
            if (cuenta.getIdCuenta() == id || cuenta.getNumeroCuenta().equalsIgnoreCase(numCuenta)){
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public boolean agregarCategoria(Categoria categoria) {
        if (obtenerCategoria(categoria.getId()) == null){
            listaCategorias.add(categoria);
            categoria.getUsuarioAsociado().getListaCategorias().add(categoria);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarCategoria(int idCategoria, Categoria nuevaCategoria) {
        for (Categoria categoria : listaCategorias){
            if (categoria.getId() == idCategoria){
                if (obtenerCategoria(nuevaCategoria.getId()) == null ||
                        nuevaCategoria.getId() == idCategoria){
                    categoria.setId(nuevaCategoria.getId());
                    categoria.setNombre(nuevaCategoria.getNombre());
                    categoria.setDescripcion(nuevaCategoria.getDescripcion());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCategoria(int idCategoria) {
        Categoria categoria = obtenerCategoria(idCategoria);
        if (categoria != null && categoria.getPresupuestoAsociado() == null){
            listaCategorias.remove(categoria);
            categoria.getUsuarioAsociado().getListaCategorias().remove(categoria);
            return true;
        }
        return false;
    }

    public Categoria obtenerCategoriaPorNombre(String nombreCategoria) {
        if (nombreCategoria != null){
            for (Categoria categoria : listaCategorias){
                if (categoria.getNombre().equalsIgnoreCase(nombreCategoria)){
                    return categoria;
                }
            }
        }
        return null;
    }

    @Override
    public Categoria obtenerCategoria(int idCategoria) {
        for (Categoria categoria : listaCategorias){
            if (categoria.getId() == idCategoria){
                return categoria;
            }
        }
        return null;
    }

    @Override
    public boolean agregarPresupuesto(Presupuesto presupuesto) {
        if (obtenerPresupuesto(presupuesto.getIdPresupuesto()) == null &&
                presupuesto.getCategoriaAsociada().getPresupuestoAsociado() == null){
            listaPresupuestos.add(presupuesto);
            presupuesto.getCategoriaAsociada().setPresupuestoAsociado(presupuesto);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarPresupuesto(int idPresupuesto) {
        Presupuesto presupuesto = obtenerPresupuesto(idPresupuesto);
        if (presupuesto != null && presupuesto.getCuentaAsociada() == null){
            listaPresupuestos.remove(presupuesto);
            presupuesto.getUsuarioAsociado().getListaPresupuestos().remove(presupuesto);
            presupuesto.getCategoriaAsociada().setPresupuestoAsociado(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarPresupuesto(int id, Presupuesto nuevoPresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos){
            if (presupuesto.getIdPresupuesto() == id){
                presupuesto.setIdPresupuesto(nuevoPresupuesto.getIdPresupuesto());
                presupuesto.setNombre(nuevoPresupuesto.getNombre());
                presupuesto.setMontoTotal(nuevoPresupuesto.getMontoTotal());
                cambiarCategoriasPresupuestos(presupuesto, nuevoPresupuesto);
                return true;
            }
        }
        return false;
    }

    private void cambiarCategoriasPresupuestos(Presupuesto presupuesto, Presupuesto nuevoPresupuesto) {
        Categoria categoriaVieja = presupuesto.getCategoriaAsociada();
        Categoria categoriaNueva = nuevoPresupuesto.getCategoriaAsociada();
        if (categoriaVieja.getId() != categoriaNueva.getId()){
            presupuesto.setCategoriaAsociada(categoriaNueva);
            categoriaVieja.setPresupuestoAsociado(null);
            categoriaNueva.setPresupuestoAsociado(presupuesto);
        }
    }

    @Override
    public Presupuesto obtenerPresupuesto(int id) {
        for (Presupuesto presupuesto : listaPresupuestos){
            if (presupuesto.getIdPresupuesto() == id){
                return presupuesto;
            }
        }
        return null;
    }

    @Override
    public boolean agregarTransaccion(Transaccion transaccion) {
        if (obtenerTransaccion(transaccion.getId()) == null){
            if (transaccion.getTipoTransaccion().equals(TipoTransaccion.RETIRO)) {
                return retirarFondos(transaccion);
            } else if (transaccion.getTipoTransaccion().equals(TipoTransaccion.DEPOSITO)) {
                return realizarDeposito(transaccion);
            } else if (transaccion.getTipoTransaccion().equals(TipoTransaccion.TRANSFERENCIA)) {
                return realizarTransferencia(transaccion);
            }
        }
        return false;
    }

    public boolean validarPresupuesto(Transaccion transaccion) {
        Presupuesto presupuesto = transaccion.getCuentaOrigen().getPresupuestoAsociado();
        return presupuesto.getMontoGastado()+transaccion.getMonto() <= presupuesto.getMontoTotal();
    }

    public boolean validarSaldo(Transaccion transaccion) {
        Cuenta cuenta = transaccion.getCuentaOrigen();
        return cuenta.getSaldo() >= transaccion.getMonto();
    }

    private boolean retirarFondos(Transaccion transaccion) {
        if (validarPresupuesto(transaccion) || validarSaldo(transaccion)) {
            Cuenta cuentaOrigen = transaccion.getCuentaOrigen();
            cuentaOrigen.actualizarSaldo(transaccion.getMonto()*-1);
            cuentaOrigen.getUsuarioAsociado().actualizarSaldoTotal();
            cuentaOrigen.getPresupuestoAsociado().actualizarMontoGastado(transaccion.getMonto());
            listaTransacciones.add(transaccion);
            cuentaOrigen.getUsuarioAsociado().getListaTransacciones().add(transaccion);
            return true;
        }
        return false;
    }

    private boolean realizarTransferencia(Transaccion transaccion) {
        if (validarPresupuesto(transaccion) || validarSaldo(transaccion)) {
            Cuenta cuentaOrigen = transaccion.getCuentaOrigen();
            Cuenta cuentaDestino = transaccion.getCuentaDestino();
            cuentaOrigen.actualizarSaldo(transaccion.getMonto()*-1);
            cuentaDestino.actualizarSaldo(transaccion.getMonto());
            cuentaOrigen.getPresupuestoAsociado().actualizarMontoGastado(transaccion.getMonto());
            listaTransacciones.add(transaccion);
            cuentaOrigen.getUsuarioAsociado().getListaTransacciones().add(transaccion);
            return true;
        }
        return false;
    }

    private boolean realizarDeposito(Transaccion transaccion) {
        Cuenta cuenta = transaccion.getCuentaOrigen();
        cuenta.actualizarSaldo(transaccion.getMonto());
        cuenta.getUsuarioAsociado().actualizarSaldoTotal();
        listaTransacciones.add(transaccion);
        cuenta.getUsuarioAsociado().getListaTransacciones().add(transaccion);
        return true;
    }

    @Override
    public Transaccion obtenerTransaccion(int idTransaccion) {
        for (Transaccion transaccion : listaTransacciones){
            if (transaccion.getId() == idTransaccion){
                return transaccion;
            }
        }
        return null;
    }

    public boolean validarContraseniaAdministrador(int contrasenia) {
        return administrador.getContrasenia() == contrasenia;
    }

    public boolean validarDatosUsuario(String id, int contrasenia) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id) && usuario.getContrasenia() == contrasenia){
                return true;
            }
        }
        return false;
    }

    public LinkedList<String> obtenerUsuariosId() {
        LinkedList<String> listaUsuariosId = new LinkedList<>();
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosId.add(usuario.getId());
        }
        return listaUsuariosId;
    }

    public LinkedList<String> obtenerCategoriasNombresDeUsuario(String idUsuario) {
        Usuario usuario = obtenerUsuario(idUsuario);
        LinkedList<String> listaCategoriasNombres = new LinkedList<>();
        if (usuario != null) {
            for (Categoria categoria : usuario.getListaCategorias()){
                listaCategoriasNombres.add(categoria.getNombre());
            }
        }
        return listaCategoriasNombres;
    }

    public LinkedList<String> obtenerNumeroCuentasUsuario(String idUsuario) {
        Usuario usuario = obtenerUsuario(idUsuario);
        LinkedList<String> listaNumCuentasUsuario = new LinkedList<>();
        if (usuario != null) {
            for (Cuenta cuenta : usuario.getListaCuentas()){
                listaNumCuentasUsuario.add(cuenta.getNumeroCuenta());
            }
        }
        return listaNumCuentasUsuario;
    }

    public int obtenerNuevoIdTransaccion() {
        return listaTransacciones.size()+1;
    }
}