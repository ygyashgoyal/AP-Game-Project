module com.example.gameprojct {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gameprojct to javafx.fxml;
    exports com.example.gameprojct;
}