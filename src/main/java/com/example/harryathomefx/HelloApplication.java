package com.example.harryathomefx;

import Controleur.Game;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static jdk.internal.org.jline.terminal.Terminal.MouseTracking.Button;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 1200, 640);
        root.getChildren().add(backGround(scene));
        root.getChildren().add(startButton());
        stage.setTitle("Harry At Home");
        stage.setScene(scene);
        stage.show();
    }

    public ImageView backGround(Scene scene){
        Image backgroundImage = new Image("D:/HarryAtHomeFX/src/main/java/com/example/harryathomefx/HarryCover.png");
        if (backgroundImage.isError()) {
            System.out.println("Erreur lors du chargement de l'image !");
        } else {
            System.out.println("L'image a été chargée avec succès.");
        }
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setX(0);
        backgroundView.setY(0);
        backgroundView.setPreserveRatio(true);
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.BLACK);
        ChangeListener<Number> listener = (observable, oldValue, newValue) -> {
            double width = scene.getWidth();
            double height = scene.getHeight();

            double imageWidth = backgroundView.getImage().getWidth();
            double imageHeight = backgroundView.getImage().getHeight();

            double scaleFactor = Math.min(width / imageWidth, height / imageHeight);

            backgroundView.setFitWidth(imageWidth * scaleFactor);
            backgroundView.setFitHeight(imageHeight * scaleFactor);
        };
        scene.widthProperty().addListener(listener);
        scene.heightProperty().addListener(listener);

        backgroundView.setFitWidth(1200);
        backgroundView.setFitHeight(640);
//        float width = 1200;
//        float height = 640;
        return backgroundView;
    }

    public static void main(String[] args) {
        launch();
    }
    public Button startButton(){
        Button startButton = new Button("Start the party");
        startButton.setOnAction(actionEvent -> {
            Game game = new Game();
            game.play();
        });
        return startButton;
    }
}