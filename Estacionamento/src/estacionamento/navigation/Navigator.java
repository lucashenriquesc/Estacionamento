package estacionamento.navigation;

import estacionamento.controller.MainController;
import estacionamento.model.Client;
import estacionamento.ui.AddClientsView;
import estacionamento.ui.MainView;
import estacionamento.ui.SavedClientsView;
import javafx.stage.Stage;

public class Navigator {
    private Stage primaryStage;
    private MainController mainController;
    public Navigator(Stage primaryStage, MainController mainController) {
        this.primaryStage = primaryStage;
        this.mainController = mainController;
    }
    public void showMainView() {
        MainView mainView = new MainView(mainController, this);
        primaryStage.setTitle("Estacionamento");
        primaryStage.setScene(mainView.getScene());
        setStageRes();
    }
    public void showAddClientsView() {
        AddClientsView addClientsView = new AddClientsView(mainController, this);
        primaryStage.setTitle("Adicionar novo cliente");
        primaryStage.setScene(addClientsView.getScene());
        setStageRes();
    }
    public void showSavedClientsView() {
        SavedClientsView savedClientsView = new SavedClientsView(mainController, this);
        primaryStage.setTitle("Clientes salvos");
        primaryStage.setScene(savedClientsView.getScene());
        setStageRes();
    }
    public void showEditClientsView(Client client) {

    }

    // Sets stage resolution after scene change
    private void setStageRes() {
        primaryStage.setWidth(primaryStage.getMinWidth());
        primaryStage.setHeight(primaryStage.getMinHeight());
    }

}
