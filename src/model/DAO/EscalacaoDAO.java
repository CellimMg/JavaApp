package model.DAO;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;
import model.EscalacaoModel;
import model.GolJogadorModel;
import model.MYSQL.connection.ConnectionFactory;
import model.PartidaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscalacaoDAO {

    public void create(EscalacaoModel e, PartidaModel p){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO escalacao (id, idPartida) VALUES (?, ?)");

            stmt.setInt(1, e.get_Id());
            stmt.setInt(2, p.get_id());



            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public List<EscalacaoModel> read(){

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EscalacaoModel> gm = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM escalacao");
            rs = stmt.executeQuery();

            while (rs.next()){
                GolJogadorModel gj = new GolJogadorModel();
                gj.set_id(rs.getInt("id"));
                gj.setIdJogador(rs.getInt("idJogador"));
                gj.setIdPartida(rs.getInt("idPartida"));
                gj.setQtd(rs.getString("qtd"));

            }

        } catch (SQLException | NotNumberException | NullException e) {
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
