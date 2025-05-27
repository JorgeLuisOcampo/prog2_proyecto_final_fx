package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.*;

import java.time.LocalDate;

public class DataUtil {

    public static BilleteraVirtual inicializarDatos(){
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual("Billetera UQ");
        Usuario usuario1 = new Usuario("Jorge Ocampo", "1094906443", "jorgeocampo@gmail.com", "315514514", "Calle 24-12", 5555, billeteraVirtual);
        Usuario usuario2 = new Usuario("Esteban Valencia", "1094800800", "estebanvalencia@gmail.com", "315515515", "Avenida 182", 7777, billeteraVirtual);
        Categoria categoria1 = new Categoria(1, "Mercado", "Mercado", usuario1, null, billeteraVirtual);
        Categoria categoria2 = new Categoria(2, "Varios", "Gastos varios", usuario1, null, billeteraVirtual);
        Categoria categoria3 = new Categoria(3, "Gasolina", "Transporte", usuario1, null, billeteraVirtual);
        Presupuesto presupuesto1 = new Presupuesto(1, "Alimento", 780000, usuario1, categoria1, billeteraVirtual);
        Presupuesto presupuesto2 = new Presupuesto(2, "Varios", 520000, usuario1, categoria2, billeteraVirtual);
        Presupuesto presupuesto3 = new Presupuesto(3, "Transporte", 190000, usuario1, categoria3, billeteraVirtual);
        Cuenta cuenta1 = new Cuenta(1, "Banco Agrario", "54781542", usuario1, TipoCuenta.AHORRO, billeteraVirtual, presupuesto1);
        Cuenta cuenta2 = new Cuenta(2, "Banco Occidente", "26589454", usuario1, TipoCuenta.AHORRO, billeteraVirtual, presupuesto2);
        Cuenta cuenta3 = new Cuenta(3, "Banco Popular", "9874561", usuario1, TipoCuenta.CORRIENTE, billeteraVirtual, presupuesto3);
        billeteraVirtual.agregarUsuario(usuario1);
        billeteraVirtual.agregarUsuario(usuario2);
        usuario1.agregarCategoria(categoria1);
        usuario1.agregarCategoria(categoria2);
        usuario1.agregarCategoria(categoria3);
        usuario1.agregarPresupuesto(presupuesto1);
        usuario1.agregarPresupuesto(presupuesto2);
        usuario1.agregarPresupuesto(presupuesto3);
        usuario1.agregarCuenta(cuenta1);
        usuario1.agregarCuenta(cuenta2);
        usuario1.agregarCuenta(cuenta3);
        Transaccion transaccion1 = new Transaccion(1, LocalDate.of(2025,5,3), 700000, "Salario compañia", usuario1, TipoTransaccion.DEPOSITO, cuenta1, null, billeteraVirtual);
        Transaccion transaccion2 = new Transaccion(2, LocalDate.of(2025,5,5), 25000, "Inversiones", usuario1, TipoTransaccion.DEPOSITO, cuenta1, null, billeteraVirtual);
        Transaccion transaccion3 = new Transaccion(3, LocalDate.of(2025,5,7), 300000, "Intereses CDT", usuario1, TipoTransaccion.DEPOSITO, cuenta1, null, billeteraVirtual);
        Transaccion transaccion4 = new Transaccion(4, LocalDate.of(2025,5,11), 150000, "Devolución TEMU", usuario1, TipoTransaccion.DEPOSITO, cuenta2, null, billeteraVirtual);
        Transaccion transaccion5 = new Transaccion(5, LocalDate.of(2025,5,12), 20000, "Venta de mercancía", usuario1, TipoTransaccion.DEPOSITO, cuenta2, null, billeteraVirtual);
        Transaccion transaccion6 = new Transaccion(6, LocalDate.of(2025,5,13), 300000, "Consignación internacional", usuario1, TipoTransaccion.DEPOSITO, cuenta2, null, billeteraVirtual);
        Transaccion transaccion7 = new Transaccion(7, LocalDate.of(2025,5,22), 76000, "Pago intereses Omer", usuario1, TipoTransaccion.DEPOSITO, cuenta2, null, billeteraVirtual);
        Transaccion transaccion8 = new Transaccion(8, LocalDate.of(2025,5,22), 110000, "Pago intereses Consuelo", usuario1, TipoTransaccion.DEPOSITO, cuenta3, null, billeteraVirtual);
        Transaccion transaccion9 = new Transaccion(9, LocalDate.of(2025,5,23), 15000, "Para cubrir gasolina", usuario1, TipoTransaccion.TRANSFERENCIA, cuenta1, cuenta2, billeteraVirtual);
        Transaccion transaccion10 = new Transaccion(10, LocalDate.of(2025,5,23), 2000, "Calibrar llantas moto", usuario1, TipoTransaccion.TRANSFERENCIA, cuenta1, cuenta3, billeteraVirtual);
        Transaccion transaccion11 = new Transaccion(11, LocalDate.of(2025,5,23), 30000, "Lavado y encerada moto", usuario1, TipoTransaccion.TRANSFERENCIA, cuenta2, cuenta3, billeteraVirtual);
        Transaccion transaccion12 = new Transaccion(12, LocalDate.of(2025,5,23), 40000, "Comida para el fin de semana", usuario1, TipoTransaccion.TRANSFERENCIA, cuenta1, cuenta3, billeteraVirtual);
        Transaccion transaccion13 = new Transaccion(13, LocalDate.of(2025,5,24), 15000, "Gasolina", usuario1, TipoTransaccion.RETIRO, cuenta2, null, billeteraVirtual);
        Transaccion transaccion14 = new Transaccion(14, LocalDate.of(2025,5,24), 2000, "Calibrar Llantas", usuario1, TipoTransaccion.RETIRO, cuenta3, null, billeteraVirtual);
        Transaccion transaccion15 = new Transaccion(15, LocalDate.of(2025,5,24), 30000, "Lavada en el Guadual", usuario1, TipoTransaccion.RETIRO, cuenta3, null, billeteraVirtual);
        Transaccion transaccion16 = new Transaccion(16, LocalDate.of(2025,5,24), 40000, "Almuerzo en el Roble", usuario1, TipoTransaccion.RETIRO, cuenta1, null, billeteraVirtual);
        usuario1.agregarTransaccion(transaccion1);
        usuario1.agregarTransaccion(transaccion2);
        usuario1.agregarTransaccion(transaccion3);
        usuario1.agregarTransaccion(transaccion4);
        usuario1.agregarTransaccion(transaccion5);
        usuario1.agregarTransaccion(transaccion6);
        usuario1.agregarTransaccion(transaccion7);
        usuario1.agregarTransaccion(transaccion8);
        usuario1.agregarTransaccion(transaccion9);
        usuario1.agregarTransaccion(transaccion10);
        usuario1.agregarTransaccion(transaccion11);
        usuario1.agregarTransaccion(transaccion12);
        usuario1.agregarTransaccion(transaccion13);
        usuario1.agregarTransaccion(transaccion14);
        usuario1.agregarTransaccion(transaccion15);
        usuario1.agregarTransaccion(transaccion16);
        return billeteraVirtual;
    }
}
