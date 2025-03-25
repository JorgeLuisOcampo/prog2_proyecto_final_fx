package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.builder;

public class Cuenta {
    private String id;
    private String nombreBanco;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private String idAdministrador;

    public Cuenta(String id, String nombreBanco, String numeroCuenta,
                  TipoCuenta tipoCuenta, String idAdministrador) {
        this.id = id;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.idAdministrador = idAdministrador;
    }


}
