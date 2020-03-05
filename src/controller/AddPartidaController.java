package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.DAO.JogadorDAO;
import model.JogadorModel;

import java.util.ArrayList;
import java.util.List;

public class AddPartidaController {



    @FXML
    protected void initialize(){

        JogadorDAO jogadorDAO = new JogadorDAO();
        jogadorList = jogadorDAO.read();


        cbLocal.getItems().addAll(
          "C", "F"
        );

        System.out.println(jogadorList);

        cbAutorGol.getItems().addAll(
                jogadorList
        );
    }

    @FXML
    private TextField ifId;

    @FXML
    private TextField tfNome;

    @FXML
    private ComboBox<String> cbLocal;

    @FXML
    private TextField tfGolsP;

    @FXML
    private TextField tfGolsC;

    @FXML
    private TableView<?> tablePartida;

    @FXML
    private ComboBox<ObservableList<JogadorModel>> cbAutorGol;

    @FXML
    private TableView<?> tableGols;

    ObservableList<JogadorModel> jogadorList = FXCollections.observableArrayList();
}
