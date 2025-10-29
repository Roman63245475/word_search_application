module roman.file_manager_application {
    requires javafx.controls;
    requires javafx.fxml;


    opens roman.file_manager_application to javafx.fxml;
    exports roman.file_manager_application;
    exports roman.file_manager_application.gui;
    opens roman.file_manager_application.gui to javafx.fxml;
}