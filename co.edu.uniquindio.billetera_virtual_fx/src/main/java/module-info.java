module co.edu.uniquindio.billetera_virtual.billetera_virtual_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;

}