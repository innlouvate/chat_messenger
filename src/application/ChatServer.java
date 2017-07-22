package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
    static Vector ClientSockets;
    static Vector LoginNames;

    ChatServer() throws IOException {
        ServerSocket server = new ServerSocket(5217);
        ClientSockets = new Vector();
        LoginNames = new Vector();

        while(true) {
            Socket client = server.accept();
            AcceptClient acceptClient = new AcceptClient(client);
        }
    }

    class AcceptClient extends Thread {
        Socket ClientSocket;
        DataInputStream din;
        DataOutputStream dout;

        AcceptClient(Socket client) throws IOException {
            ClientSocket = client;
            din = new DataInputStream(ClientSocket.getInputStream());
            dout = new DataOutputStream(ClientSocket.getOutputStream());

            String LoginName = din.readUTF();
            LoginNames.add(LoginName);
            ClientSockets.add(ClientSocket);

            start();
        }

        public void run() {
            while(true) {

            }
        }
    }
}
