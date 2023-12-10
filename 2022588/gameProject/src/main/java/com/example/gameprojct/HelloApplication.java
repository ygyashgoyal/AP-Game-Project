package com.example.gameprojct;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hi.fxml"));
        Group root=new Group();
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Image icon =new Image("23.png");
        stage.getIcons().add(icon);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("press q to exit");
        stage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("q"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

