module co.edu.uniquindio.billetera_virtual.billetera_virtual_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires layout;
    requires kernel;
    requires io;


    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario;
    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuario to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario;
    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.usuario to javafx.fxml;


}