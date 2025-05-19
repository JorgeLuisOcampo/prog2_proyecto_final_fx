package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.ICrudTransaccion;

import java.time.LocalDate;
import java.util.LinkedList;

public class Usuario implements ICrudTransaccion {
    private BilleteraVirtual billeteraVirtual;
    private String nombre;
    private String id;
    private String email;
    private String telefono;
    private String domicilio;
    private int contrasenia;
    private double saldoTotal;
    private LinkedList<Cuenta> listaCuentas;
    private LinkedList<Presupuesto> listaPresupuestos;
    private LinkedList<Transaccion> listaTransacciones;
    private LinkedList<Categoria> listaCategorias;

    public Usuario(){
        listaCuentas = new LinkedList<>();
        listaPresupuestos = new LinkedList<>();
        listaTransacciones = new LinkedList<>();
        listaCategorias = new LinkedList<>();
    }

    public Usuario(String nombre, String id, String email, String telefono, String domicilio, int contrasenia, BilleteraVirtual billeteraVirtual) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.contrasenia = contrasenia;
        this.billeteraVirtual = billeteraVirtual;
        listaCuentas = new LinkedList<>();
        listaPresupuestos = new LinkedList<>();
        listaTransacciones = new LinkedList<>();
        listaCategorias = new LinkedList<>();
    }

    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    public void setBilleteraVirtual(BilleteraVirtual billeteraVirtual) {
        this.billeteraVirtual = billeteraVirtual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public LinkedList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(LinkedList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
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

    public LinkedList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(LinkedList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    private Cuenta obtenerCuenta(int idCuenta) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getIdCuenta() == idCuenta) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public boolean agregarTransaccion(Transaccion transaccion) {
        return billeteraVirtual.agregarTransaccion(transaccion);
    }

    @Override
    public Transaccion obtenerTransaccion(int idTransaccion) {
        for (Transaccion transaccion : listaTransacciones) {
            if (transaccion.getId() == idTransaccion) {
                return transaccion;
            }
        }
        return null;
    }

    public boolean agregarCuenta(Cuenta cuenta) {
        if (cuenta.getPresupuestoAsociado().getCuentaAsociada() == null) {
            return billeteraVirtual.agregarCuenta(cuenta);
        }
        return false;
    }

    public boolean actualizarCuenta(Cuenta cuentaVieja, Cuenta nuevaCuenta) {
        return billeteraVirtual.actualizarCuenta(cuentaVieja, this.id,
                this.id, nuevaCuenta);
    }

    public boolean eliminarCuenta(int idCuenta, String numCuenta) {
        return billeteraVirtual.eliminarCuenta(idCuenta, numCuenta);
    }

    public void actualizarSaldoTotal() {
        double saldoTotal = 0;
        for (Cuenta cuenta : listaCuentas) {
            saldoTotal += cuenta.getSaldo();
        }
        this.saldoTotal = saldoTotal;
    }

    public boolean agregarCategoria(Categoria categoria) {
        if (obtenerCategoria(categoria) == null){
            return billeteraVirtual.agregarCategoria(categoria);
        }
        return false;
    }

    private Categoria obtenerCategoria(Categoria categoria) {
        for (Categoria categoriaTemporal : listaCategorias){
            if (categoriaTemporal.getNombre().equals(categoria.getNombre()) ||
                    categoriaTemporal.getId() == categoria.getId()) {
                return categoria;
            }
        }
        return null;
    }

    private Categoria obtenerCategoria(int idCategoria) {
        for (Categoria categoria : listaCategorias){
            if (categoria.getId() == idCategoria){
                return categoria;
            }
        }
        return null;
    }

    private Categoria obtenerCategoria(String nombreCategoria) {
        for (Categoria categoria : listaCategorias){
            if (categoria.getNombre().equalsIgnoreCase(nombreCategoria)){
                return categoria;
            }
        }
        return null;
    }

    public boolean eliminarCategoria(int idCategoria) {
        return billeteraVirtual.eliminarCategoria(idCategoria);
    }

    public boolean actualizarCategoria(int idCategoriaVieja, Categoria nuevaCategoria) {
        if (verificarActualizacionCategoria(idCategoriaVieja, nuevaCategoria)) {
            return billeteraVirtual.actualizarCategoria(idCategoriaVieja, nuevaCategoria);
        }
        return false;
    }

    public boolean verificarActualizacionCategoria(int idCategoriaVieja, Categoria nuevaCategoria) {
        Categoria categoriaVieja = obtenerCategoria(idCategoriaVieja);
        if (categoriaVieja != null) {
            if (obtenerCategoria(nuevaCategoria.getNombre()) == null ||
                    categoriaVieja.getNombre().equalsIgnoreCase(nuevaCategoria.getNombre())) {
                return obtenerCategoria(nuevaCategoria.getId()) == null ||
                        categoriaVieja.getId() == nuevaCategoria.getId();
            }
            return false;
        }
        return false;
    }

    public boolean agregarPresupuesto(Presupuesto presupuesto) {
        if (obtenerPresupuesto(presupuesto) == null) {
            if (billeteraVirtual.agregarPresupuesto(presupuesto)){
                listaPresupuestos.add(presupuesto);
                return true;
            }
        }
        return false;
    }

    private Presupuesto obtenerPresupuesto(Presupuesto presupuesto) {
        for (Presupuesto presupuestoTemporal : listaPresupuestos) {
            if (presupuestoTemporal.getNombre().equalsIgnoreCase(presupuesto.getNombre()) ||
                    presupuestoTemporal.getIdPresupuesto() == presupuesto.getIdPresupuesto()) {
                return presupuestoTemporal;
            }
        }
        return null;
    }

    private Presupuesto obtenerPresupuesto(int idPresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos){
            if (presupuesto.getIdPresupuesto() == idPresupuesto){
                return presupuesto;
            }
        }
        return null;
    }

    private Presupuesto obtenerPresupuesto(String nombrePresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos){
            if (presupuesto.getNombre().equalsIgnoreCase(nombrePresupuesto)){
                return presupuesto;
            }
        }
        return null;
    }

    public boolean actualizarPresupuesto(int idPresupuestoViejo, Presupuesto presupuestoNuevo) {
        if (verificarActualizacionPresupuesto(idPresupuestoViejo, presupuestoNuevo)) {
            return billeteraVirtual.actualizarPresupuesto(idPresupuestoViejo, presupuestoNuevo);
        }
        return false;
    }

    private boolean verificarActualizacionPresupuesto(int idPresupuestoViejo, Presupuesto presupuestoNuevo) {
        Presupuesto presupuestoViejo = obtenerPresupuesto(idPresupuestoViejo);
        if (presupuestoViejo != null) {
            if (obtenerPresupuesto(presupuestoNuevo.getNombre()) == null ||
                    presupuestoNuevo.getNombre().equalsIgnoreCase(presupuestoViejo.getNombre())) {
                return obtenerPresupuesto(presupuestoNuevo.getIdPresupuesto()) == null ||
                        presupuestoNuevo.getIdPresupuesto() == presupuestoViejo.getIdPresupuesto();
            }
            return false;
        }
        return false;
    }

    public boolean eliminarPresupuesto(int idPresupuesto) {
        return billeteraVirtual.eliminarPresupuesto(idPresupuesto);
    }

    public Presupuesto obtenerPresupuestoNombre(String nombrePresupuesto) {
        for (Presupuesto presupuesto : listaPresupuestos) {
            if (presupuesto.getNombre().equalsIgnoreCase(nombrePresupuesto)) {
                return presupuesto;
            }
        }
        return null;
    }

    public LinkedList<String> obtenerPresupuestosDisponiblesNombres() {
        LinkedList<String> listaPresupuestosNombres = new LinkedList<>();
        for (Presupuesto presupuesto : listaPresupuestos) {
            if (presupuesto.getCuentaAsociada() == null) {
                listaPresupuestosNombres.add(presupuesto.getNombre());
            }
        }
        return listaPresupuestosNombres;
    }

    public LinkedList<String> obtenerPresupuestosNombres(){
        LinkedList<String> listaPresupuestosNombres = new LinkedList<>();
        for (Presupuesto presupuesto : listaPresupuestos) {
            listaPresupuestosNombres.add(presupuesto.getNombre());
        }
        return listaPresupuestosNombres;
    }

    public LinkedList<Transaccion> obtenerListaTransaccionesIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        LinkedList<Transaccion> listaTransaccionesIngresos = new LinkedList<>();
        for (Transaccion transaccion : listaTransacciones) {
            LocalDate fechaTransaccion = transaccion.getFecha();
            if (transaccion.getTipoTransaccion().equals(TipoTransaccion.DEPOSITO)
                    && !fechaTransaccion.isBefore(fechaInicio)
                    && !fechaTransaccion.isAfter(fechaFin)){
                listaTransaccionesIngresos.add(transaccion);
            }
        }
        return listaTransaccionesIngresos;
    }

    public LinkedList<Transaccion> obtenerListaTransaccionesGastos(LocalDate fechaInicio, LocalDate fechaFin) {
        LinkedList<Transaccion> listaTransaccionesGastos = new LinkedList<>();
        for (Transaccion transaccion : listaTransacciones) {
            TipoTransaccion tipoTransaccion = transaccion.getTipoTransaccion();
            LocalDate fechaTransaccion = transaccion.getFecha();
            if (!tipoTransaccion.equals(TipoTransaccion.DEPOSITO)
                    && !fechaTransaccion.isBefore(fechaInicio)
                    && !fechaTransaccion.isAfter(fechaFin)){
                listaTransaccionesGastos.add(transaccion);
            }
        }
        return listaTransaccionesGastos;
    }

    public LinkedList<String> obtenerCategoriasDisponibles() {
        LinkedList<String> listaCategoriasDisponibles = new LinkedList<>();
        for (Categoria categoria : listaCategorias) {
            if (categoria.getPresupuestoAsociado() == null) {
                listaCategoriasDisponibles.add(categoria.getNombre());
            }
        }
        return listaCategoriasDisponibles;
    }
}
