package com.example.harryathomefx;

import Controleur.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    protected AnchorPane windows;

    @FXML
    protected void onHelloButtonClick() {
        loadPage("PlayerCreation.fxml");
    }
    @FXML
    public void initialize(){
        System.out.println("Start the game");
    }
    protected void loadPage(String pageName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource( pageName ));
            Scene scene = new Scene(fxmlLoader.load());
            ((Stage) windows.getScene().getWindow()).setScene(scene);
        }
        catch (IOException e) {throw new RuntimeException(e);}

    }
}