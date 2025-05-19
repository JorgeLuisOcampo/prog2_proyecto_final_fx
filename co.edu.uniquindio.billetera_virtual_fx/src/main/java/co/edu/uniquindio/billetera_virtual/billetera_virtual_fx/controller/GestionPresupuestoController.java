package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory.ModelFactory;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.PresupuestoDto;

import java.util.LinkedList;

public class GestionPresupuestoController {
    ModelFactory modelFactory;

    public GestionPresupuestoController() {
        this.modelFactory = ModelFactory.getInstance();
    }

    public LinkedList<PresupuestoDto> obtenerPresupuestos(String idUsuario) {
        return modelFactory.obtenerPresupuestos(idUsuario);
    }

    public boolean agregarPresupuesto(PresupuestoDto presupuestoDto) {
        return modelFactory.agregarPresupuesto(presupuestoDto);
    }

    public boolean eliminarPresupuesto(int idPresupuesto, String idUsuario) {
        return modelFactory.eliminarPresupuesto(idPresupuesto, idUsuario);
    }

    public boolean actualizarPresupuesto(int idPresupuestoViejo, PresupuestoDto presupuestoDto){
        return modelFactory.actualizarPresupuesto(idPresupuestoViejo, presupuestoDto);
    }

    public LinkedList<String> obtenerCategoriasDisponibles(String idUsuario) {
        return modelFactory.obtenerCategoriasDisponibles(idUsuario);
    }
}
