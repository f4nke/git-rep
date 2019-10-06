import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.start(socket);
    }
}

