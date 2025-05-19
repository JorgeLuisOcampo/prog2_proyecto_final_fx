package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.ICrudCuenta;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.ICrudUsuario;

public class Administrador implements ICrudUsuario, ICrudCuenta {
    private BilleteraVirtual billeteraVirtual;
    private int contrasenia;

    public Administrador(BilleteraVirtual billeteraVirtual, int contrasenia) {
        this.billeteraVirtual = billeteraVirtual;
        this.contrasenia = contrasenia;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        return billeteraVirtual.agregarUsuario(usuario);
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return billeteraVirtual.eliminarUsuario(id);
    }

    @Override
    public boolean actualizarUsuario(String id, Usuario nuevoUsuario) {
        return billeteraVirtual.actualizarUsuario(id, nuevoUsuario);
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        return billeteraVirtual.obtenerUsuario(id);
    }

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        return billeteraVirtual.agregarCuenta(cuenta);
    }

    @Override
    public boolean eliminarCuenta(int id, String numCuenta) {
        return billeteraVirtual.eliminarCuenta(id, numCuenta);
    }

    @Override
    public boolean actualizarCuenta(Cuenta cuentaVieja, String idUsuarioViejo, String idUsuarioNuevo,Cuenta nuevaCuenta) {
        return billeteraVirtual.actualizarCuenta(cuentaVieja, idUsuarioViejo, idUsuarioNuevo, nuevaCuenta);
    }

    @Override
    public Cuenta obtenerCuenta(int id, String numCuenta) {
        return billeteraVirtual.obtenerCuenta(id, numCuenta);
    }
}
