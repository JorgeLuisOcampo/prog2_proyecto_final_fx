package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

public record PresupuestoDto(
        int idPresupuesto, String nombre, double montoTotalAsignado,
        double montoGastado, String idUsuario, String cuentaAsociada,
        String categoria
) {
}
