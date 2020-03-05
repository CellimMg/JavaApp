package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

        for(int x = 0; x < jogadorDAO.read().toArray().length; x++){
            nomes.add(jogadorDAO.read().get(x).getNome());
            System.out.println(nomes);
        }

        cbLocal.getItems().addAll(
          "C", "F"
        );

        cbAutorGol.setItems(nomes);
    }




    @FXML
    protected void btnLoad(ActionEvent e){
        JogadorDAO jogadorDAO = new JogadorDAO();
        System.out.println(jogadorDAO.read());
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
    private ComboBox<String> cbAutorGol;

    @FXML
    private TableView<?> tableGols;

    ObservableList<String> nomes = FXCollections.observableArrayList();

}
