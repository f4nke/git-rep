package ru.geekbrains.chat.server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String login, String pass, String nick) {
        try {
            String query = "INSERT INTO main (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addInBlackList(ClientHandler from, String nick) {
        try {
            ResultSet rs1 = stmt.executeQuery("SELECT id FROM main WHERE nickname = '" + from.getNick() + "'");
            ResultSet rs2 = stmt.executeQuery("SELECT id FROM main WHERE nickname = '" + nick + "'");
            Integer.parseInt(rs1.getObject(1).toString());
            Integer.parseInt(rs2.getObject(1).toString());
            ResultSet rs = stmt.executeQuery ("INSERT INTO blacklist (id_user, id_block_user) VALUES (" + rs1 + "," + rs2 + ")");
    } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }



    public static String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname, password FROM main WHERE login = '" + login + "'");
            int myHash = pass.hashCode();
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if (myHash == dbHash) {
                    return nick;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveHistory(String login, String text) {
        String sql = String.format("INSTERT INTO history (name, msg)" + "VALUES ('%s', '%s')", login, text);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getHistory() {
        StringBuilder sb = new StringBuilder();
        String sql = String.format("SELECT name, msg from history" + "ORDER BY ID");

        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sb.append(rs.getString("name") + " " + rs.getString("msg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void createTable() throws SQLException {
        stmt.execute("CREATE TABLE DZ (" +
                "id INTEGER PRIMARY KEY," +
                "RandomText TEXT)");
    }

    public static void updateTable() throws SQLException {
        stmt.execute("INSERT INTO DZ (id, RandomText) VALUES (1, 'user1')");
    }

    public static void deleteTable() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS DZ");
    }
}
