package model.DAO;

import model.JogadorModel;
import model.MYSQL.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartidaDAO {

    public void create(JogadorModel j){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;


        try {
            stmt = con.prepareStatement("insert ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
