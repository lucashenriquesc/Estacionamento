package estacionamento.ui;

import estacionamento.controller.MainController;
import estacionamento.model.Client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddClientsView {
    Region region = new Region();

    int width = 400;
    int height = 500;

    MainController mainController;
    ListView clientsList;

    private Scene scene;
    private VBox vBox = new  VBox(10);

    Button backButton = new Button("Voltar");
    Button saveButton = new Button("Salvar");
    Label clientNameLabel = new Label("Nome do cliente: ");
    TextField clientNameTextField = new TextField();
    Label vehiclePlateLabel = new Label("Placa");
    TextField vehiclePlateTextField = new TextField();
    Label clientPhoneLabel = new Label("Telefone: ");
    TextField clientPhoneTextField = new TextField();

    public AddClientsView(Stage primaryStage, MainController mainController, MainView mainView) {
        this.mainController = mainController;
        setup(primaryStage, mainView);
    }

    // Return the AddClientsView scene
    public Scene getScene() {
        return scene;
    }

    // Configures AddClientsView
    private void setup(Stage primaryStage, MainView mainView) {
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(15));
        vBox.setVgrow(region, Priority.ALWAYS);

        scene = new Scene(vBox, width, height);

        buttonsSetup(primaryStage, mainView);
        clientInfoSetup();

        vBox.getChildren().addAll(backButton, clientNameLabel, clientNameTextField, vehiclePlateLabel, vehiclePlateTextField,
                clientPhoneLabel, clientPhoneTextField, region, saveButton);
    }

    //Configures add button for AddClientsView
    private void buttonsSetup(Stage primaryStage, MainView mainView) {
        // Back button
        backButton.setPrefWidth(width);
        backButton.setMinHeight(height*0.05);
        backButton.setMaxHeight(height*0.05);
        vBox.setMargin(backButton, new Insets(0, 0, 20, 0));

        backButton.setOnMouseClicked(e -> {
            primaryStage.setScene(mainView.getScene());
        });

        // Save new client button
        saveButton.setPrefWidth(width);
        saveButton.setMinHeight(height*0.05);
        saveButton.setMaxHeight(height*0.05);

        saveButton.setOnMouseClicked(e -> {
            Client client = new Client(
                    clientNameTextField.getText(),
                    vehiclePlateTextField.getText(),
                    clientPhoneTextField.getText());

            mainController.addClient(client);
        });
    }

    // Configures the client information Labels and TextFields for AddClientsView
    private void clientInfoSetup() {
        // Client name Label and TextField
        clientNameLabel.setPrefWidth(width);
        clientNameLabel.setAlignment(Pos.CENTER);
        clientNameTextField.setPrefWidth(width);

        // Client vehicle plate Label and TextField
        vehiclePlateLabel.setPrefWidth(width);
        vehiclePlateLabel.setAlignment(Pos.CENTER);
        vehiclePlateTextField.setPrefWidth(width);

        // Client phone number Label and TextField
        clientPhoneLabel.setPrefWidth(width);
        clientPhoneLabel.setAlignment(Pos.CENTER);
        clientPhoneTextField.setPrefWidth(width);
    }

}
