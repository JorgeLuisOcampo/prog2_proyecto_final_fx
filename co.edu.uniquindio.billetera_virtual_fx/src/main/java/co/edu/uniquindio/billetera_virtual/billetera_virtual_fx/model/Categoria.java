package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

public class Categoria {
    private String id;
    private String nombre;
    private double monto;
    private String descripcion;

    public Categoria(String id, String nombre, double monto, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
