package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.builder.TransaccionBuilder;

import java.time.LocalDate;

public class Transaccion {
    private BilleteraVirtual billeteraVirtual;
    private int id;
    private LocalDate fecha;
    private double monto;
    private String detalle;
    private Usuario usuarioAsociado;
    private TipoTransaccion tipoTransaccion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public Transaccion() {
    }

    public Transaccion(int id, LocalDate fecha, double monto, String detalle, Usuario usuarioAsociado, TipoTransaccion tipoTransaccion, Cuenta cuentaOrigen, Cuenta cuentaDestino, BilleteraVirtual billeteraVirtual) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.detalle = detalle;
        this.usuarioAsociado = usuarioAsociado;
        this.tipoTransaccion = tipoTransaccion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.billeteraVirtual = billeteraVirtual;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public static TransaccionBuilder builder() {
        return new TransaccionBuilder();
    }
}
