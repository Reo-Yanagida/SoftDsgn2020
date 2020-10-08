package class03;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {

    public static void main(String[] args) {
        try {
            // ポート番号8080でサーバーを作成する
            InetSocketAddress address = new InetSocketAddress(8080);
            HttpServer httpServer = HttpServer.create(address, 0);

            SimpleHandler simpleHandler = new SimpleHandler();
            httpServer.createContext("/hello", simpleHandler);
            //ここから
            OmikujiHandler omikujiHandler = new OmikujiHandler();
            httpServer.createContext("/omikuji", omikujiHandler);

            ImageHandler imageHandler = new ImageHandler();
            httpServer.createContext("/image", imageHandler);
            //ここまで追加

            //サーバーを起動する
            httpServer.start();
            System.out.println("Server is started!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
