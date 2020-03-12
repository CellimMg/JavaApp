package model.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EscalacaoModel;
import model.MYSQL.connection.ConnectionFactory;
import model.PartidaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EscalacaoDAO {

    public void create(int id){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO escalacao (idPartida) VALUES (?)");


            stmt.setInt(1, id);



            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }



    public Integer readEscalacaoId(int id){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            stmt = connection.prepareStatement("SELECT * FROM escalacao WHERE idPartida = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();


            if(rs.next()){
                return rs.getInt("id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public ObservableList<EscalacaoModel> read(){

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<EscalacaoModel> em = FXCollections.observableArrayList();

        try {
            stmt = connection.prepareStatement("SELECT * FROM escalacao");
            rs = stmt.executeQuery();

            while (rs.next()){
                EscalacaoModel gj = new EscalacaoModel();
                gj.setId(rs.getInt("id"));
                gj.setIdPartida(rs.getInt("idJogador"));


                em.add(gj);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

        return em;
    }

    public void update(EscalacaoModel em, int id){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("UPDATE escalacao SET idJogador = ? WHERE id = ?");

            stmt.setInt(1, em.getIdPartida());
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
            stmt = connection.prepareStatement("DELETE escalacao WHERE id = ?");

            stmt.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

}
