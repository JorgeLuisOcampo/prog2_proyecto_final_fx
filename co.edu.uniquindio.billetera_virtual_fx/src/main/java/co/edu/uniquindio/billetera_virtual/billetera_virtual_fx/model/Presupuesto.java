package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

public class Presupuesto {
    private String nombre;
    private String id;
    private Cuenta cuentaAsociada;
    private double montoLimite;
    private double montoGastado;
    private Categoria categoria;

    /**
     *  Constructor clase Presupuesto
     * @param id
     * @param nombre
     * @param cuentaAsociada
     * @param montoLimite
     * @param montoGastado
     * @param categoria
     */
    public Presupuesto(String id, String nombre, Cuenta cuentaAsociada, double montoLimite, double montoGastado, Categoria categoria) {
        this.nombre = nombre;
        this.id = id;
        this.cuentaAsociada = cuentaAsociada;
        this.montoLimite = montoLimite;
        this.montoGastado = montoGastado;
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

    public Cuenta getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void setCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public double getMontoLimite() {
        return montoLimite;
    }

    public void setMontoLimite(double montoLimite) {
        this.montoLimite = montoLimite;
    }

    public double getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(double montoGastado) {
        this.montoGastado = montoGastado;
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
