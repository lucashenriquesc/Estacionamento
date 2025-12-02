package estacionamento.ui;
import estacionamento.controller.MainController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
    private int width = 400;
    private int height = 500;

    MainController mainController;

    private Scene scene;
    private VBox vBox = new VBox(10);
    private HBox hBox = new HBox(10);

    private Button addButton = new Button("Adicionar");
    private Button savedClientsButton = new Button("Clientes salvos");
    private TableView clientsList = new TableView();

    public MainView(Stage primaryStage, MainController mainController) {
        this.mainController = mainController;
        setup(primaryStage);
    }

    public Scene getScene() {
        return scene;
    }

    // Configures mainView
    private void setup(Stage primaryStage) {
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(15));

        scene = new Scene(vBox, width, height);

        buttonsSetup(primaryStage);
        clientsListSetup();

        hBox.getChildren().addAll(addButton, savedClientsButton);
        vBox.getChildren().addAll(hBox, clientsList);
    }

    // Configures all buttons on mainView
    private void buttonsSetup(Stage primaryStage) {
        // Add new clients button
        addButton.setPrefWidth(width);
        addButton.setMinHeight(height*0.05);
        addButton.setMaxHeight(height*0.05);

        addButton.setOnAction(e -> {
            AddClientsView addClientsView = new AddClientsView(primaryStage, mainController, this);
            primaryStage.setScene(addClientsView.getScene());
        });

        // Saved clients button
        savedClientsButton.setPrefWidth(width);
        savedClientsButton.setMinHeight(height*0.05);
        savedClientsButton.setMaxHeight(height*0.05);

        savedClientsButton.setOnAction(event -> {
            SavedClientsView savedClientsView = new SavedClientsView();
            primaryStage.setScene(savedClientsView.getScene());
        });
    }

    // Configures clients list on mainview
    private void clientsListSetup() {
        clientsList.setPrefWidth(width);
        clientsList.setPrefHeight(height);

        clientsList.getItems().add("aiaiaia");  //Test text, delete later.


    }
}
