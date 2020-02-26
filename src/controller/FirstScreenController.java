package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javax.swing.*;


public class FirstScreenController {



    @FXML
    protected void apSceneAction(ActionEvent e){
        Main.changeScene("addPlayer");
    }

    @FXML
    protected void lpSceneAction(ActionEvent e){
        Main.changeScene("listPlayer");
    }

    @FXML
    protected void aptSceneAction(ActionEvent e){
        Main.changeScene("addPartida");
    }

    @FXML
    protected void lptSceneAction(ActionEvent e){
        Main.changeScene("listPartida");
    }

}
