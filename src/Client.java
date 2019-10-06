import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 12345);
            Main.start(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
