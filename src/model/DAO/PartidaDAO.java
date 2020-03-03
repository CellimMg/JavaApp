package model.DAO;

import model.JogadorModel;
import model.MYSQL.connection.ConnectionFactory;
import model.PartidaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO {

    public void create(PartidaModel p) {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSER INTO partida (adversario, resultado, local, golsTime, golsAdv)" +
                    " VALUES (?, ?, ?, ?, ?)") ;

            stmt.setString(1, p.getAdversario());
            stmt.setString(2, p.getResultado());
            stmt.setString(3, p.getLocal());
            stmt.setString(4, p.getGolsTime());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

    }


    public List<PartidaModel> read() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PartidaModel> pm = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM partida");
            rs = stmt.executeQuery();

            while (rs.next()) {
               PartidaModel p = new PartidaModel();

                p.set_id(rs.getInt("id"));
                p.setAdversario(rs.getString("adversario"));
                p.setResultado(rs.getString("resultado"));
                p.setLocal(rs.getString("local"));
                p.setGolsAdv(rs.getString("golsContra"));
                p.setGolsTime(rs.getString("golsPro"));


                pm.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pm;
    }

    public void update(PartidaModel p, int id) {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;


        try {
            stmt = connection.prepareStatement("UPDATE partida SET adversario = ?, resultado= ?, local= ?, golsPro= ?, " +
                    "golsContra= ? WHERE id = ?");

           stmt.setString(1, p.getAdversario());
           stmt.setString(2, p.getResultado());
           stmt.setString(3, p.getLocal());
           stmt.setString(4, p.getGolsTime());
           stmt.setString(5, p.getGolsAdv());

           stmt.setInt(6, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("DELETE FROM partida WHERE id = ?");


            stmt.setInt(1, id);


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }


    }


}
