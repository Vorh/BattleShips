package server;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocketDispatcher extends Thread {
    Socket socket;
    DataInputStream inStream;
    DataOutputStream outStream;
    boolean isOn;
    Matcher mat;
    Pattern pat;
    TextArea text;

    static List<SocketDispatcher> handlers = Collections.synchronizedList(new ArrayList<SocketDispatcher>());

    public SocketDispatcher(Socket socket, TextArea text) throws IOException {
        this.socket = socket;
        this.text = text;
        inStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        outStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void run() {
        isOn = true;
        try {
            handlers.add(this);
            while (isOn) {
                String msg = inStream.readUTF();
                pat = Pattern.compile("Chat:");
                mat = pat.matcher(msg);
                if(mat.find()){
                    text.appendText(mat.replaceAll("") + "\n");
                    broadcast(msg);
                }
                mat = pat.matcher("PlayerShot:");
                if(mat.find()){
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            handlers.remove(this);
            try {
                outStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    static void broadcast(String message) {
        synchronized (handlers) {
            Iterator<SocketDispatcher> it = handlers.iterator();
            while (it.hasNext()) {
                SocketDispatcher c = it.next();
                try {
                    synchronized (c.outStream) {
                        c.outStream.writeUTF(message);
                        System.out.println(message);
                    }
                    c.outStream.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    c.isOn = false;
                }
            }
        }
    }
}
