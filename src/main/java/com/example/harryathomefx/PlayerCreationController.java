package com.example.harryathomefx;

import Attribute.Core;
import Attribute.Wand;
import Tools.Console;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerCreationController extends BaseController{
    @FXML
    private TextField namefield;
    private String nameChoice;

    public void setNameChoice(String nameChoice) {
        this.nameChoice = nameChoice;
    }
    @FXML
    private Label errormsg;
    @FXML
    private Button elderwand;
    @FXML
    private Button vinewand;

    @FXML
    private Button namebutton;
    @FXML
    private ImageView phoenix;
    @FXML
    private ImageView vine;
    private Wand choicewand;

    public String recoveryName(){
        //Console.log(namefield.getText());
        return namefield.getText();
    }
    public void onNameButtonClick(){
        setNameChoice(recoveryName());
        Console.log(nameChoice);
    }
    public void onElderClick(){
        if (nameChoice != null){
            Wand wand = new  Wand("The Elder Wand", Core.PHOENIX_FEATHER, 10);
            this.choicewand=wand;
            Console.log(choicewand.getName());
            loadPage("Levels.fxml");
        }else {
            errormsg.setText("Please enter Wizard's name !");
        }
    }

    public void onVineClick(){
        if (nameChoice != null){
            Wand wand = new Wand("Vine Wand", Core.DRAGON_HEARTSTRING, 30);
            this.choicewand=wand;
            Console.log(choicewand.getName());
            loadPage("Levels.fxml");
        }else {
            errormsg.setText("Please enter Wizard's name !");
        }
    }


}
