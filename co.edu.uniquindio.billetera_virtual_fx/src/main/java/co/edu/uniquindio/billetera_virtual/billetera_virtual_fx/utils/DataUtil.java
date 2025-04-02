package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Administrador;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.BilleteraVirtual;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.Usuario;

public class DataUtil {

    public static BilleteraVirtual inicializarDatos() {
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual("TRST Wallet");
        Usuario usuario1 = new Usuario("Esteban","Valencia","esteban@gmail.com",
                "3105478974","101478456","Avenida siempre viva 123",
                "mija","mijita");
        Usuario usuario2 = new Usuario("Jorge","Ocampo","jorge@gmail.com",
                "3158876498","1069870463","Carrera 1 calle 2",
                "jojo","borojojo");
        Usuario usuario3 = new Usuario("Santiago","Vallejo",
                "santiago@gmail.com","3145874621","10947894561",
                "Calle San Diego", "GG","GGnext");
        billeteraVirtual.crearUsuario(usuario1);
        billeteraVirtual.crearUsuario(usuario2);
        billeteraVirtual.crearUsuario(usuario3);
        Administrador administrador1 = Administrador.builder()
                .nombre("Oscar")
                .apellidos("Orozco")
                .email("oscar@email.com")
                .telefono("3148746523")
                .idAdministrador("145678942")
                .build();
        billeteraVirtual.agregarAdministrador(administrador1);
        Administrador administrador2 = Administrador.builder()
                .nombre("Alejandro")
                .apellidos("Hurtado")
                .email("alejandro@email.com")
                .telefono("3257489674")
                .idAdministrador("1047815634")
                .build();
        billeteraVirtual.agregarAdministrador(administrador2);
        return billeteraVirtual;
    }
}
