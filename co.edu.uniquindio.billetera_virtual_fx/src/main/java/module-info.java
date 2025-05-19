module co.edu.uniquindio.billetera_virtual.billetera_virtual_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires layout;
    requires kernel;


    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;


}