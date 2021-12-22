package at.fhtw.httpdemo;

import at.fhtw.httpdemo.user.UserDto;
import at.fhtw.httpdemo.user.UserHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<UserDto> userList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Handler userHandler = new UserHandler();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/users", userHandler::handle);
        server.start();
    }

    // https://dev.to/piczmar_0/framework-less-rest-api-in-java-1jbl
}
