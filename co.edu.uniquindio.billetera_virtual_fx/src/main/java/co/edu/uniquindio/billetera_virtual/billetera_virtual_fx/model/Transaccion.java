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
    private Usuario usuario;
    private Administrador administrador;

    /**
     * Constructor de la clase Transaccion
     * @param id
     * @param fechaTransaccion
     * @param tipoTransaccion
     * @param monto
     * @param descripcion
     * @param cuentaOrigen
     * @param cuentaDestino
     */
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

    /**
     * Metodo para obtener el id de la transaccion
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo para setear el id de la transaccion
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo para obtener la fecha de la transaccion
     * @return
     */
    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    /**
     * Metodo para setear la fecha de la transaccion
     * @param fechaTransaccion
     */
    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    /**
     * Metodo para obtener el tipo de transaccion
     * @return
     */
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * Metodo para setear el tipo de transaccion
     * @param tipoTransaccion
     */
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Metodo para obtener el monto de la transaccion
     * @return
     */
    public double getMonto() {
        return monto;
    }
    /**
     * Metodo para setear el monto de la transaccion
     * @param monto
     */
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
