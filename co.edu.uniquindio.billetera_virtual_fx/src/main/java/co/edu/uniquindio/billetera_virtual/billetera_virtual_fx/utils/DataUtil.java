package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.TipoCuenta;

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


        Categoria categoria1 = new Categoria("1", "Salud", "Gastos medicos", null);
        Categoria categoria2 = new Categoria("2", "Servicios", "Gasto Servicio public", null);
        Categoria categoria3 = new Categoria("3", "Transporte", "Gastos de transporte", null);

        usuario1.getListaCategorias().add(categoria1);
        usuario1.getListaCategorias().add(categoria2);
        usuario1.getListaCategorias().add(categoria3);


        Presupuesto presupuesto1 = new Presupuesto("1","Medicamentos", null, 91240, 29800, categoria1);
        Presupuesto presupuesto2 = new Presupuesto("2","Agua y Energia", null, 250000, 101220, categoria2);
        Presupuesto presupuesto3 = new Presupuesto("3","Gasolina y buses", null, 250000, 123450, categoria3);

        Cuenta cuenta1 = new Cuenta ( "1","Banbolombia", "182182", TipoCuenta.AHORRO, 5000000 );

        presupuesto1.setCuentaAsociada(cuenta1);
        presupuesto2.setCuentaAsociada(cuenta1);
        presupuesto3.setCuentaAsociada(cuenta1);


        categoria1.setPresupuestoAsociado(presupuesto1);
        categoria2.setPresupuestoAsociado(presupuesto2);
        categoria3.setPresupuestoAsociado(presupuesto3);

        usuario1.getListaPresupuestos().add(presupuesto1);
        usuario1.getListaPresupuestos().add(presupuesto2);
        usuario1.getListaPresupuestos().add(presupuesto3);


        billeteraVirtual.agregarUsuario(usuario1);
        billeteraVirtual.agregarUsuario(usuario2);
        billeteraVirtual.agregarUsuario(usuario3);



        return billeteraVirtual;
    }
}
