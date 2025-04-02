package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.builder;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

import java.util.ArrayList;

public class AdministradorBuilder {
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected String telefono;
    protected String idAdministrador;
    //protected ArrayList<Usuario> listaUsuarios;

    public AdministradorBuilder nombre (String nombre) {
        this.nombre = nombre;
        return this;
    }
    public AdministradorBuilder apellidos (String apellidos) {
        this.apellidos = apellidos;
        return this;
    }
    public AdministradorBuilder email (String email) {
        this.email = email;
        return this;
    }
    public AdministradorBuilder telefono (String telefono) {
        this.telefono = telefono;
        return this;
    }
    public AdministradorBuilder idAdministrador (String idAdministrador) {
        this.idAdministrador = idAdministrador;
        return this;
    }
    /*
    public AdministradorBuilder listaUsuarios (ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios = new ArrayList<Usuario>();
        return this;
    }
    */
    public Administrador build () {
        return new Administrador(nombre, apellidos, email, telefono, idAdministrador); //,listaUsuarios);
    }
}
