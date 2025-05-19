package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

public class Presupuesto {
    private BilleteraVirtual billeteraVirtual;
    private int idPresupuesto;
    private String nombre;
    private double montoTotal;
    private double montoGastado;
    private Usuario usuarioAsociado;
    private Cuenta cuentaAsociada;
    private Categoria categoriaAsociada;

    public Presupuesto() {}

    public Presupuesto(int idPresupuesto, String nombre, double montoTotal, Usuario usuarioAsociado, Categoria categoriaAsociada, BilleteraVirtual billeteraVirtual) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.montoGastado = 0;
        this.usuarioAsociado = usuarioAsociado;
        this.categoriaAsociada = categoriaAsociada;
        this.billeteraVirtual = billeteraVirtual;
    }

    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    public void setBilleteraVirtual(BilleteraVirtual billeteraVirtual) {
        this.billeteraVirtual = billeteraVirtual;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(double montoGastado) {
        this.montoGastado = montoGastado;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public Cuenta getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void setCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public Categoria getCategoriaAsociada() {
        return categoriaAsociada;
    }

    public void setCategoriaAsociada(Categoria categoriaAsociada) {
        this.categoriaAsociada = categoriaAsociada;
    }

    public void actualizarMontoGastado(double monto) {
        montoGastado += monto;
    }
}
