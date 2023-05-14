package com.example.harryathomefx;

import Characters.Pet;
import Characters.Wizard;
import Tools.Console;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

public class LevelsController extends BaseController{
    @FXML
    SplitMenuButton splitMenuButton;
    @FXML
    MenuItem cat, dog, rat;
    @FXML
    Label okCreateMsg;
    Pet choicePet;
    Wizard wizard;

    public void onCreatePlayerClick(){
        //wizard = new Wizard(1, name, wand, choicePet, house, SpellKnowns, potions, inventory, 100, 40, 30, true);
    }
    public void selectOwl(){
        choicePet=Pet.OWL;
        Console.log(choicePet.toString());
        splitMenuButton.setText(choicePet.toString());
    }
    public void selectCat(){
        choicePet=Pet.CAT;
        Console.log(choicePet.toString());
        splitMenuButton.setText(choicePet.toString());
    }
    public void selectRat(){
        choicePet=Pet.RAT;
        Console.log(choicePet.toString());
        splitMenuButton.setText(choicePet.toString());
    }
    public void onPlayButtonClick(){

    }
    public void onBackButtonClick(){

    }



}
