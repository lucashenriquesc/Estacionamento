package estacionamento.ui;

import estacionamento.controller.MainController;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class SavedClientsView {
    private int width = 400;
    private int height = 500;

    private MainController mainController = new MainController();

    Scene scene;
    private VBox vBox = new VBox(10);

    ListView savedClientsList = new ListView();

    public SavedClientsView() {
        setup();
    }

    // Returns the SavedClientsView scene
    public Scene getScene() {
        return scene;
    }

    // Configures the SavedClientsView
    public void setup() {
        scene = new Scene(vBox, width, height);    // Saved clients scene.
    }
}
