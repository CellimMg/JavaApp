package model.DAO;

import controller.Exceptions.MoreThanThreeException;
import controller.Exceptions.NotNumberException;
import controller.Exceptions.NotStringException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.JogadorModel;
import model.MYSQL.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogadorDAO {

    public void create(JogadorModel j) {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO jogador (nome, idade, cidade, estado, pais, nomeMae," +
                    "posicao, pernaChute, altura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, j.getNome());
            stmt.setString(2, j.getIdade());
            stmt.setString(3, j.getCidade());
            stmt.setString(4, j.getEstado());
            stmt.setString(5, j.getPais());
            stmt.setString(6, j.getNomeMae());
            stmt.setString(7, j.getPosicao());
            stmt.setString(8, j.getPernaChute());
            stmt.setString(9, j.getAltura());


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

    }

    public String readName(int id) throws SQLException, NotStringException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JogadorModel j = new JogadorModel();

        stmt = connection.prepareStatement("SELECT * FROM jogador WHERE id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        if (rs.next()){
            j.setNome(rs.getString("nome"));
        }

        return j.getNome();
    }



    public JogadorModel read(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JogadorModel j = new JogadorModel();

        try {
            stmt = connection.prepareStatement("SELECT * FROM jogador WHERE id = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();


            while (rs.next()) {


                j.set_id(rs.getInt("id"));
                j.setNome(rs.getString("nome"));
                j.setNomeMae(rs.getString("nomeMae"));
                j.setCidade(rs.getString("cidade"));
                j.setEstado(rs.getString("estado"));
                j.setPais(rs.getString("pais"));
                j.setAltura(rs.getString("altura"));
                j.setPernaChute(rs.getString("pernaChute"));
                j.setIdade(rs.getString("idade"));
                j.setPosicao(rs.getString("posicao"));


            }
        } catch (SQLException | NotStringException | NotNumberException | MoreThanThreeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return j;
    }


    public ObservableList<JogadorModel> read() throws Exception {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<JogadorModel> jm = FXCollections.observableArrayList();

        try {
            stmt = connection.prepareStatement("SELECT * FROM jogador");
            rs = stmt.executeQuery();

            while (rs.next()) {
                JogadorModel j = new JogadorModel();

                j.set_id(rs.getInt("id"));
                j.setNome(rs.getString("nome"));
                j.setNomeMae(rs.getString("nomeMae"));
                j.setCidade(rs.getString("cidade"));
                j.setEstado(rs.getString("estado"));
                j.setPais(rs.getString("pais"));
                j.setAltura(rs.getString("altura"));
                j.setPernaChute(rs.getString("pernaChute"));
                j.setIdade(rs.getString("idade"));
                j.setPosicao(rs.getString("posicao"));

                jm.add(j);
            }
        } catch (SQLException | NotStringException | NotNumberException | MoreThanThreeException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return jm;
    }

    public void update(JogadorModel j, int id) {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;


        try {
            stmt = connection.prepareStatement("UPDATE jogador SET nome = ?, idade= ?, cidade= ?, estado= ?, " +
                    "pais= ?, nomeMae= ?, posicao= ?, pernaChute= ?, altura= ? WHERE id = ?");

            stmt.setString(1, j.getNome());
            stmt.setString(2, j.getIdade());
            stmt.setString(3, j.getCidade());
            stmt.setString(4, j.getEstado());
            stmt.setString(5, j.getPais());
            stmt.setString(6, j.getNomeMae());
            stmt.setString(7, j.getPosicao());
            stmt.setString(8, j.getPernaChute());
            stmt.setString(9, j.getAltura());

            stmt.setInt(10, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void delete(int index) {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("DELETE FROM jogador WHERE id = ?");


            stmt.setInt(1, index);


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }


    }
}
