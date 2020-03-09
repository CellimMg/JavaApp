package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class FirstScreenController {



    @FXML
    protected void initialize(){


    }




    @FXML
    private Label lblTime2;

    @FXML
    private Label lblPlacar1;

    @FXML
    private Label lblPlacar2;

    @FXML
    private ImageView imgHeader = new ImageView();

    @FXML
    private ImageView imgGame;

    @FXML
    private ImageView imgGame2;


    @FXML
    private BorderPane bpane;

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
