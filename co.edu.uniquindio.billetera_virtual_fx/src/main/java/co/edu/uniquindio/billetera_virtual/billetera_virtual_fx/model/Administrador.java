package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.IEntidadAdministrador;

import java.util.ArrayList;

public class Administrador extends InicioSesion implements IEntidadAdministrador {
    private BilleteraVirtual billetera;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTransacciones;

    /**
     * Constructor vacio de la clase Administrador
     */
    public Administrador() {
        listaUsuarios = new ArrayList<>();
        listaCuentas = new ArrayList<>();
        listaTransacciones = new ArrayList<>();
        billetera = new BilleteraVirtual();
    }

    /**
     * Constructor con parametros de la clase Administrador
     * @param contrasenia
     * @param email

     */
    public Administrador(String contrasenia, String email) { // ArrayList<Usuario> listaUsuarios) {
        super(contrasenia, email);
        this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public void gastosComunes() {

    }

    @Override
    public void usuariosMasTransacciones() {

    }

    @Override
    public void saldoPromedioUsuarios() {

    }

    public Usuario buscarUsuario(Usuario usuario){
        return billetera.obtenerUsuario(usuario.getEmail());
    }
    /**
     * Metodo para obtener la lista de usuarios
     * @return
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    /**
     * Metodo para setear la lista de usuarios
     * @param listaUsuarios
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
}
