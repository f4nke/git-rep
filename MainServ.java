package Lesson_6.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class MainServ {
    private Vector<ClientHandler> clients;

    public MainServ() throws SQLException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();

//            String res = AuthService.getNickByLoginAndPass("login1", "pass2");
//            System.out.println(res);

            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AuthService.disconnect();
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

    public void privateMessage(ClientHandler out, String nick, String msg) {
        for(ClientHandler o: clients) {
            if(o.getNick().equals(nick)) {
                o.sendMsg("ПМ от " + out.getNick() + ":" + msg);
                out.sendMsg(msg);
                return;
            }
        }
        out.sendMsg("Получатель " + nick + " не найден");
    }

    public  boolean  busyNick(String nick) {
        for (ClientHandler o: clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }
}
