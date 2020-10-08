package class04;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class DynamicHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        String method = exchange.getRequestMethod();
        Res res = doOther(exchange);
        switch (method) {
            case "GET":
                res = doGet(exchange);
                break;
            case "POST":
                res = doPost(exchange);
                break;
        }
        headers.add("Content-Type", res.getContentType());
        exchange.sendResponseHeaders(res.getStatusCode(), res.getBodyLength());

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(res.getBodyBytes());
        }
    }

    private Res doOther(HttpExchange exchange) {
        return new Res(405, "<p>405 要求メソッドは許可されていません</p>");
    }

    private Res doGet(HttpExchange exchange) {
        String body = "<form action='dynamic' method='POST'>" +
                "<input type='text' name='yen' /> 円" +
                "<button type='submit'>両替</button>" +
                "</form>";
        return new Res(200, body);
    }

    private Res doPost(HttpExchange exchange) {
        //リクエストメッセージからボディ部から取り出し、数値データに変換する
        try {
            Scanner scanner = new Scanner(exchange.getRequestBody(), "UTF-8");
            String scanned = scanner.nextLine(); //要求ボディの取り出し(yen=xxx)
            String[] split = scanned.split("="); //変数名と値(yen と xxx)に分離
            int yen = Integer.parseInt(split[1]); //値(xxx)を数値に変換
            float usd = yen * 0.0095f; //データ処理:円をドルに変換する
            //処理結果のリソース作成
            String body = String.format("<p>%d 円は %.2f ドル</p>", yen, usd);
            return new Res(200, body);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Res(500, "<p>500 サーバ内部でエラーが生じました</p>");
        }
    }

}
