package com.example.harryathomefx;

import Attribute.Core;
import Attribute.House;
import Attribute.Wand;
import Characters.Pet;
import Characters.Wizard;
import Controleur.Game;
import Tools.Console;
import Tools.SortingHat;
import Tools.Timer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerCreationController extends BaseController {
    Game currentGame = new Game();
    @FXML
    SplitMenuButton splitMenuButton;
    @FXML
    MenuItem cat, owl, rat;
    @FXML
            Label playGo;
    Pet choicePet;

    @FXML
    private TextField namefield;
//     String nameChoice;
//
//    public void setNameChoice(String nameChoice) {
//        this.nameChoice = nameChoice;
//    }

    @FXML
    private Label errormsg;
    @FXML
    private Label wandWrite;
    @FXML
    private Button elderwand;
    @FXML
    private Button vinewand;

//    @FXML
//    private Button namebutton;
    @FXML
    private ImageView phoenix;
    @FXML
    private ImageView vine;
    @FXML
    private Label labelHouse;
    @FXML
    private Button drawButton;
    private Wand choicewand;
    private House attibuteHouse;

//    public String recoveryName() {
//        //Console.log(namefield.getText());
//        return namefield.getText();
//    }

//    public void onNameButtonClick() {
//        currentGame.setNameChoice(namefield.getText());
//        //setNameChoice(namefield.getText());
//        Console.log(currentGame.getNameChoice());
//
//    }

    public void onElderClick() {
        Wand wand = new Wand("The Elder Wand", Core.PHOENIX_FEATHER, 10);
        this.choicewand = wand;
        wandWrite.setText("Elder Wand");
//        Console.log(choicewand.getName());
//        Console.log("Fin de page 1 test" + currentGame.getNameChoice());
//        //loadPage("PlayerCreation2.fxml");
//        Console.log("Après loadPage test "+currentGame.getNameChoice());

    }
//        else {
//            errormsg.setText("trim merde");
//        }



    public void onVineClick() {
//        String inter = currentGame.getNameChoice();
//        String nameTrim = inter.trim();
//        if (currentGame.getNameChoice() != null && !nameTrim.isEmpty()) {

        Wand wand = new Wand("Vine Wand", Core.DRAGON_HEARTSTRING, 30);
        this.choicewand = wand;
        wandWrite.setText("Vine Wand");
        //Console.log(choicewand.getName());

            //loadPage("PlayerCreation2.fxml");
    }

    public void onCreatePlayerClick() {
        //Console.log("Avant initialisation test "+namefield.getText());
        currentGame.initialisePotions();
        currentGame.createListPotion(currentGame.getSkeleGro());
        currentGame.createListPotion(currentGame.getEssence());
        currentGame.initializeSpell();
        currentGame.createListSpells(currentGame.getWingLev());
        currentGame.createListSpells(currentGame.getAccio());
        Console.log("Avant condition test "+namefield.getText());
        if (choicePet != null && attibuteHouse != null) {
            //Console.log("début de fonction create wizard test "+currentGame.getNameChoice());
            currentGame.createNewWizard(1, namefield.getText(), choicewand, choicePet, attibuteHouse, currentGame.getSpellKnowns(), currentGame.getPotions(), 100, 40, 30, true, currentGame.getInventory());
            //Console.log("Fin de fonction create wizard test "+currentGame.getNameChoice());
            playGo.setText("Wizard created ! Check the console ! Goog Luck !");
        } else {
            playGo.setText("please select a pet and draw lot a house !");
        }

    }

    public void selectOwl() {
        choicePet = Pet.OWL;
        Console.log(choicePet.toString());
        splitMenuButton.setText(choicePet.toString());
    }

    public void selectCat() {
        choicePet = Pet.CAT;
        Console.log(choicePet.toString());
        splitMenuButton.setText(choicePet.toString());
    }

    public void selectRat() {
        choicePet = Pet.RAT;
        Console.log(choicePet.toString());
        splitMenuButton.setText(choicePet.toString());
    }

    public void onPlayButtonClick() {
        //playGo.setText("Wizard created ! Check the console ! Goog Luck !");
        //Console.log("Avant condition test "+namefield.getText());
        if (choicePet != null && attibuteHouse != null) {
            if (!namefield.getText().isEmpty()){
                currentGame.initialisePotions();
                currentGame.createListPotion(currentGame.getSkeleGro());
                currentGame.createListPotion(currentGame.getEssence());
                currentGame.initializeSpell();
                currentGame.createListSpells(currentGame.getWingLev());
                currentGame.createListSpells(currentGame.getAccio());
                //Console.log("début de fonction create wizard test "+currentGame.getNameChoice());
                currentGame.createNewWizard(1, namefield.getText(), choicewand, choicePet, attibuteHouse, currentGame.getSpellKnowns(), currentGame.getPotions(), 100, 40, 30, true, currentGame.getInventory());
                //Console.log("Fin de fonction create wizard test "+currentGame.getNameChoice());

                //okCreateMsg.setText("Wizard created ! Press [Play] and good luck ! Check the console !");
                if (currentGame.getWizard()!=null){
//                    Timer timer = new Timer();
//                    timer.getTime(1000);
                    currentGame.play();


                }else{
                    errormsg.setText("please create your wizard !");
                }
            }else{
                errormsg.setText("name is null");
            }

        } else {
            errormsg.setText("please select a pet and draw lot a house !");
        }





    }

//    public void onBackButtonClick() throws IOException {
//
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource( "PlayerCreation.fxml" ));
//            Scene scene = new Scene(fxmlLoader.load());
//            ((Stage) windows.getScene().getWindow()).setScene(scene);
//
//    }

    public void onDrawButtonClick() {
        //Console.log("avant tirage test "+currentGame.getNameChoice());
        SortingHat sortingHat = new SortingHat();
        attibuteHouse = sortingHat.attributeHouse(attibuteHouse);
        labelHouse.setText("Your house is : " + attibuteHouse.toString());
    }


}
