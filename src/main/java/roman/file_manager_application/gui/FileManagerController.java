package roman.file_manager_application.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FileManagerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
