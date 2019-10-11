package Lesson_6.Server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) throws SQLException {
        String sql = String.format("SELECT nickname FROM main where login = '%s' and password = '%s'",
                login, pass);

        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()) {
            return rs.getString(1);
        }

        return null;
    }

    public static void addInBlackList(ClientHandler from, String nick) {
            int id1 = 0;
            int id2 = 0;
        try {
            ResultSet rs1 = stmt.executeQuery("SELECT id FROM main WHERE nickname = '" + from.getNick() + "'");

            if(rs1.next()) {
                id1 =  rs1.getInt(1);
            }

            ResultSet rs2 = stmt.executeQuery("SELECT id FROM main WHERE nickname = '" + nick + "'");


            if(rs2.next()) {
                id2 = rs2.getInt(1);
            }
            stmt.executeUpdate("INSERT INTO blacklist (id_user, id_block_user) VALUES (" + id1 +"," + id2 + ")");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
