package com.example.harryathomefx;

import Controleur.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class GameControlleur {

    @FXML
    private Label text; // identifiant défini dans Scene Builder

    private Game game;

    public void initialize(){
        game = new Game();
        //text.setText("Babla");
    }
    // méthode appelée pour ajouter du texte dans la console
    //public void addToConsole(String input) {
        //text.setText(input); // ajoute le texte et un retour à la ligne
    //}

}
