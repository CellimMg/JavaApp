package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.JogadorDAO;
import model.DAO.PartidaDAO;
import model.PartidaModel;

public class AddPartidaController {



    @FXML
    protected void initialize(){

        resetTable();
        PartidaDAO partidaDAO = new PartidaDAO();
        partidasList = partidaDAO.read();
        JogadorDAO jogadorDAO = new JogadorDAO();

        for(int x = 0; x < jogadorDAO.read().toArray().length; x++){
            nomes.add(jogadorDAO.read().get(x).getNome());
            System.out.println(nomes);
        }

        cbLocal.getItems().addAll(
          "C", "F"
        );

        cbResultado.getItems().addAll(
          "V", "E", "D"
        );

        cbAutorGol.setItems(nomes);
    }

    public void resetTable(){
        PartidaDAO partidaDAO = new PartidaDAO();
        partidasList = partidaDAO.read();

        System.out.println(partidasList);

        colid.setCellValueFactory(new PropertyValueFactory<>("_id"));
        colnome.setCellValueFactory(new PropertyValueFactory<>("adversario"));
        colresultado.setCellValueFactory(new PropertyValueFactory<>("resultado"));
        collocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        coltime.setCellValueFactory(new PropertyValueFactory<>("golsTime"));
        coladc.setCellValueFactory(new PropertyValueFactory<>("golsAdv"));


        tablePartida.setItems(partidasList);
    }


    @FXML
    protected void btnSave(ActionEvent e){
        PartidaDAO partidaDAO = new PartidaDAO();
        PartidaModel partidaModel = new PartidaModel();

        if(!ifId.getText().isEmpty()) partidaModel.set_id(Integer.parseInt(ifId.getText()));
        partidaModel.setAdversario(tfNome.getText());
        partidaModel.setGolsAdv(tfGolsC.getText());
        partidaModel.setGolsTime(tfGolsP.getText());
        partidaModel.setLocal(cbLocal.getSelectionModel().getSelectedItem());
        partidaModel.setResultado(cbResultado.getSelectionModel().getSelectedItem());


        if (partidaModel.get_id() != null) partidaDAO.update(partidaModel, partidaModel.get_id());
        else partidaDAO.create(partidaModel);

        resetTable();
    }


    @FXML
    protected void btnEdit(ActionEvent e){
        try {
            PartidaModel partidaModel = partidasList.get(tablePartida.getSelectionModel().getSelectedIndex());
            ifId.setText(partidaModel.get_id().toString());
            tfNome.setText(partidaModel.getAdversario());
            tfGolsC.setText(partidaModel.getGolsAdv());
            tfGolsP.setText(partidaModel.getGolsTime());
            cbLocal.getSelectionModel().select(partidaModel.getLocal());
            cbResultado.getSelectionModel().select(partidaModel.getResultado());
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você precisa selecionar um item da tabela para editar!");

            alert.showAndWait();
        }
    }


    @FXML
    private TableColumn<PartidaModel, String> colid;

    @FXML
    private TableColumn<PartidaModel, String> colnome;

    @FXML
    private TableColumn<PartidaModel, String> collocal;

    @FXML
    private TableColumn<PartidaModel, String> colresultado;

    @FXML
    private TableColumn<PartidaModel, String> coltime;

    @FXML
    private TableColumn<PartidaModel, String> coladc;

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
    private TableView<PartidaModel> tablePartida;

    @FXML
    private ComboBox<String> cbAutorGol;

    @FXML
    private ComboBox<String> cbResultado;

    @FXML
    private TableView<PartidaModel> tableGols;

    ObservableList<String> nomes = FXCollections.observableArrayList();
    ObservableList<PartidaModel> partidasList = FXCollections.observableArrayList();

}
