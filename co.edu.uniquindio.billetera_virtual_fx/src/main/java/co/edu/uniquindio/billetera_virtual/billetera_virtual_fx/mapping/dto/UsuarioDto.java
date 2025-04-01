package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Cuenta;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Presupuesto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Transaccion;

import java.util.ArrayList;

public record UsuarioDto(
        String nombre, String apellidos, String email, String telefono,
        String idUsuario, String direccion, double saldoTotal) {
}
