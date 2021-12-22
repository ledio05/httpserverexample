package at.fhtw.httpdemo.user;

import at.fhtw.httpdemo.Handler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class UserHandler extends Handler {

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equals("POST")) {
            new RegistrationHandler().execute(exchange);
        } else if (exchange.getRequestMethod().equals("GET")) {
            new QueryUserHandler().execute(exchange);
        }
    }

}
