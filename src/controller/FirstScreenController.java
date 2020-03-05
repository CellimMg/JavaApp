package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class FirstScreenController {

    @FXML
    protected void apSceneAction(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        Scene addPartidaScene;


        Parent addPartidaSceneFXML = FXMLLoader.load(getClass().getResource("../view/addpartida_screen.fxml"));
        addPartidaScene = new Scene(addPartidaSceneFXML);

        stage.setScene(addPartidaScene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    protected void aptSceneAction(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        Scene addPlayerScene;

        Parent addPlayerSceneFXML = FXMLLoader.load(getClass().getResource("../view/addplayer_screen.fxml"));
        addPlayerScene = new Scene(addPlayerSceneFXML);

        stage.setScene(addPlayerScene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


}
