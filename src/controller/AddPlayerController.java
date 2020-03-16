package controller;

import controller.Exceptions.MoreThanThreeException;
import controller.Exceptions.MoreThanTwoException;
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


public class AddPlayerController {

    @FXML
    protected void initialize() throws Exception {
        resetTable();
        cbPosicao.getItems().addAll(
                "GOL", "LTD", "LTE", "ZAG", "VOL", "MEI", "ATA"
        );
        cbPerna.getItems().addAll(
                "D", "E", "A"
        );
    }

    public void resetTable() throws Exception {
        JogadorDAO jogadorDAO = new JogadorDAO();

        jogadorList = jogadorDAO.read();

        System.out.println(jogadorList);

        col_id.setCellValueFactory(new PropertyValueFactory<>("_id"));
        col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        col_perna.setCellValueFactory(new PropertyValueFactory<>("pernaChute"));
        col_posicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        col_altura.setCellValueFactory(new PropertyValueFactory<>("altura"));

        tableViewJogador.setItems(jogadorList);
    }

    @FXML
    protected void btSalvarBD(ActionEvent e){
        JogadorModel j = new JogadorModel();
        JogadorDAO jogadorDAO = new JogadorDAO();
        try {
            if (!tfId.getText().isEmpty()) j.set_id(Integer.parseInt(tfId.getText()));
            j.setNome(tfNomeCompleto.getText().toUpperCase());
            j.setNomeMae(tfNomeMae.getText().toUpperCase());
            j.setIdade(tfIdade.getText());
            j.setCidade(tfCidade.getText().toUpperCase());
            j.setEstado(tfEstado.getText().toUpperCase());
            j.setPais(tfPais.getText().toUpperCase());
            j.setPosicao(cbPosicao.getSelectionModel().getSelectedItem());
            j.setPernaChute(cbPerna.getSelectionModel().getSelectedItem());
            j.setAltura(tfAltura.getText());

            if (j.get_id() != null) jogadorDAO.update(j, j.get_id());
            else jogadorDAO.create(j);

            resetTable();

            tfId.clear();
            tfNomeCompleto.clear();
            tfNomeMae.clear();
            tfIdade.clear();
            tfCidade.clear();
            tfEstado.clear();
            tfPais.clear();
            cbPosicao.setValue(null);
            cbPerna.setValue(null);
            tfAltura.clear();

        } catch (NotStringException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de que os nomes próprios e de localidades devem possuir apenas letras e espaços, além disso, lembre-se de não deixar vazio!");

            alert.showAndWait();
        } catch (NotNumberException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de que a altura e a idade devem ser representadas apenas por algarismos.");

            alert.showAndWait();
        } catch (MoreThanThreeException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de que a altura deve ser representada pelo valor em centímetros, dessa forma, 1.92 metros será descrito como 192, por exemplo.");

            alert.showAndWait();
        }catch (NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você preencheu um ou mais campos de forma incorreta!\n Lembre-se de preencher todos os campos, inclusive POSIÇÃO e PERNA DE CHUTE.");

            alert.showAndWait();
        }catch (MoreThanTwoException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("A idade deve ter no máximo 2 algarismos e no mínimo 1.");

            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    protected void btnEdit(ActionEvent e){

        try {
            JogadorModel j = jogadorList.get(tableViewJogador.getSelectionModel().getSelectedIndex());
            tfId.setText(j.get_id().toString());
            tfNomeCompleto.setText(j.getNome());
            tfNomeMae.setText(j.getNomeMae());
            tfIdade.setText(j.getIdade());
            tfCidade.setText(j.getCidade());
            tfEstado.setText(j.getEstado());
            tfPais.setText(j.getPais());
            cbPosicao.getSelectionModel().select(j.getPosicao());
            cbPerna.getSelectionModel().select(j.getPernaChute());
            tfAltura.setText(j.getAltura());
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você precisa selecionar um item da tabela para editar!");
            alert.showAndWait();
        }
    }

    @FXML
    protected void btnDelete(ActionEvent e) throws Exception {
        try {
            JogadorModel j = jogadorList.get(tableViewJogador.getSelectionModel().getSelectedIndex());
            JogadorDAO jogadorDAO = new JogadorDAO();
            jogadorDAO.delete(j.get_id());
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro!");
            alert.setHeaderText("Ops!");
            alert.setContentText("Você precisa selecionar um item da tabela para excluir!");

            alert.showAndWait();
        }finally {
            resetTable();
            tfId.clear();
            tfNomeCompleto.clear();
            tfNomeMae.clear();
            tfIdade.clear();
            tfCidade.clear();
            tfEstado.clear();
            tfPais.clear();
            cbPosicao.setValue(null);
            cbPerna.setValue(null);
            tfAltura.clear();
        }
    }

    @FXML
    protected void btnLoad(ActionEvent e) throws Exception {
        JogadorDAO jogadorDAO = new JogadorDAO();
        System.out.println(jogadorDAO.read());
    }


    @FXML
    private TextField tfId;

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
