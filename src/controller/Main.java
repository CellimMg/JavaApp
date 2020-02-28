package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.JogadorModel;

public class Main extends Application {

    private static Stage stage;
    private static Scene firstScene, addPlayerScene, listPlayerScene, addPartidaScene, listPartidaScene;



    @Override
    public void start(Stage primaryStage) throws Exception{

        JogadorModel jogador = new JogadorModel("Joao", "15", "Bh");
        System.out.println(jogador);
        System.exit(0);

        stage = primaryStage;
        primaryStage.setTitle("Gestão de Time");

        Parent firstSceneFXML = FXMLLoader.load(getClass().getResource("../view/first_screen.fxml"));
        firstScene = new Scene(firstSceneFXML);

        Parent addPlayerSceneFXML = FXMLLoader.load(getClass().getResource("../view/addplayer_screen.fxml"));
        addPlayerScene = new Scene(addPlayerSceneFXML);

        Parent listPlayerSceneFXML = FXMLLoader.load(getClass().getResource("../view/listplayer_screen.fxml"));
        listPlayerScene = new Scene(listPlayerSceneFXML);

        Parent addPartidaSceneFXML = FXMLLoader.load(getClass().getResource("../view/addpartida_screen.fxml"));
        addPartidaScene = new Scene(addPartidaSceneFXML);

        Parent listPartidaSceneFXML = FXMLLoader.load(getClass().getResource("../view/listpartida_screen.fxml"));
        listPartidaScene = new Scene(listPartidaSceneFXML);


        primaryStage.setResizable(false);
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }


    public static void changeScene(String src){
        switch (src){
            case "main":
                stage.setScene(firstScene);
                break;
            case "addPlayer":
                stage.setScene(addPlayerScene);
                break;
            case "listPlayer":
                stage.setScene(listPlayerScene);
                break;
            case "addPartida":
                stage.setScene(addPartidaScene);
                break;
            case "listPartida":
                stage.setScene(listPartidaScene);
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
