package com.example.harryathomefx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseController {
    @FXML
    protected AnchorPane windows;

    protected void loadPage(String pageName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource( pageName ));
            Scene scene = new Scene(fxmlLoader.load());
            ((Stage) windows.getScene().getWindow()).setScene(scene);
        }
        catch (IOException e) {throw new RuntimeException(e);}

    }
}
