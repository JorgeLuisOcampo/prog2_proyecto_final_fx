module co.edu.uniquindio.billetera_virtual.billetera_virtual_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller;

    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller;
    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.principalView;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.principalView;
    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.usuarioView;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.administradorView;
    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.viewcontroller.administradorView;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.administradorController;
    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.controller.administradorController;

}