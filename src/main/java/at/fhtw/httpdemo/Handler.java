package at.fhtw.httpdemo;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;

public abstract class Handler {

    public void handle(HttpExchange exchange) {
        try {
            execute(exchange);
            exchange.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract protected void execute(HttpExchange exchange) throws IOException;

    protected <T> T readRequest(InputStream is, Class<T> type) throws IOException {
        return new ObjectMapper().readValue(is, type);
    }

    protected <T> byte[] writeResponse(T response) throws IOException {
        return new ObjectMapper().writeValueAsBytes(response);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper;
    }
    public static enum StatusCode {
        CREATED(201), OK(200);

        final int code;
        StatusCode(int code) {
            this.code=code;
        }

        public int getCode() {
            return code;
        }
    }

}
