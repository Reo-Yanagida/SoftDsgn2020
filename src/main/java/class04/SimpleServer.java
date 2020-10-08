package class04;

import class03.ImageHandler;
import class03.OmikujiHandler;
import class03.SimpleHandler;
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

            OmikujiHandler omikujiHandler = new OmikujiHandler();
            httpServer.createContext("/omikuji", omikujiHandler);

            ImageHandler imageHandler = new ImageHandler();
            httpServer.createContext("/image", imageHandler);

            DynamicHandler dynamicHandler = new DynamicHandler();
            httpServer.createContext("/dynamic", dynamicHandler);

            httpServer.start();
            System.out.println("Server is started!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
