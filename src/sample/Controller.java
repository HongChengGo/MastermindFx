package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

public class Controller {
    public void pressButton(ActionEvent event){
        System.out.println("Good Job");
    }
    @FXML
    Circle bluebutton;

    @FXML
    Circle guessbutton1;

    public void initialize() {
        bluebutton.setOnMouseClicked(mouseEvent -> {
            //guessbutton1.setId("bluebutton");
            guessbutton1.setFill(Color.BROWN);

        });
    }

}
