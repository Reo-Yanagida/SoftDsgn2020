package class03;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageHandler implements HttpHandler {

    private int count;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        count = count + 1;
        printRequest(exchange);

        String[] results = new String[]{"大吉", "中吉", "吉"};
        int n = new Random().nextInt(3);
        String result = results[n];

        String response = "";

        switch (result) {
            case "大吉":
                response = "<img src='https://bit.ly/3l1w58F'>";
                break;
            case "中吉":
                response = "<img src='https://bit.ly/349WrOY'>";
                break;
            case "吉":
                response = "<img src='https://bit.ly/3jh7v31'>";
                break;
        }

        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.getBytes().length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private void printRequest(HttpExchange exchange) {
        System.out.printf("Request Message %d ------------", count);

        String method = exchange.getRequestMethod();
        System.out.println("Method:" + method);

        String uri = exchange.getRequestURI().toString();
        System.out.println("URI:" + uri);

        System.out.println("Headers:");
        Headers headers = exchange.getRequestHeaders();
        headers.entrySet().forEach(System.out::println);
    }

}
