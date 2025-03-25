package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.builder;

import java.time.LocalDate;

public class Transaccion {
    private String id;
    private LocalDate fechaTransaccion;
    private TipoTransaccion tipoTransaccion;
    private double monto;
    private String descripcion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

}
