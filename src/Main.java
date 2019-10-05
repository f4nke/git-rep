

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {


    public static void start(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner userIn = new Scanner(System.in);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String outMsg = userIn.nextLine();
                            out.writeUTF(outMsg);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();


            while (true) {
                String msg = in.readUTF();
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
