package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;

public class DataUtil {

    public static BilleteraVirtual inicializarDatos() {
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual("TRST Wallet");
        Usuario usuario1 = new Usuario("1", "1", "1005087768",
                "esteban", "valencia bejarano", "3009824495", "B/ciudad Dorada", billeteraVirtual);
        Usuario usuario2 = new Usuario("2", "2",
                "1069870463", "Jorge", "Ocampo",
                "3158876498", "Carrera 1 calle 2", billeteraVirtual);
        Usuario usuario3 = new Usuario("3", "3", "10947894561", "Santiago",
                "Vallejo", "3145874621", "Calle San Diego", billeteraVirtual);


        Administrador administrador = new Administrador(
                "123456789",
                "jorgeO25@gmail.com");


        Categoria categoriaJorge1 = new Categoria("1", "Salud", "Gastos medicos", null);
        Categoria categoriaJorge2 = new Categoria("2", "Servicios", "Gasto Servicio public", null);
        Categoria categoriaJorge3 = new Categoria("3", "Transporte", "Gastos de transporte", null);

        Presupuesto presupuestoJorge1 = new Presupuesto("1", "costos fijos", 250000, "costos mensuales", categoriaJorge1);
        Presupuesto presupuestoJorge2 = new Presupuesto("2", "costos variables", 536450, "costos semanales", categoriaJorge2);
        Presupuesto presupuestoJorge3 = new Presupuesto("3", "costos impredecibles", 831500, "costos anuales", categoriaJorge3);

        categoriaJorge1.setPresupuestoAsociado(presupuestoJorge1);
        categoriaJorge2.setPresupuestoAsociado(presupuestoJorge2);
        categoriaJorge3.setPresupuestoAsociado(presupuestoJorge3);

        usuario2.getListaPresupuestos().add(presupuestoJorge1);
        usuario2.getListaPresupuestos().add(presupuestoJorge2);
        usuario2.getListaPresupuestos().add(presupuestoJorge3);

        usuario1.getListaPresupuestos().add(presupuestoJorge1);
        usuario1.getListaPresupuestos().add(presupuestoJorge2);
        usuario1.getListaPresupuestos().add(presupuestoJorge3);

        usuario3.getListaPresupuestos().add(presupuestoJorge1);
        usuario3.getListaPresupuestos().add(presupuestoJorge2);
        usuario3.getListaPresupuestos().add(presupuestoJorge3);

        billeteraVirtual.agregarUsuario(usuario1);
        billeteraVirtual.agregarUsuario(usuario2);
        billeteraVirtual.agregarUsuario(usuario3);



        return billeteraVirtual;
    }
}
