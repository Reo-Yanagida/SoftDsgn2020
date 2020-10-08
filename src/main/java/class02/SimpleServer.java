package class02;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {

    public static void main(String[] args) {
        try {
            InetSocketAddress address = new InetSocketAddress(8080);
            HttpServer httpServer = HttpServer.create(address, 0);
            SimpleHandler simpleHandler = new SimpleHandler();
            httpServer.createContext("/hello", simpleHandler);
            httpServer.start();
            System.out.println("Server is started!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
