package estacionamento.ui;

import estacionamento.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;


public class Estacionamento extends Application {
    private MainController mainController = new MainController();

    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView(primaryStage, mainController);

        primaryStage.setTitle("Estacionamento");
        primaryStage.setScene(mainView.getScene());
        primaryStage.show();
        primaryStage.setResizable(true);
    }

    public static void main(String[] args) { launch(args); }
}
