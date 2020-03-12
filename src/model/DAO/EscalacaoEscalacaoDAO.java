package model.DAO;

import controller.Exceptions.MoreThanThreeException;
import controller.Exceptions.NotNumberException;
import controller.Exceptions.NotStringException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EscalacaoEscalacaoModel;
import model.JogadorModel;
import model.MYSQL.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EscalacaoEscalacaoDAO {


    public void create(int idPartida, int idEscalacao, int idJogador){

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;



        try {
            stmt = connection.prepareStatement("INSERT INTO `escalacao_escalacao` (`idJogador`, `idEscalacao`, `idPartida`) VALUES (?, ?, ?);");

            stmt.setInt(1, idJogador);
            stmt.setInt(2, idEscalacao);
            stmt.setInt(3, idPartida);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

    }


    public ObservableList<EscalacaoEscalacaoModel> read(int id){

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<EscalacaoEscalacaoModel> jm = FXCollections.observableArrayList();

        try {
            stmt = connection.prepareStatement("SELECT * FROM escalacao_escalacao WHERE idPartida = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
               EscalacaoEscalacaoModel j = new EscalacaoEscalacaoModel();

               j.setIdPartida(rs.getInt("idPartida"));
                j.setIdEscalacao(rs.getInt("idEscalacao"));
                j.setIdJogador(rs.getInt("idJogador"));
                jm.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return jm;
    }


    public void delete(int idJogador, int idPartida, int idEscalacao) {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("DELETE FROM escalacao_escalacao WHERE idJogador = ? and idPartida = ? and idEscalacao = ?");


            stmt.setInt(1, idJogador);
            stmt.setInt(2, idPartida);
            stmt.setInt(3, idEscalacao);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }


    }


}
