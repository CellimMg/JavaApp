package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private static Stage stage;
    private static Scene firstScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Gestão de Time");

        Parent firstSceneFXML = FXMLLoader.load(getClass().getResource("../view/first_screen.fxml"));
        firstScene = new Scene(firstSceneFXML);


        primaryStage.setResizable(false);
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
