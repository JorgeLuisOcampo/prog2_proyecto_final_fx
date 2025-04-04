package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;

import java.util.ArrayList;

public class BilleteraVirtual {
    private String nombre;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    private ArrayList<Presupuesto> listaPresupuestos = new ArrayList<>();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public BilleteraVirtual(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public ArrayList<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(ArrayList<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Usuario buscarUsuario(String id) {
        for(Usuario usuario: listaUsuarios){
            if(id.equalsIgnoreCase(usuario.getIdUsuario())){
                return usuario;
            }
        }
        return null;
    }

    public boolean crearUsuario (Usuario nuevoUsuario){
        Usuario usuario = buscarUsuario(nuevoUsuario.getIdUsuario());
        if (usuario == null) {
            listaUsuarios.add(nuevoUsuario);
            return true;
        }
        return false;
    }

    public boolean actualizarUsuario (Usuario usuarioActualizado){
        Usuario usuario = buscarUsuario(usuarioActualizado.getIdUsuario());
        if(usuario != null){
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellidos(usuarioActualizado.getApellidos());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            return true;
        }
        return false;
    }

    public boolean eliminarUsuario (Usuario usuarioEliminado) {
        Usuario usuario = buscarUsuario(usuarioEliminado.getIdUsuario());
        if (usuario != null) {
            listaUsuarios.remove(usuarioEliminado);
            return true;
        }
        return false;
    }

    public void agregarAdministrador(Administrador administrador1) {
        listaAdministradores.add(administrador1);
    }
}
