package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.ArrayList;

public class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private Presupuesto presupuestoAsociado;

    public Categoria(String id, String nombre, String descripcion,Presupuesto presupuestoAsociado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuestoAsociado = presupuestoAsociado;
    }

    /**
     * Metodo para obtener el id de la categoria
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo para setear el id de la categoria
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el nombre de la categoria
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para setear el nombre de la categoria
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la descripcion de la categoria
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo para setear la descripcion de la categoria
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Presupuesto getPresupuestoAsociado() {
        return presupuestoAsociado;
    }

    public void setPresupuestoAsociado(Presupuesto presupuestoAsociado) {
        this.presupuestoAsociado = presupuestoAsociado;
    }
}
