package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private static Stage stage;
    private static Scene firstScene, addPlayerScene,  addPartidaScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        String teste = "teste";
        System.out.println(teste.matches("/^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$/"));

        stage = primaryStage;
        primaryStage.setTitle("Gestão de Time");

        Parent firstSceneFXML = FXMLLoader.load(getClass().getResource("../view/first_screen.fxml"));
        firstScene = new Scene(firstSceneFXML);

        Parent addPlayerSceneFXML = FXMLLoader.load(getClass().getResource("../view/addplayer_screen.fxml"));
        addPlayerScene = new Scene(addPlayerSceneFXML);

        Parent addPartidaSceneFXML = FXMLLoader.load(getClass().getResource("../view/addpartida_screen.fxml"));
        addPartidaScene = new Scene(addPartidaSceneFXML);



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
            case "addPartida":
                stage.setScene(addPartidaScene);
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
