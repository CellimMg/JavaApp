package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.DAO.JogadorDAO;
import model.JogadorModel;

public class AddPlayerController {

    @FXML
    protected void initialize(){
        cbPosicao.getItems().addAll(
                "GOL", "LTD", "LTE", "ZAG", "VOL", "MEI", "ATA"
        );
        cbPerna.getItems().addAll(
                "D", "E", "A"
        );
    }

    @FXML
    protected void btSalvarBD(ActionEvent e){
        JogadorModel j = new JogadorModel();
        JogadorDAO jogadorDAO = new JogadorDAO();

        j.setNome(tfNomeCompleto.getText());
        j.setNomeMae(tfNomeMae.getText());
        j.setIdade(tfIdade.getText());
        j.setCidade(tfCidade.getText());
        j.setEstado(tfEstado.getText());
        j.setPais(tfPais.getText());
        j.setPosicao(cbPosicao.getSelectionModel().getSelectedItem().toString());
        j.setPernaChute(cbPerna.getSelectionModel().getSelectedItem().toString());
        j.setAltura(tfAltura.getText());



        jogadorDAO.create(j);
    }

    @FXML
    private Label lblHeaderCadastro;

    @FXML
    private Label lblDadosPessoais;

    @FXML
    private TextField tfNomeCompleto;

    @FXML
    private TextField tfNomeMae;

    @FXML
    private TextField tfIdade;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfEstado;

    @FXML
    private TextField tfPais;

    @FXML
    private Label lblDadosAtletas;

    @FXML
    private ComboBox<String> cbPosicao;

    @FXML
    private ComboBox<String> cbPerna;

    @FXML
    private TextField tfAltura;

    @FXML
    private Button btnSalvar1;

    @FXML
    private Button btnSalvar2;

    @FXML
    private Button btnSalvar;



}
