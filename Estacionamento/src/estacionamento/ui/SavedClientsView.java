package estacionamento.ui;

import estacionamento.controller.MainController;
import estacionamento.navigation.Navigator;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class SavedClientsView {
    private MainController mainController;
    private Navigator navigator;
    private Scene scene;
    private VBox vBox;
    private ListView savedClientsList = new ListView();

    public SavedClientsView(MainController mainController, Navigator navigator) {
        this.navigator = navigator;
        this.mainController = mainController;
        setup();
    }

    // Configures SavedClientsView
    public void setup() {
        vBox = new VBox(10);
        scene = new Scene(vBox);    // Saved clients scene.
    }

    // Returns SavedClientsView scene
    public Scene getScene() {
        return scene;
    }

}
