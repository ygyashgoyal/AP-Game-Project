package com.example.gameprojct;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class HelloController {
    @FXML
    private Rectangle hero;

    @FXML
    private Rectangle platform;

    @FXML
    private Line stick;

    private boolean isStickExtended = false;

    @FXML
    private void initialize() {
        // Set up the game
        resetGame();
    }


    public void move(ActionEvent e){
        System.out.println("Move");
    }




    @FXML
    public void play(){

    }

    @FXML
    private void handleJumpAction() {
        if (!isStickExtended) {
            extendStick();
        } else {
            checkStickLength();
        }
    }

    private void extendStick() {
        // Extend the stick animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), new KeyValue(stick.endYProperty(), -100))
        );
        timeline.setOnFinished(event -> {
            isStickExtended = true;
            hero.toFront(); // Bring hero to the front after extending the stick
        });
        timeline.play();
    }

    private void checkStickLength() {
        double stickLength = stick.getEndY() - stick.getStartY();
        double platformWidth = platform.getWidth();

        // Check if stick length is enough to reach the platform
        if (stickLength >= platformWidth) {
            showMessage("Success! Stick length: " + stickLength);
            resetGame();
        } else {
            showMessage("Failed! Stick length: " + stickLength);
            resetGame();
        }
    }

    private void resetGame() {
        isStickExtended = false;
        stick.setEndY(0);
        hero.setLayoutX(50);
        hero.setLayoutY(200);
        platform.setLayoutX(200);
        platform.setLayoutY(220);
        hero.toFront(); // Ensure hero is in front of the stick
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Stick Hero Game");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



