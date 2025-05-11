package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.IEntidadUsuario;

import java.util.ArrayList;

public class Usuario extends InicioSesion implements IEntidadUsuario {
    private BilleteraVirtual billetera;
    private String idUsuario;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private double saldoTotal;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTransacciones;
    private ArrayList<Presupuesto> listaPresupuestos;

    /**
     * Constructor vacio de la clase Usuario
     */
    public Usuario(){

        listaCuentas = new ArrayList<>();
        listaTransacciones = new ArrayList<>();
        listaPresupuestos = new ArrayList<>();
    }

    /**
     * Constructor con parametros de la clase Usuario
     * @param contrasenia
     * @param email
     * @param idUsuario
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param direccion
     * @param billetera
     */
    public Usuario(String contrasenia, String email, String idUsuario,
                   String nombre, String apellidos, String telefono,
                   String direccion, BilleteraVirtual billetera
                   ) {
        super(contrasenia, email);
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.saldoTotal = saldoTotal;
        listaCuentas = new ArrayList<>();
        listaTransacciones = new ArrayList<>();
        listaPresupuestos = new ArrayList<>();
    }


    @Override
    public void iniciarSesion() {

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
    public void listarTransacciones() {

    }

    @Override
    public void listarPresupuestos() {

    }

    @Override
    public void consultarSaldo() {

    }

    @Override
    public void transaccionesCuenta() {

    }
    /**
     * Metodo para obtener el id de la cuenta
     * @return
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Metodo para setear el id de la cuenta
     * @param idUsuario
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Metodo para obtener el nombre de la cuenta
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para setear el nombre de la cuenta
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el apellido de la cuenta
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Metodo para setear el apellido de la cuenta
     * @param apellido
     */
    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    /**
     * Metodo para obtener el telefono de la cuenta
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo para setear el telefono de la cuenta
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para obtener la direccion de la cuenta
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo para setear la direccion de la cuenta
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo para obtener el saldo total de la cuenta
     * @return
     */
    public double getSaldoTotal() {
        return saldoTotal;
    }

    /**
     * Metodo para setear el saldo total de la cuenta
     * @param saldoTotal
     */
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    /**
     * Metodo para obtener la lista de cuentas
     * @return
     */
    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    /**
     * Metodo para setear la lista de cuentas
     * @param listaCuentas
     */
    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
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
