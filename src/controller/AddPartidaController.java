package controller;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NotStringException;
import controller.Exceptions.NullException;
import controller.Exceptions.ResultadoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.GolJogadorDAO;
import model.DAO.JogadorDAO;
import model.DAO.PartidaDAO;
import model.GolJogadorModel;
import model.GolJogadorTableModel;
import model.JogadorModel;
import model.PartidaModel;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class AddPartidaController {

    @FXML
    protected void initialize() {

        loadTablePartida();
        PartidaDAO partidaDAO = new PartidaDAO();
        partidasList = partidaDAO.read();
        JogadorDAO jogadorDAO = new JogadorDAO();
        jogadores = jogadorDAO.read();


        //FALTA PESQUISAR POR ID DO JOGADOR PARA LISTAR E LISTAR BASEADO NO ID DA PARTIDA


        for (int x = 0; x < jogadorDAO.read().toArray().length; x++) {
            nomes.add(jogadores.get(x).getNome());
            System.out.println(nomes);
        }

        cbLocal.getItems().addAll(
                "C", "F"
        );

        cbResultado.getItems().addAll(
                "V", "E", "D"
        );

        cbAutorGol.setOnAction(e -> {
            tfidGol.setText(jogadores.get(cbAutorGol.getSelectionModel().getSelectedIndex()).get_id().toString());
        });

        cbResultado.setOnAction(e -> {
            if(cbResultado.getSelectionModel().getSelectedItem() != null){
                if(tfGolsC.getText().isEmpty() || tfGolsP.getText().isEmpty()){
                    try {
                        throw new NullException("s");
                    } catch (NullException ex) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erro!");
                        alert.setHeaderText("Ops!");
                        alert.setContentText("Preencha o placar antes de selecionar o resultado!");

                        alert.showAndWait();
                    }finally {
                        cbResultado.setValue(null);
                    }
                }else if((Integer.parseInt(tfGolsP.getText()) > Integer.parseInt(tfGolsC.getText())) && !cbResultado.getSelectionModel().getSelectedItem().equals("V")){
                    try {
                        throw new ResultadoException("s");
                    } catch (ResultadoException ex) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erro!");
                        alert.setHeaderText("Ops!");
                        alert.setContentText("O resultado não condiz com o placar!");

                        alert.showAndWait();
                    }
                }else if((Integer.parseInt(tfGolsC.getText()) > Integer.parseInt(tfGolsP.getText())) && !cbResultado.getSelectionModel().getSelectedItem().equals("V")){
                    try {
                        throw new ResultadoException("S");
                    } catch (ResultadoException ex) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erro!");
                        alert.setHeaderText("Ops!");
                        alert.setContentText("O resultado não condiz com o placar!");

                        alert.showAndWait();
                    }
                }else if(tfGolsP.getText().equals(tfGolsC.getText()) && !cbResultado.getSelectionModel().getSelectedItem().equals("E")){
                    try {
                        throw new ResultadoException("s");
                    } catch (ResultadoException ex) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erro!");
                        alert.setHeaderText("Ops!");
                        alert.setContentText("O resultado não condiz com o placar!");

                        alert.showAndWait();
                    }
                }
            }
        });

        cbAutorGol.setItems(nomes);
    }

    public void resetTablePartida() {
        tfNome.clear();
        tfGolsP.clear();
        tfGolsC.clear();
        cbResultado.setValue(null);
        cbLocal.setValue(null);
    }


    public void loadTablePartida() {

        //Carregamento da tabela de partidas
        PartidaDAO partidaDAO = new PartidaDAO();
        partidasList = partidaDAO.read();


        colid.setCellValueFactory(new PropertyValueFactory<>("_id"));
        colnome.setCellValueFactory(new PropertyValueFactory<>("adversario"));
        colresultado.setCellValueFactory(new PropertyValueFactory<>("resultado"));
        collocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("golsTime"));
        coladc.setCellValueFactory(new PropertyValueFactory<>("golsAdv"));

        tablePartida.setItems(partidasList);

    }

    public void loadTableGol() throws NotStringException, SQLException {
        //Carregamento da tabela de Gols
        GolJogadorDAO golJogadorDAO = new GolJogadorDAO();
        JogadorDAO jogadorDAO = new JogadorDAO();
        gols = golJogadorDAO.read(Integer.parseInt(ifId.getText()));
        gols1.clear();

        for (GolJogadorModel gol : gols) {
            GolJogadorTableModel gj = new GolJogadorTableModel();
            gj.setId(gol.get_id());
            gj.setNome(jogadorDAO.readName(gol.getIdJogador()));
            gj.setQtd(gol.getQtd());

            gols1.add(gj);
        }
        colidgol.setCellValueFactory(new PropertyValueFactory<>("id"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQTD.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tableGols.setItems(gols1);
    }


    public void resetTableGol() {
        tfidGol.clear();
        cbAutorGol.setValue(null);
        tfqtd.clear();
    }


    @FXML
    public void saveGol() throws NotStringException, SQLException {

        PartidaModel p = new PartidaModel();
        GolJogadorDAO golJogadorDAO = new GolJogadorDAO();
        GolJogadorModel gj = new GolJogadorModel();


        try {
            gj.setIdPartida(p.get_id());
            gj.setQtd(tfqtd.getText());
            gj.setIdJogador(jogadores.get(cbAutorGol.getSelectionModel().getSelectedIndex()).get_id());

            golJogadorDAO.create(gj);
        } catch (NullException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Algo de errado ocorreu!\n Lembre-se de selecionar uma partida para editar e de escolher o autor do gol!");

            alert.showAndWait();
        } catch (NotNumberException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Algo de errado ocorreu!\n A quantidade de gols deve ser apenas números!");

            alert.showAndWait();
        }

        loadTableGol();
        resetTableGol();
    }


    @FXML
    protected void btnSave(ActionEvent e) throws SQLException, NullException {
        PartidaDAO partidaDAO = new PartidaDAO();
        PartidaModel partidaModel = new PartidaModel();

        if (!ifId.getText().isEmpty()) partidaModel.set_id(Integer.parseInt(ifId.getText()));
        partidaModel.setAdversario(tfNome.getText());
        partidaModel.setGolsAdv(tfGolsC.getText());
        partidaModel.setGolsTime(tfGolsP.getText());
        partidaModel.setLocal(cbLocal.getSelectionModel().getSelectedItem());
        partidaModel.setResultado(cbResultado.getSelectionModel().getSelectedItem());


        if (partidaModel.get_id() != null) partidaDAO.update(partidaModel, partidaModel.get_id());
        else partidaDAO.create(partidaModel);


        loadTablePartida();
        resetTablePartida();
    }


    @FXML
    protected void btnEdit(ActionEvent e) throws NotNumberException, SQLException, NotStringException, NullException {

        try {
            PartidaModel partidaModel = partidasList.get(tablePartida.getSelectionModel().getSelectedIndex());
            ifId.setText(partidaModel.get_id().toString());
            tfNome.setText(partidaModel.getAdversario());
            tfGolsC.setText(partidaModel.getGolsAdv());
            tfGolsP.setText(partidaModel.getGolsTime());
            cbLocal.getSelectionModel().select(partidaModel.getLocal());
            cbResultado.getSelectionModel().select(partidaModel.getResultado());

            resetTableGol();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você precisa selecionar um item da tabela para editar!");

            alert.showAndWait();
        }finally {
            loadTableGol();
        }
    }


    @FXML
    private TableView<GolJogadorTableModel> tableGols;

    @FXML
    private TableColumn<PartidaModel, String> colid;

    @FXML
    private TableColumn<GolJogadorTableModel, String> colQTD;

    @FXML
    private TableColumn<PartidaModel, String> colnome;

    @FXML
    private TableColumn<PartidaModel, String> collocal;

    @FXML
    private TableColumn<PartidaModel, String> colresultado;

    @FXML
    private TextField tfidGol;

    @FXML
    private TextField tfqtd;

    @FXML
    private TableColumn<PartidaModel, String> coltime;

    @FXML
    private TableColumn<PartidaModel, String> coladc;

    @FXML
    private TextField ifId;

    @FXML
    private TableColumn<GolJogadorTableModel, String> colidgol;

    @FXML
    private TableColumn<GolJogadorTableModel, String> colautor;

    @FXML
    private TextField tfNome;

    @FXML
    private ComboBox<String> cbLocal;

    @FXML
    private TextField tfGolsP;

    @FXML
    private TextField tfGolsC;

    @FXML
    private TableView<PartidaModel> tablePartida;

    @FXML
    private ComboBox<String> cbAutorGol;


    @FXML
    private ComboBox<String> cbResultado;

    ObservableList<String> nomes = FXCollections.observableArrayList();
    ObservableList<PartidaModel> partidasList = FXCollections.observableArrayList();
    ObservableList<JogadorModel> jogadores = FXCollections.observableArrayList();
    ObservableList<GolJogadorModel> gols = FXCollections.observableArrayList();
    ObservableList<GolJogadorTableModel> gols1 = FXCollections.observableArrayList();
}
