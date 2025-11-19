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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.awt.Color;

import java.awt.*;


public class Estacionamento extends Application {
    private int width = 400;                                         //Global window width.
    private int height = 500;                                       //Global window height.
    private Pane mainPane = new Pane();                            //Main screen pane.
    private Scene mainScene = new Scene(mainPane, width, height); //Main screen scene.
    private Pane addPane = new Pane();                           //Add screen pane.
    private Scene addScene = new Scene(addPane, width, height); //Add screen scene.
    private ListView list = new ListView();                    //Clients list ListView.
    @Override
    public void start(Stage primaryStage) {
        mainSceneConfig(primaryStage);  //Main scene configuration.
        addSceneConfig(primaryStage);   //Add scene configuration.

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    private void mainSceneConfig(Stage primaryStage) {
        //Clients adding button configuration:
        Button addButton = new Button("Adicionar");
        addButton.setMinWidth(width-(width*0.1));
        addButton.setMaxWidth(width-(width*0.1));
        addButton.setMinHeight(height*0.05);
        addButton.setMaxHeight(height*0.05);
        addButton.setLayoutX(width/2 - addButton.getMinWidth()/2);
        addButton.setLayoutY(height * 0.02);

        addButton.setOnAction(event -> {
            primaryStage.setScene(addScene);
        });

        clientListConfig(addButton.getLayoutY(), addButton.getMinHeight());

        mainPane.getChildren().addAll(addButton, list); //Adding children to mainPane.
    }

    public void clientListConfig(double addButtonLayoutY, double addButtonMinHeight) {
        //Main screen clients ListView configuration:
        list.setMinWidth(width-(width*0.1));
        list.setMaxWidth(width-(width*0.1));
        list.setLayoutX(width/2 - list.getMinWidth()/2);
        list.setLayoutY(addButtonLayoutY + addButtonMinHeight + height * 0.01);

        list.getItems().addAll("aiaiaia");

    }

    public void addSceneConfig(Stage primaryStage) {
        //Back button on client add screen:
        Button backButton = new Button("Back");
        backButton.setMinWidth(width-(width*0.1));
        backButton.setMaxWidth(width-(width*0.1));
        backButton.setMinHeight(height*0.05);
        backButton.setMaxHeight(height*0.05);
        backButton.setLayoutX(width/2 - backButton.getMinWidth()/2);
        backButton.setLayoutY(height * 0.02);

        backButton.setOnMouseClicked(e -> {
            primaryStage.setScene(mainScene);
        });

        addPane.getChildren().add(backButton); // Adding children to addPane.
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
