package com.kolobkevic.java_core_2.lessons.lesson_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleSingleConsoleServer {
    private static final int PORT = 8189;
    private Socket socket;
    private List<ServerHandler> listClients = new ArrayList<>();
    private List<Thread> clientHandlerThreads = new ArrayList<>();
    private DataInputStream in;
    private DataOutputStream out;
    private Thread serverConsoleThread;

    public static void main(String[] args) {
        new SimpleSingleConsoleServer().start();
    }

    public void start() {
        try (var serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            waitForConnection(serverSocket);
            startConsoleThread();

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

    public void shutdown() throws IOException {
        if (serverConsoleThread.isAlive()) {
            serverConsoleThread.interrupt();
        }
        if (socket != null) {
            socket.close();
        }
        System.out.println("Server stopped");
    }

    private void startConsoleThread() {
        serverConsoleThread = new Thread(() -> {
            try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.print("Enter message for client>>>");
                while (!Thread.currentThread().isInterrupted()) {
                    if (reader.ready()) {
                        var serverMessage = reader.readLine();
                        out.writeUTF(serverMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverConsoleThread.start();
    }

    private void waitForConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Waiting for connection...");
        while (true) {
            socket = serverSocket.accept();
            ServerHandler client = new ServerHandler(socket,this);
            listClients.add(client);
            new Thread(() -> {
                client.start();
            }).start();
        }
    }

    public void sendMessageToAll(String message) {
        for (ServerHandler serverHandler : listClients) {
            serverHandler.sendMsg(message);
        }
    }

    public void removeClient( ServerHandler serverHandler){
        listClients.remove(serverHandler);
    }

    public void sendMessage(String message, ServerHandler serverHandler) {
        serverHandler.sendMsg(message);
    }


}
