package at.fhtw.httpdemo.user;

import at.fhtw.httpdemo.Application;
import at.fhtw.httpdemo.Handler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class RegistrationHandler extends Handler {

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        UserRequest userRequest = readRequest(exchange.getRequestBody(), UserRequest.class);

        System.out.println("userRequest: " + userRequest);

        // create user... (DAO)
        UserDto userDto = new UserDto();
        userDto.setUsername(userRequest.getUsername());
        userDto.setPassword(userRequest.getPassword());
        Application.userList.add(userDto);

//        exchange.getResponseHeaders().set(CONTENT_TYPE, APPLICATION_JSON);
        exchange.sendResponseHeaders(UserHandler.StatusCode.CREATED.getCode(), 0);

        byte[] response = new byte[0];

        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response);
        responseBody.close();

    }
}
