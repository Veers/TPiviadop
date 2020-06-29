package ru.gnupunk.client.network;

import java.io.IOException;

public interface Connection {

    public void init() throws IOException;
    public boolean testConnection();
//    public void send();
//    public void receive();
    public void close();
}
