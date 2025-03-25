module co.edu.uniquindio.billetera_virtual.billetera_virtual_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.billetera_virtual.billetera_virtual_fx to javafx.fxml;
    exports co.edu.uniquindio.billetera_virtual.billetera_virtual_fx;
}