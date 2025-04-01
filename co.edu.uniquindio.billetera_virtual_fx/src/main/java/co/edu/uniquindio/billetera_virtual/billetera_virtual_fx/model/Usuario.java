package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.ArrayList;

public class Usuario extends Persona implements EntidadUsuario {
    private String idUsuario;
    private String direccion;
    private double saldoTotal;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTransacciones;
    private ArrayList<Presupuesto> listaPresupuestos;



    public Usuario(String nombre, String apellidos, String email, String telefono,
                   String idUsuario, String direccion, double saldoTotal) {
        super(nombre, apellidos, email, telefono);
        this.idUsuario = idUsuario;
        this.direccion = direccion;
        this.saldoTotal = saldoTotal;
        this.listaCuentas = new ArrayList<>();
        this.listaTransacciones = new ArrayList<>();
        this.listaPresupuestos = new ArrayList<>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public ArrayList<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    @Override
    public void registrarse() {

    }

    @Override
    public void iniciarSesion() {

    }

    @Override
    public void actualizarDatps() {

    }

    @Override
    public void depositarDinero() {

    }

    @Override
    public void retirarDinero() {

    }

    @Override
    public void transferirDinero() {

    }

    @Override
    public void crearPresupuesto() {

    }

    @Override
    public void modificarPresupuesto() {

    }

    @Override
    public void eliminarPresupuesto() {

    }

    @Override
    public void consultarPresupuesto() {

    }

    @Override
    public void gestionCuentas() {

    }

    @Override
    public void listaTransacciones() {

    }

    @Override
    public void listaPresupuestos() {

    }

    @Override
    public void consultarSaldo() {

    }

    @Override
    public void transaccionesCuenta() {

    }
}
