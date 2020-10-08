package class03;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleHandler implements HttpHandler {

    private int count;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        count = count + 1;
        printRequest(exchange);

        String response = count + "回目のアクセスです！";
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "text/plain; charset=UTF-8");
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
