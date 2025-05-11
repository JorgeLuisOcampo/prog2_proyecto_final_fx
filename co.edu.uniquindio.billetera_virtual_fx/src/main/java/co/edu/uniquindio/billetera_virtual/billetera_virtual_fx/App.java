package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;


import java.io.IOException;

public class App extends Application {
    Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    double anchoPantalla = screenBounds.getWidth();
    double altoPantalla = screenBounds.getHeight();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/billetera_virtual/billetera_virtual_fx/BilleteraApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Billetera Virtual");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}