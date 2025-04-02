package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.TipoTransaccion;

import java.time.LocalDate;

public class Transaccion {
    private String id;
    private LocalDate fechaTransaccion;
    private TipoTransaccion tipoTransaccion;
    private double monto;
    private String descripcion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public Transaccion(String id, LocalDate fechaTransaccion, TipoTransaccion tipoTransaccion,
                       double monto, String descripcion, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        this.id = id;
        this.fechaTransaccion = fechaTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
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

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
}
