package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.ArrayList;

public class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private String tipoOperacion;
    private ArrayList<Transaccion> listaTransacciones;
    private ArrayList<Presupuesto> listaPresupuestos;

    public Categoria(String id, String nombre, String descripcion, String tipoOperacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoOperacion = tipoOperacion;
        listaTransacciones = new ArrayList<>();
        listaPresupuestos = new ArrayList<>();
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

    /**
     * Metodo para obtener el tipo de operacion de la categoria
     * @return
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Metodo para setear el tipo de operacion de la categoria
     * @param tipoOperacion
     */
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * Metodo para obtener la lista de transacciones
     * @return
     */
    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /**
     * Metodo para setear la lista de transacciones
     * @param listaTransacciones
     */
    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    /**
     * Metodo para obtener la lista de presupuestos
     * @return
     */
    public ArrayList<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    /**
     * Metodo para setear la lista de presupuestos
     * @param listaPresupuestos
     */
    public void setListaPresupuestos(ArrayList<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }
}
