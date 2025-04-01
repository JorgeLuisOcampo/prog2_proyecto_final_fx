package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import java.util.ArrayList;

public class Administrador extends Persona implements EntidadUsuario {
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
