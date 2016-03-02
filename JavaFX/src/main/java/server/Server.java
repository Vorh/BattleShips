package server;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    TextArea text;

    public Server(int port, TextArea text) throws IOException {
      this.text = text;
    }

    @Override
    public void run() {
        int port = 2074;
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                System.out.println("Start server");
                Socket socket = serverSocket.accept();
                System.out.println("Новое подключение" + socket.getInetAddress());
                SocketDispatcher socketDispatcher = new SocketDispatcher(socket,text);
                socketDispatcher.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
