package model.DAO;

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
import java.util.ArrayList;
import java.util.List;

public class GolJogadorDAO {

    public void create(JogadorModel j, PartidaModel p){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO goljogador (idJogador, idPartida, qtd) VALUES (?, ?, ?)");

            stmt.setInt(1, j.get_id());
            stmt.setInt(2, p.get_id());
            stmt.setString(3, "1");


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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

        return gm;
    }

    public void update(GolJogadorModel gm, int id){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("UPDATE goljogador SET idJogador = ? WHERE id = ?");

            stmt.setInt(1, gm.getIdJogador());
            stmt.setInt(2, id);

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
            stmt = connection.prepareStatement("DELETE goljogador WHERE id = ?");

            stmt.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

}
