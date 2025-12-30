package estacionamento.ui;
import estacionamento.controller.MainController;
import estacionamento.model.Client;
import estacionamento.navigation.Navigator;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class MainView {
    final private MainController mainController;
    final private Navigator navigator;
    private Scene scene;
    final private VBox vBox = new VBox(10);
    final private HBox hBox = new HBox(10);
    final private Button addButton = new Button("Adicionar");
    final private Button savedClientsButton = new Button("Clientes salvos");
    final private TableView<Client> clientsList = new TableView<>();

    public MainView(MainController mainController, Navigator navigator) {
        this.navigator = navigator;
        this.mainController = mainController;
        setup();
    }
    public Scene getScene() {
        return scene;
    }

    // Configures MainView
    private void setup() {
        scene = new Scene(vBox);
        // VBox setup
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(15));
        VBox.setVgrow(clientsList, Priority.ALWAYS);
        vBox.getChildren().addAll(hBox, clientsList);
        // HBox setup
        HBox.setHgrow(addButton, Priority.ALWAYS);
        HBox.setHgrow(savedClientsButton, Priority.ALWAYS);
        hBox.setPrefHeight(50);
        hBox.setMaxHeight(50);
        // Main nodes setup
        buttonsSetup();
        clientsListSetup();
    }

    // Configures all buttons on mainView
    private void buttonsSetup() {
        // Add new clients button
        addButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setMaxHeight(Double.MAX_VALUE);
        addButton.setOnAction(e -> navigator.showAddClientsView());
        // Saved clients button
        savedClientsButton.setMaxWidth(Double.MAX_VALUE);
        savedClientsButton.setMaxHeight(Double.MAX_VALUE);
        savedClientsButton.setOnAction(e -> navigator.showSavedClientsView());

        hBox.getChildren().addAll(addButton, savedClientsButton);
    }

    // Configures clients list on mainview
    private void clientsListSetup() {
        // Client in
        clientsList.setItems(mainController.getClients());

        TableColumn<Client, Integer> idCol = new TableColumn<>("Id");
        TableColumn<Client, String> nameCol = new TableColumn<>("Nome");
        TableColumn<Client, String> phoneCol = new TableColumn<>("Telefone");
        TableColumn<Client, String> platesCol = new TableColumn<>("Placas");
        TableColumn<Client, Void> optionsCol = new TableColumn<>("Editar/Excluir");

        idCol.setCellValueFactory(
                new PropertyValueFactory<>("clientId")
        );
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<>("phonenumber")
        );
        platesCol.setCellValueFactory(cellData -> {
            List<String> plates = cellData.getValue().getPlates();
            String joined =  String.join(", ", plates);
            return new SimpleStringProperty(joined);
        });
        optionsCol.setCellFactory(col -> new TableCell<>() {
            private final Button editButton = new Button("Editar");
            private final Button deleteButton = new Button("Excluir");
            private final HBox hBox = new HBox(5, editButton, deleteButton);
            {
                editButton.setOnAction(e -> {
                    Client client = getTableView().getItems().get(getIndex());
                    navigator.showEditClientsView(client);
                });
                deleteButton.setOnAction(e -> {
                    Client client = getTableView().getItems().get(getIndex());
                    mainController.deleteClient(client);
                });

                hBox.setAlignment(Pos.CENTER);
            }

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else  {
                    setGraphic(hBox);
                }
            }
        });


        clientsList.getColumns().addAll(idCol, nameCol, phoneCol, platesCol, optionsCol);
    }
}
