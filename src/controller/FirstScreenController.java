package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.DAO.PartidaDAO;
import model.PartidaModel;

import javax.swing.*;
import java.io.IOException;


public class FirstScreenController {

    @FXML
    protected void initialize(){
        resetTable();

    }

    public void resetTable(){


        Image image2 = new Image("file:\\\\\\C:\\Users\\cello\\IdeaProjects\\JavaAppe\\src\\view\\Images\\LAGalaxy2016.png");
        imgHeader.setImage(image2);

        PartidaDAO partidaDAO = new PartidaDAO();
        PartidaModel partidaModel = partidaDAO.getLast();

        if(partidaModel.get_id() != null){

            Image image = new Image("file:\\\\\\C:\\Users\\cello\\IdeaProjects\\JavaAppe\\src\\view\\Images\\LAGalaxy2016.png");
            Image image3 = new Image("file:\\\\\\C:\\Users\\cello\\IdeaProjects\\JavaAppe\\src\\view\\Images\\unknown-png.png");

            imgGame21.setImage(image3);

            imgGame2.setImage(image);

            partidaModel = partidaDAO.getLast();

            if(Integer.parseInt(partidaModel.getGolsTime()) > Integer.parseInt(partidaModel.getGolsAdv())){
                lblRESULTADO.setTextFill(Color.web("#27AE60", 1));
                lblRESULTADO.setText("VITÓRIA!");
            }else if(Integer.parseInt(partidaModel.getGolsAdv()) > Integer.parseInt(partidaModel.getGolsTime())){
                lblRESULTADO.setTextFill(Color.web("#8B0000", 1));
                lblRESULTADO.setText("DERROTA!");
            }else if(Integer.parseInt(partidaModel.getGolsTime()) == Integer.parseInt(partidaModel.getGolsAdv())){
                lblRESULTADO.setText("EMPATE!");
            }

            lblLastGame.setText("Última partida");
            lblLastGame.setAlignment(Pos.CENTER);
            lblTime.setText("LA Galaxy");
            lblPlacar1.setText(partidaModel.getGolsTime());
            lblTime2.setText(partidaModel.getAdversario());
            lblPlacar2.setText(partidaModel.getGolsAdv());
            lblRESULTADO.setAlignment(Pos.CENTER);
        }else{

            Image image = new Image("file:\\\\\\C:\\Users\\cello\\IdeaProjects\\JavaAppe\\src\\view\\Images\\LAGalaxy2016.png");

            imgCenter.setImage(image);

            lblLastGame.setText("Vamos vencer a primeira partida!");
            lblLastGame.setAlignment(Pos.CENTER);

        }

    }

    @FXML
    private  Label lblTime;

    @FXML
    private  Label lblTime2;

    @FXML
    private  Label lblPlacar1;

    @FXML
    private  Label lblPlacar2;

    @FXML
    private Label lblRESULTADO;

    @FXML Label lblLastGame;

    @FXML
    private ImageView imgHeader;

    @FXML
    private ImageView imgGame2;

    @FXML ImageView imgGame21;

    @FXML
    private ImageView imgCenter;

    @FXML
    protected void apSceneAction(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        Scene addPartidaScene;

        Parent addPlayerSceneFXML = FXMLLoader.load(getClass().getResource("../view/addplayer_screen.fxml"));

        addPartidaScene = new Scene(addPlayerSceneFXML);

        stage.setScene(addPartidaScene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    protected void aptSceneAction(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        Scene addPlayerScene;

        Parent addPartidaSceneFXML = FXMLLoader.load(getClass().getResource("../view/addpartida_screen.fxml"));
        addPlayerScene = new Scene(addPartidaSceneFXML);

        stage.setScene(addPlayerScene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                resetTable();
            }
        });
        stage.show();
    }


}
