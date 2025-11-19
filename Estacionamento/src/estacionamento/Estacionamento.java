/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package estacionamento;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.awt.Color;

import java.awt.*;


public class Estacionamento extends Application {
    private int width = 400;
    private int height = 500;
    @Override
    public void start(Stage primaryStage) {

        //Add clients button:
        Button addButton = new Button("Adicionar");
        addButton.setMinWidth(width-(width*0.1));
        addButton.setMaxWidth(width-(width*0.1));
        addButton.setMinHeight(height*0.05);
        addButton.setMaxHeight(height*0.05);
        addButton.setLayoutX(width/2 - addButton.getMinWidth()/2);
        addButton.setLayoutY(height * 0.02);
        addButton.setOnAction(event -> {
            //Go to add screen
        });

        //Clients list ListView:
        ListView list = new ListView();
        list.setMinWidth(width-(width*0.1));
        list.setMaxWidth(width-(width*0.1));
        list.setLayoutX(width/2 - list.getMinWidth()/2);
        list.setLayoutY(addButton.getLayoutY() + addButton.getMinHeight() + height * 0.01);

        list.getItems().add("item 1");
        list.getItems().add("item 2");
        list.getItems().add("item 3");
        list.getItems().add("item 4");


        Pane pane = new Pane();
        pane.getChildren().addAll(addButton, list);

        Scene scene = new Scene(pane, width, height);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
