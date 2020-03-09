package model.DAO;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.JogadorModel;
import model.MYSQL.connection.ConnectionFactory;
import model.GolJogadorModel;
import model.PartidaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GolJogadorDAO {

    public void create(GolJogadorModel gj){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO goljogador (idJogador, idPartida, qtd) VALUES (?, ?, ?)");

            stmt.setInt(1, gj.getIdJogador());
            stmt.setInt(2, gj.getIdPartida());
            stmt.setString(3, gj.getQtd());


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public ObservableList<GolJogadorModel> read(int id){

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<GolJogadorModel> gm = FXCollections.observableArrayList();

        try {
            stmt = connection.prepareStatement("SELECT * FROM goljogador WHERE idPartida = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()){
                GolJogadorModel gj = new GolJogadorModel();
                gj.set_id(rs.getInt("id"));
                gj.setIdJogador(rs.getInt("idJogador"));
                gj.setIdPartida(rs.getInt("idPartida"));
                gj.setQtd(rs.getString("qtd"));

                gm.add(gj);
            }

        } catch (SQLException | NotNumberException | NullException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

        return gm;
    }


    public Integer soma(int id){
        Connection connection = ConnectionFactory.getConnection();
        Integer value = null;

        PreparedStatement stmt = null;


        try {
            stmt = connection.prepareStatement("SELECT SUM(qtd) FROM goljogador WHERE idPartida = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            value = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return value;
    }

    public void update(GolJogadorModel gm, int id){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("UPDATE goljogador SET idJogador = ?, qtd = ? WHERE id = ?");

            stmt.setInt(1, gm.getIdJogador());
            stmt.setInt(2, Integer.parseInt(gm.getQtd()));
            stmt.setInt(3, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void delete(int id){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM goljogador WHERE id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    public void deleteFromPartida(int id){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;


        try {
            stmt = connection.prepareStatement("DELETE goljogador WHERE idPartida = ?");

            stmt.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

}
