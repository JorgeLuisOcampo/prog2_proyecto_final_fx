package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

public class Presupuesto {
    private String id;
    private String nombre;
    private double monto;
    private String descripcion;
    private Categoria categoria;

    /**
     * Constructor de la clase Presupuesto
     * @param id
     * @param nombre
     * @param monto
     * @param descripcion
     * @param categoria
     */
    public Presupuesto(String id, String nombre, double monto, String descripcion, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    /**
     * Metodo para obtener el id del presupuesto
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo para setear el id del presupuesto
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el nombre del presupuesto
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para setear el nombre del
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el monto del presupuesto
     * @return
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Metodo para setear el monto del presupuesto
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Metodo para obtener la descripcion del presupuesto
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo para setear la descripcion del presupuesto
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo para obtener la categoria del presupuesto
     * @return
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Metodo para setear la categoria del presupuesto
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
