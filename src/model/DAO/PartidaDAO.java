package model.DAO;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MYSQL.connection.ConnectionFactory;
import model.PartidaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PartidaDAO {

    public void create(PartidaModel p) throws SQLException, NullException {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        switch (p.getLocal()){
            case "Fora":
                p.setLocal("F");
                break;
            case "Casa":
                p.setLocal("C");
        }

        switch (p.getResultado()){
            case "Vitória":
                p.setResultado("V");
                break;
            case "Derrota":
                p.setResultado("D");
                break;
            case "Empate":
                p.setResultado("E");
        }

        try {
            stmt = connection.prepareStatement("INSERT INTO partida (adversario, resultado, local, golsPro, golsContra)" +
                    " VALUES (?, ?, ?, ?, ?)") ;

            stmt.setString(1, p.getAdversario());
            stmt.setString(2, p.getResultado());
            stmt.setString(3, p.getLocal());
            stmt.setString(4, p.getGolsTime());
            stmt.setString(5, p.getGolsAdv());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           

            ConnectionFactory.closeConnection(connection, stmt);
        }

    }


    public ObservableList<PartidaModel> read() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<PartidaModel> pm = FXCollections.observableArrayList();

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
        } catch (SQLException | NullException | NotNumberException e) {
            e.printStackTrace();
        }
        return pm;
    }

    public PartidaModel getLast(){
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        PartidaModel partidaModel = new PartidaModel();

        try {
            stmt = connection.prepareStatement("SELECT * \n" +
                    "FROM partida\n" +
                    "ORDER BY id DESC\n" +
                    "LIMIT 1");


            ResultSet rs = stmt.executeQuery();

            rs.next();

            partidaModel.set_id(rs.getInt("id"));
            partidaModel.setAdversario(rs.getString("adversario"));
            partidaModel.setGolsTime(rs.getString("golsPro"));
            partidaModel.setGolsAdv(rs.getString("golsContra"));
            partidaModel.setLocal(rs.getString("local"));
            partidaModel.setResultado(rs.getString("resultado"));

        } catch (SQLException | NullException | NotNumberException e) {
            e.printStackTrace();
        }

        return partidaModel;
    }



    public void update(PartidaModel p, int id) throws NullException {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        switch (p.getLocal()){
            case "Fora":
                p.setLocal("F");
                break;
            case "Casa":
                p.setLocal("C");
        }

        switch (p.getResultado()){
            case "Vitória":
                p.setResultado("V");
                break;
            case "Derrota":
                p.setResultado("D");
                break;
            case "Empate":
                p.setResultado("E");
        }


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
