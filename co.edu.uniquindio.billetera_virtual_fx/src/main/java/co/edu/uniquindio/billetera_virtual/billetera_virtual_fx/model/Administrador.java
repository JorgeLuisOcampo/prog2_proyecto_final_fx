package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.ArrayList;

public class Administrador extends Persona implements EntidadAdministrador {
    private String idAdministrador;
    private ArrayList<Usuario> listaUsuarios;

    public Administrador(String nombre, String apellidos, String email,
                         String telefono, String idAdministrador) {
        super(nombre, apellidos, email, telefono);
        this.idAdministrador = idAdministrador;
        this.listaUsuarios = new ArrayList<>();
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }


    @Override
    public void crearUsuario() {

    }

    @Override
    public void actualizarUsuario() {

    }

    @Override
    public void eliminarUsuario() {

    }

    @Override
    public void listarUsuarios() {

    }

    @Override
    public void agregarCuenta() {

    }

    @Override
    public void actualizarCuenta() {

    }

    @Override
    public void eliminarCuenta() {

    }

    @Override
    public void crearTransaccion() {

    }

    @Override
    public void listarTransaccion() {

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
}
