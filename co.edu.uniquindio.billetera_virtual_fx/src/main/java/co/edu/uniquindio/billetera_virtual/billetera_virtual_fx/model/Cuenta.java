package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.LinkedList;

public class Cuenta {
    private BilleteraVirtual billeteraVirtual;
    private int idCuenta;
    private String banco;
    private String numeroCuenta;
    private Usuario usuarioAsociado;
    private TipoCuenta tipoCuenta;
    private LinkedList<Transaccion> listaTransacciones;
    private double saldo;
    private Presupuesto presupuestoAsociado;

    public Cuenta(){
        listaTransacciones = new LinkedList<>();
        saldo = 0;
    }

    public Cuenta(int idCuenta, String banco, String numeroCuenta, Usuario usuarioAsociado, TipoCuenta tipoCuenta, BilleteraVirtual billeteraVirtual, Presupuesto presupuestoAsociado) {
        this.idCuenta = idCuenta;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.usuarioAsociado = usuarioAsociado;
        this.tipoCuenta = tipoCuenta;
        this.billeteraVirtual = billeteraVirtual;
        listaTransacciones = new LinkedList<>();
        this.saldo = 0;
        this.presupuestoAsociado = presupuestoAsociado;
    }

    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    public void setBilleteraVirtual(BilleteraVirtual billeteraVirtual) {
        this.billeteraVirtual = billeteraVirtual;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void modificarSaldoTotal(double saldoDado) {
        saldo = saldo+saldoDado;
    }

    public Presupuesto getPresupuestoAsociado() {
        return presupuestoAsociado;
    }

    public void setPresupuestoAsociado(Presupuesto presupuestoAsociado) {
        this.presupuestoAsociado = presupuestoAsociado;
    }

    public void actualizarSaldo(double monto){
        saldo += monto;
    }
}
