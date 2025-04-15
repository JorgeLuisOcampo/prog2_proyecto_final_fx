package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.BilleteraVirtual;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public class DataUtil {

    public static BilleteraVirtual inicializarDatos() {
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual("TRST Wallet");
        Usuario usuario1 = new Usuario("Evb2511", "estebanvb12321@gmail.com", "codsito", "1005087768",
                "esteban", "valencia bejarano", "3009824495", "B/ciudad Dorada", billeteraVirtual);
        Usuario usuario2 = new Usuario("Jorge123","jorge@gmail.com","gato",
                "1069870463","jorge","ocampo",
                "3158876498","Carrera 1 calle 2", billeteraVirtual);
        Usuario usuario3 = new Usuario("12345","antiago@gmail.com",
                "naruto","10947894561","Santiago",
                "Vallejo", "3145874621","Calle San Diego", billeteraVirtual);
        billeteraVirtual.agregarUsuario(usuario1);
        billeteraVirtual.agregarUsuario(usuario2);
        billeteraVirtual.agregarUsuario(usuario3);
        Administrador administrador1 = new Administrador(
                                        "25112001",
                                        "estebanvb12321@gmail.com", "123456789");
        billeteraVirtual.agregarAdministrador(administrador1);
        Administrador administrador2 = new Administrador(
                                        "123456789",
                                        "jorgeO25@gmail.com", "0147");
        billeteraVirtual.agregarAdministrador(administrador2);
        return billeteraVirtual;
    }
}
