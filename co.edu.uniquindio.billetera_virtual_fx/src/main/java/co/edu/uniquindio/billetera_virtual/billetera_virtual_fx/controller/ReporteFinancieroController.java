package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CuentaDto;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.TransaccionDto;

import java.time.LocalDate;
import java.util.LinkedList;

public class ReporteFinancieroController {
    ModelFactory modelFactory;

    public ReporteFinancieroController() {
        modelFactory = ModelFactory.getInstance();
    }

    public LinkedList<TransaccionDto> obtenerListaTransaccionesGastos(String idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        return modelFactory.obtenerListaTransaccionesGastos(idUsuario, fechaInicio, fechaFin);
    }

    public LinkedList<TransaccionDto> obtenerListaTransaccionesIngresos(String idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        return modelFactory.obtenerListaTransaccionesIngresos(idUsuario, fechaInicio, fechaFin);
    }

    public LinkedList<CuentaDto> obtenerListaCuentas(String idUsuario) {
        return modelFactory.obtenerCuentasUsuario(idUsuario);
    }
}
