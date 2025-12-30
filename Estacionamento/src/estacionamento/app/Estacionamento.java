package estacionamento.app;

import estacionamento.controller.MainController;
import estacionamento.navigation.Navigator;
import estacionamento.repository.ClientRepository;
import estacionamento.service.ClientServices;
import javafx.application.Application;
import javafx.stage.Stage;

public class Estacionamento extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClientRepository clientRepository = new ClientRepository();
        ClientServices clientServices = new ClientServices(clientRepository);
        MainController mainController = new MainController(clientRepository, clientServices);
        Navigator navigator = new Navigator(primaryStage, mainController);
        navigator.showMainView();

        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(800);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
