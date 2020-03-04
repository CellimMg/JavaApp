package controller;

import controller.Exceptions.MoreThanThreeException;
import controller.Exceptions.NotNumberException;
import controller.Exceptions.NotStringException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.JogadorDAO;
import model.JogadorModel;
import model.MYSQL.connection.ConnectionFactory;

import java.sql.Connection;

public class AddPlayerController {

    @FXML
    protected void initialize(){

        JogadorDAO jogadorDAO = new JogadorDAO();

        jogadorList = jogadorDAO.read();

        col_id.setCellValueFactory(new PropertyValueFactory<>("_id"));
        col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        col_perna.setCellValueFactory(new PropertyValueFactory<>("pernaChute"));
        col_posicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        col_altura.setCellValueFactory(new PropertyValueFactory<>("altura"));


        tableViewJogador.setItems(jogadorList);
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

        try {
            j.setNome(tfNomeCompleto.getText());
            j.setNomeMae(tfNomeMae.getText());
            j.setIdade(tfIdade.getText());
            j.setCidade(tfCidade.getText());
            j.setEstado(tfEstado.getText());
            j.setPais(tfPais.getText());
            j.setPosicao(cbPosicao.getSelectionModel().getSelectedItem().toString());
            j.setPernaChute(cbPerna.getSelectionModel().getSelectedItem().toString());
            j.setAltura(tfAltura.getText());
        } catch (NotStringException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de que os nomes próprios e de localidades devem possuir apenas letras e espaços!");

            alert.showAndWait();
            ex.printStackTrace();
        } catch (NotNumberException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de que a altura e a idade devem ser representadas apenas por algarismos.");

            alert.showAndWait();
            ex.printStackTrace();
        } catch (MoreThanThreeException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de que a altura deve ser representada pelo valor em centímetros, dessa forma, 1.92 metros será descrito como 192, por exemplo.");

            alert.showAndWait();
            ex.printStackTrace();
        }catch (NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de preencher todos os campos, inclusive POSIÇÃO e PERNA DE CHUTE.");

            alert.showAndWait();
        }


        jogadorDAO.create(j);
    }


    @FXML
    private TableView<JogadorModel> tableViewJogador;

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

    @FXML
    private TableColumn<JogadorModel, String> col_id;

    @FXML
    private TableColumn<JogadorModel, String> col_nome;

    @FXML
    private TableColumn<JogadorModel, String> col_idade;

    @FXML
    private TableColumn<JogadorModel, String> col_posicao;

    @FXML
    private TableColumn<JogadorModel, String> col_altura;

    @FXML
    private TableColumn<JogadorModel, String> col_perna;

    ObservableList<JogadorModel> jogadorList = FXCollections.observableArrayList();
}
