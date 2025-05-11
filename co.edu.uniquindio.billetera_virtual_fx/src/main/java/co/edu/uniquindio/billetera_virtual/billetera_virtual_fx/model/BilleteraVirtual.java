package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.UsuarioDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.*;

import java.util.ArrayList;

public class BilleteraVirtual implements IMetodosBilletera, ICrudUsuario, ICrudTransaccion,
                                         ICrudCuenta, ICrudPresupuesto, ICrudCategoria {
    private Administrador administrador = new Administrador("123456789", "jorgeO25@gmail.com");
    private String nombre;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
    private ArrayList<Presupuesto> listaPresupuestos = new ArrayList<>();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();
    /**
     * Constructor de la clase BilleteraVirtual
     * @param nombre
     */
    public BilleteraVirtual(String nombre) {
        this.nombre = nombre;
    }
    public BilleteraVirtual() {}



    /**
     * Metodo para filtrar las transacciones sea por fecha, tipo de transaccion o categoria
     *  debe añadir en el metodo
     */
    @Override
    public void filtrarTransaccion() {

    }

    @Override
    public void estadoPresupuesto() {

    }

    @Override
    public void montoGastado() {

    }

    @Override
    public void eliminarCuentasDesuso() {

    }

    @Override
    public void listarUsuarios() {

    }

    @Override
    public void listarCategorias() {

    }

    /**
     * Metodo para buscar un usuario en la lista de usuarios
     * @param id
     * @return
     */
    @Override
    public Usuario buscarUsuario(String id) {
        for(Usuario usuario: listaUsuarios){
            if(id.equalsIgnoreCase(usuario.getIdUsuario())){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Metodo para agregar un usuario a la lista de usuarios
     * @param nuevoUsuario
     * @return
     */
    @Override
    public boolean  agregarUsuario(Usuario nuevoUsuario){
        Usuario usuario = buscarUsuario(nuevoUsuario.getIdUsuario());
        if (usuario == null) {
            listaUsuarios.add(nuevoUsuario);
            return true;
        }
        return false;
    }

    /**
     * Metodo para actualizar un usuario en la lista de usuarios
     * @param usuarioActualizado
     * @return
     */
    @Override
    public boolean actualizarUsuario(Usuario usuarioActualizado){
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

    /**
     * Metodo para eliminar un usuario de la lista de usuarios
     * @param usuarioEliminado
     * @return
     */
    @Override
    public boolean eliminarUsuario(Usuario usuarioEliminado) {
        Usuario usuario = buscarUsuario(usuarioEliminado.getIdUsuario());
        if (usuario != null) {
            listaUsuarios.remove(usuarioEliminado);
            return true;
        }
        return false;
    }

    @Override
    public boolean agregarCategoria() {
        return false;
    }

    @Override
    public boolean actualizarCategoria() {
        return false;
    }

    @Override
    public boolean eliminarCategoria() {
        return false;
    }

    @Override
    public boolean agregarCuenta(CuentaDto cuentaDto) {
        return false;
    }

    @Override
    public boolean eliminarCuenta(CuentaDto cuentaDto) {
        return false;
    }

    @Override
    public boolean actualizarCuenta(CuentaDto cuentaDto) {
        return false;
    }

    @Override
    public boolean detallesCuenta(CuentaDto cuentaDto) {
        return false;
    }

    @Override
    public boolean agregarPresupuesto() {
        return false;
    }

    @Override
    public boolean eliminarPresupuesto() {
        return false;
    }

    @Override
    public boolean actualizarPresupuesto() {
        return false;
    }

    @Override
    public boolean agregarTransaccion(TransaccionDto transaccionDto) {
        return false;
    }

    @Override
    public boolean eliminarTransaccion(TransaccionDto transaccionDto) {
        return false;
    }

    public boolean verificarInfoAdm (String usuario, String contrasenia){
        if(administrador != null
                && administrador.getEmail() != null
                && administrador.getContrasenia() != null) {

            return administrador.getEmail().equals(usuario)
                    && administrador.getContrasenia().equals(contrasenia);
        }
        return false;
    }

    public boolean verificarInfoUsuario (String correo, String contrasenia){
        for(Usuario usuario: listaUsuarios){
            if(usuario.getEmail().equals(correo) && usuario.getContrasenia().equals(contrasenia)){
                return true;
            }
        }
        return false;
    }

    public Usuario obtenerUsuarioPorCredenciales(String correo, String contrasenia){
        for(Usuario usuario : listaUsuarios){
            if(usuario.getEmail().equals(correo) && usuario.getContrasenia().equals(contrasenia)){
                return usuario;
            }
        }
        return null;
    }


    /**
     * Metodo para obtener el nombre de la billetera
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para setear el nombre de la billetera
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     *  Metodo para obtener la lista de transacciones
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
     *  Metodo para setear la lista de presupuestos
     * @param listaPresupuestos
     */
    public void setListaPresupuestos(ArrayList<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }
    /**
     *  Metodo para obtener la lista de categorias
     * @return
     */
    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }
    /**
     * Metodo para setear la lista de categorias
     * @param listaCategorias
     */
    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Usuario obtenerUsuario(String correo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }
        return null;
    }
}
