package JavaChatApp.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Set<ClientHandler> clientHandlers;
    private String clientName;

    public ClientHandler(Socket socket, Set<ClientHandler> clientHandlers) {
        this.socket = socket;
        this.clientHandlers = clientHandlers;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your nickname: ");
            clientName = in.readLine();
            broadcast(clientName + " joined the chat!");

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/msg")) {
                    privateMessage(message);
                } else if (message.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    broadcast(clientName + ": " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clientHandlers) {
            if (client != this) {
                client.out.println(message);
            }
        }
    }

    private void privateMessage(String message) {
        String[] split = message.split(" ", 3);
        if (split.length < 3) return;
        String targetName = split[1];
        String msg = split[2];

        for (ClientHandler client : clientHandlers) {
            if (client.clientName.equalsIgnoreCase(targetName)) {
                client.out.println("(Private) " + clientName + ": " + msg);
                return;
            }
        }
        out.println("User " + targetName + " not found.");
    }

    private void closeConnection() {
        try {
            clientHandlers.remove(this);
            socket.close();
            broadcast(clientName + " left the chat!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
