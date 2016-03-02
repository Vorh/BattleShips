package model;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlinePart implements Runnable{
    int ip;
    int port;
    Socket socket;
    DataOutputStream outputStream;
    DataInputStream inputStream;
    Matcher mat;
    Pattern pat;
    TextArea text;

    public void connection(String ip , String port, TextArea text){
        this.text = text;
        this.port = Integer.parseInt(port);
        try {
            socket = new Socket(ip, this.port);
            outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            new Thread(this).start();

        } catch (IOException e) {
            e.printStackTrace();
            if(outputStream != null)
                try {
                outputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                String line = inputStream.readUTF();
                pat = Pattern.compile("Chat:");
                mat = pat.matcher(line);
                if(mat.find()){
                    System.out.println(line);
                    text.appendText(mat.replaceAll("") + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enter(String message){
        try {
            outputStream.writeUTF(message);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
