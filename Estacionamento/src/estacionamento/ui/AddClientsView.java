package estacionamento.ui;

import estacionamento.controller.MainController;
import estacionamento.model.Client;
import estacionamento.navigation.Navigator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddClientsView {
    private Region region = new Region();
    private MainController mainController;
    private Navigator navigator;
    private Scene scene;
    private VBox vBox = new  VBox(10);
    private VBox platesFieldsVBox = new VBox(5);
    private ScrollPane scrollPane = new ScrollPane(vBox);

    private Map<Label, TextField> platesFieldsList = new HashMap<>();
    private Button backButton = new Button("Voltar");
    private Button saveButton = new Button("Salvar");
    private Button addPlateButton = new Button("Adicionar placa");
    private Label clientNameLabel = new Label("Nome do cliente: ");
    private Label vehiclePlateLabel = new  Label("Placa 1:");
    private Label clientPhoneLabel = new Label("Telefone: ");
    private TextField clientNameTextField = new TextField();
    private TextField vehiclePlateTextField = new TextField();
    private TextField clientPhoneTextField = new TextField();

    public AddClientsView(MainController mainController, Navigator navigator) {
        this.mainController = mainController;
        this.navigator = navigator;
        setup();
    }

    // Return the AddClientsView scene
    public Scene getScene() {
        return scene;
    }

    // Configures AddClientsView
    private void setup() {
        // vBox configuration
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(15));
        vBox.setVgrow(region, Priority.ALWAYS);

        //scrollPane.setFitToWidth(true);
        //scrollPane.setFitToHeight(true);
        //vBox.minHeightProperty().bind(scrollPane.heightProperty());

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // scene instantiation
        scene = new Scene(scrollPane);

        // Nodes setup
        platesFieldsVBox.setAlignment(Pos.CENTER);
        buttonsSetup();
        clientInfoSetup();
        vBox.getChildren().addAll(
                backButton, clientNameLabel, clientNameTextField, vehiclePlateLabel, platesFieldsVBox,
                clientPhoneLabel, clientPhoneTextField, addPlateButton, region, saveButton
        );
    }

    //Configures add button for AddClientsView
    private void buttonsSetup() {
        // Back to MainView button
        vBox.setMargin(backButton, new Insets(0, 0, 20, 0));
        backButton.setOnAction(e -> navigator.showMainView());
        // Button for adding new client
        saveButton.setOnAction(e -> {
            List<String> tempPlatesList = new ArrayList<String>();
            for (Map.Entry<Label, TextField> field : platesFieldsList.entrySet()) {
                tempPlatesList.add(field.getValue().getText());
            }
            Client client = new Client(clientNameTextField.getText(), tempPlatesList, clientPhoneTextField.getText());
            mainController.addClient(client);
        });
        // Button for adding plate field
        vBox.setMargin(addPlateButton, new Insets(20, 0, 20, 0));
        addPlateButton.setOnAction(e -> {
            Label newPlateLabel = new Label("Placa " + (platesFieldsList.size() + 1) + ":");
            // Setup for the additional plate labels and fields
            TextField newPlateField = new TextField();
            newPlateLabel.setAlignment(Pos.CENTER);
            newPlateField.setAlignment(Pos.CENTER);
            platesFieldsVBox.getChildren().addAll(newPlateLabel, newPlateField);
            platesFieldsList.put(newPlateLabel, newPlateField);
        });
    }

    // Configures the client information Labels and TextFields for AddClientsView
    private void clientInfoSetup() {
        // Client name Label and TextField
        clientNameLabel.setAlignment(Pos.CENTER);
        clientNameTextField.setAlignment(Pos.CENTER);
        // Client vehicle plate Label and TextField
        vehiclePlateLabel.setAlignment(Pos.CENTER);
        vehiclePlateTextField.setAlignment(Pos.CENTER);
        platesFieldsVBox.getChildren().add(vehiclePlateTextField);
        platesFieldsList.put(vehiclePlateLabel, vehiclePlateTextField);
        // Client phone number Label and TextField
        clientPhoneLabel.setAlignment(Pos.CENTER);
        clientPhoneTextField.setAlignment(Pos.CENTER);
    }
}
