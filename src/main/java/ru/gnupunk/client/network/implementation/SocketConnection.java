package ru.gnupunk.client.network.implementation;

import ru.gnupunk.client.network.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class SocketConnection implements Connection {
    ServerSocket serverSocket;
    Set<Socket> clients;
    @Override
    public void init() throws IOException {
        this.serverSocket = new ServerSocket(80);
        clients = new HashSet<>();
        try {
            System.out.println("Server has started on 127.0.0.1:80.\r\nWaiting for a connection...");
            Socket client = serverSocket.accept();
            clients.add(client);
            System.out.println("A client connected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean testConnection() {
        return this.serverSocket.isClosed();
    }

    @Override
    public void close() {
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            this.serverSocket = null;
        }
    }
}
