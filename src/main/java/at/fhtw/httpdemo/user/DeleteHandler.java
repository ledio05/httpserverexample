package at.fhtw.httpdemo.user;

import at.fhtw.httpdemo.Handler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DeleteHandler extends Handler {

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        throw new UnsupportedOperationException();
    }
}
