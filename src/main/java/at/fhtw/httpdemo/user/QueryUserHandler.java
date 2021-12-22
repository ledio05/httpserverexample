package at.fhtw.httpdemo.user;

import at.fhtw.httpdemo.Application;
import at.fhtw.httpdemo.Handler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class QueryUserHandler extends Handler {

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(UserHandler.StatusCode.OK.getCode(), 0);

        byte[] response = writeResponse(Application.userList);

        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response);
        responseBody.close();

    }
}
