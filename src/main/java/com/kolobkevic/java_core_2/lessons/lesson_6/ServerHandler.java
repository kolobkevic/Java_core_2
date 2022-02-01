package com.kolobkevic.java_core_2.lessons.lesson_6;

import java.io.*;
import java.net.Socket;

public class ServerHandler {
    private DataInputStream in;
    private DataOutputStream out;
    private SimpleSingleConsoleServer server;
    private Socket socket;

    ServerHandler(Socket socket, SimpleSingleConsoleServer server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

    }

    public void start() {
        try {
            while (true){
                server.sendMessageToAll("New client added");
                break;
            }
            while (true) {
                var message = in.readUTF();
                if (message.startsWith("/quit")) {
                    shutdown();
                    break;
                }
                System.out.println("Message received: " + message);
                server.sendMessageToAll(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutdown() throws IOException {

        if (socket != null) {
            socket.close();

        }
        server.shutdown();
        System.out.println("Server stopped");
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close(){
        server.removeClient(this);
    }
}
