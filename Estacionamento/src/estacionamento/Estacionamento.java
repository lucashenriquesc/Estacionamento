package estacionamento;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Estacionamento extends Application {
    // Window resolution:
    private int width = 400;
    private int height = 500;

    // VBox and scene
    private VBox mainVBox = new VBox(10);                                // Main scene vbox.
    private Scene mainScene = new Scene(mainVBox, width, height);          // Main scene.
    private VBox addVBox = new VBox(10);                               // Add scene vbox.
    private Scene addScene = new Scene(addVBox, width, height);          // Add scene.

    // mainVBox nodes
    private ListView clientsList = new ListView();                    // Clients list ListView.
    Button addButton = new Button("Adicionar");                   // Add new clients button on mainScene.

    // addVBox nodes
    Button backButton = new Button("Back");                     // Back button to mainScene.
    Button saveButton = new Button("Salvar");                  // Save new client button.
    Label clientNameLabel = new Label("Nome do cliente: ");   // Client name label on add scene.
    TextField clientNameTextField = new TextField();            // Client name textfield on add scene.
    Label vehiclePlateLabel = new Label("Placa");           // Client vehicle plate label on add scene.
    TextField vehiclePlateTextField = new TextField();        // Client vehicle plate textfield on add scene.
    Label clientPhoneLabel = new Label("Telefone: ");     // Client phone number label on add scene.
    TextField clientPhoneTextField = new TextField();       // Client phone number textfield on add scene.

    @Override
    public void start(Stage primaryStage) {
        // Application VBox setup:
        mainVBoxSetup(primaryStage);
        addVBoxSetup(primaryStage);

        // Stage setup:
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.setResizable(true);
    }

    // Setup for the mainVBox and its nodes
    private void mainVBoxSetup(Stage primaryStage) {
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setPadding(new Insets(15));

        // mainVBox nodes adding and setup:
        addButtonSetup(primaryStage);
        clientsListSetup();
    }

    // Configuration for addButton for adding a new client information
    private void addButtonSetup(Stage primaryStage) {
        addButton.setPrefWidth(width);
        addButton.setMinHeight(height*0.05);
        addButton.setMaxHeight(height*0.05);

        addButton.setOnAction(event -> {
            primaryStage.setScene(addScene);
        });

        mainVBox.getChildren().add(addButton);
    }

    // Configuration for the clients ListView
    private void clientsListSetup() {
        clientsList.setPrefWidth(width);
        clientsList.setPrefHeight(height);

        clientsList.getItems().add("aiaiaia");  //Test text, delete later.

        mainVBox.getChildren().add(clientsList);
    }

    // Setup for the addVBox and its nodes
    private void addVBoxSetup(Stage primaryStage) {
        addVBox.setAlignment(Pos.TOP_CENTER);
        addVBox.setPadding(new Insets(15));

        // addVBox nodes adding and setup:
        backButtonSetup(primaryStage);
        clientNameSetup();
        vehiclePlateSetup();
        clientPhoneSetup();
        saveButtonSetup(primaryStage);
    }

    // Configures the button to return to the mainScene
    private void backButtonSetup(Stage primaryStage) {
        backButton.setPrefWidth(width);
        backButton.setMinHeight(height*0.05);
        backButton.setMaxHeight(height*0.05);

        backButton.setOnMouseClicked(e -> {
            primaryStage.setScene(mainScene);
        });

        addVBox.getChildren().add(backButton);
    }

    // Configures client name Label and TextField
    private void clientNameSetup() {
        // Client name Label configuration
        clientNameLabel.setPrefWidth(width);
        clientNameLabel.setAlignment(Pos.CENTER);

        // Client name TextField configuration
        clientNameTextField.setPrefWidth(width);

        addVBox.getChildren().addAll(clientNameLabel, clientNameTextField);
    }

    // Configures vehicle plate Label and TextField
    private void vehiclePlateSetup() {
        // Vehicle plate label configuration
        vehiclePlateLabel.setPrefWidth(width);
        vehiclePlateLabel.setAlignment(Pos.CENTER);

        // Vehicle plate TextField configuration
        vehiclePlateTextField.setPrefWidth(width);

        addVBox.getChildren().addAll(vehiclePlateLabel, vehiclePlateTextField);
    }
    // Configures client phone number Label and TextFiel:
    private void clientPhoneSetup() {
        // Client phone number Label configuration
        clientPhoneLabel.setPrefWidth(width);
        clientPhoneLabel.setAlignment(Pos.CENTER);

        // Client phone number TextField configuration
        clientPhoneTextField.setPrefWidth(width);

        addVBox.getChildren().addAll(clientPhoneLabel, clientPhoneTextField);
    }

    // Configures saveButton for saving a new client
    private void saveButtonSetup(Stage primaryStage) {
        saveButton.setPrefWidth(width);
        saveButton.setMinHeight(height*0.05);
        saveButton.setMaxHeight(height*0.05);

        saveButton.setOnMouseClicked(e -> {
            // Method to verify user input here
        });

        addVBox.getChildren().add(saveButton);
    }
    private void oi () {
        
    }
    public static void main(String[] args) { launch(args); }

}
