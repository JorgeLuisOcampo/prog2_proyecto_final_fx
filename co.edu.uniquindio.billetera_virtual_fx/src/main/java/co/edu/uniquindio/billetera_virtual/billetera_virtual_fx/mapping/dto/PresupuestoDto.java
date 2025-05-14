package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto;

public record PresupuestoDto(
        String nombre,
        String id,
        String cuentaAsociada,
        double montoLimite,
        double montoGastado,
        String categoria
) {
}
