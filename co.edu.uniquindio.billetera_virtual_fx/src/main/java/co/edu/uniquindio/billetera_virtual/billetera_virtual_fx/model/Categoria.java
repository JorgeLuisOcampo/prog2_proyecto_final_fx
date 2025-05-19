package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.LinkedList;

public class Categoria {
    private BilleteraVirtual billeteraVirtual;
    private int id;
    private Usuario usuarioAsociado;
    private String nombre;
    private String descripcion;
    private LinkedList<Transaccion> listaTransacciones;
    private Presupuesto presupuestoAsociado;

    public Categoria() {
        this.listaTransacciones = new LinkedList<>();
    }

    public Categoria(int id, String nombre, String descripcion, Usuario usuario,
                     Presupuesto presupuestoAsociado, BilleteraVirtual billeteraVirtual) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioAsociado = usuario;
        this.descripcion = descripcion;
        this.billeteraVirtual = billeteraVirtual;
        this.presupuestoAsociado = presupuestoAsociado;
        this.listaTransacciones = new LinkedList<>();
    }

    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    public void setBilleteraVirtual(BilleteraVirtual billeteraVirtual) {
        this.billeteraVirtual = billeteraVirtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public Presupuesto getPresupuestoAsociado() {
        return presupuestoAsociado;
    }

    public void setPresupuestoAsociado(Presupuesto presupuestoAsociado) {
        this.presupuestoAsociado = presupuestoAsociado;
    }
}
