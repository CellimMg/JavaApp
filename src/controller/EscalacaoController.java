package controller;

import controller.Exceptions.NotStringException;
import controller.Exceptions.NullException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.EscalacaoDAO;
import model.DAO.EscalacaoEscalacaoDAO;
import model.DAO.JogadorDAO;
import model.DAO.PartidaDAO;
import model.EscalacaoEscalacaoModel;
import model.EscalacaoModel;
import model.JogadorModel;
import model.PartidaModel;

import java.sql.SQLException;

public class EscalacaoController {

    @FXML
    protected void initialize() throws NotStringException, SQLException, NullException {

        EscalacaoDAO escalacaoDAO = new EscalacaoDAO();
        if(escalacaoDAO.readEscalacaoId(AddPartidaController.idPartida) == null){
            escalacaoDAO.create(AddPartidaController.idPartida);
        }

        JogadorDAO jogadorDAO = new JogadorDAO();
        jogadores = jogadorDAO.read();

        for (int x = 0; x < jogadorDAO.read().toArray().length; x++) {
            nomeJogador.add(jogadores.get(x).getNome());
        }

        cbJogadores.setItems(nomeJogador);

        loadTablePartida();
    }

    public void loadTablePartida() throws NullException, NotStringException, SQLException {

        JogadorDAO jogadorDAO = new JogadorDAO();
        EscalacaoDAO escalacaoDAO = new EscalacaoDAO();
        EscalacaoEscalacaoDAO escalacaoEscalacaoDAO = new EscalacaoEscalacaoDAO();

        EscalacaoModel escalacaoModel = new EscalacaoModel();
        EscalacaoEscalacaoModel escalacaoEscalacaoModel = new EscalacaoEscalacaoModel();

        escalacaoEscalacaoModels = escalacaoEscalacaoDAO.read(AddPartidaController.idPartida);

        for (EscalacaoEscalacaoModel em: escalacaoEscalacaoModels) {
            jogadoresTabela.add(jogadorDAO.read(em.getIdJogador()));
        }

        colPos.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tableEscalacao.setItems(jogadoresTabela);

    }

    @FXML
    public void setPlayer(ActionEvent e){

        EscalacaoDAO escalacaoDAO = new EscalacaoDAO();
        EscalacaoEscalacaoDAO escalacaoEscalacaoDAO = new EscalacaoEscalacaoDAO();

        System.out.println(jogadores.get(cbJogadores.getSelectionModel().getSelectedIndex()));
        System.out.println(nomeJogador);
        System.out.println(cbJogadores.getSelectionModel().getSelectedIndex());


        jogadoresTabela.add(jogadores.get(cbJogadores.getSelectionModel().getSelectedIndex()));
        nomeJogador.remove(cbJogadores.getSelectionModel().getSelectedIndex());


        System.out.println(jogadores.get(0).get_id());



        escalacaoEscalacaoDAO.create(jogadores.get(1).get_id(),
                AddPartidaController.idPartida, escalacaoDAO.readEscalacaoId(AddPartidaController.idPartida));



        cbJogadores.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void removePlayer(ActionEvent e){

    }

    public void function(PartidaModel p){
        this.p = p.get_id();
    }

    public Integer p;

    @FXML
    private TableView<JogadorModel> tableEscalacao;

    @FXML
    private TableColumn<JogadorModel, String> colPos;

    @FXML
    private TableColumn<JogadorModel, String> colNome;

    @FXML
    private ComboBox<String> cbJogadores;

    ObservableList<JogadorModel> jogadores = FXCollections.observableArrayList();
    ObservableList<String> nomeJogador = FXCollections.observableArrayList();
    ObservableList<JogadorModel> jogadoresTabela = FXCollections.observableArrayList();
    ObservableList<EscalacaoEscalacaoModel> escalacaoEscalacaoModels = FXCollections.observableArrayList();


}
