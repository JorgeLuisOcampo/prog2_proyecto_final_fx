package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.BilleteraVirtual;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public class DataUtil {

    public static BilleteraVirtual inicializarDatos() {
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual("TRST Wallet");
        Usuario usuario1 = new Usuario("Esteban","Valencia","esteban@gmail.com","3105478974","101478456","Avenida siempre viva 123", "mija","mijita");
        Usuario usuario2 = new Usuario("Jorge","Ocampo","jorge@gmail.com","3158876498","1069870463","Carrera 1 calle 2", "jojo","borojojo");
        Usuario usuario3 = new Usuario("Santiago","Vallejo","santiago@gmail.com","3145874621","10947894561","Calle San Diego", "GG","GGnext");

        billeteraVirtual.agregarUsuario(usuario1);
        billeteraVirtual.agregarUsuario(usuario2);
        billeteraVirtual.agregarUsuario(usuario3);

        return billeteraVirtual;
    }
}
