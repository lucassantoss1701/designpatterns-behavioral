package designpatterns.chainresponsability;

import designpatterns.chainresponsability.middlewares.CheckPermission;
import designpatterns.chainresponsability.middlewares.CheckUserMiddleware;
import designpatterns.chainresponsability.middlewares.Middleware;
import designpatterns.chainresponsability.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void init(){
        server = new Server();
        server.registerUser("a", "a");
        server.registerUser("b", "b");

        Middleware middleware = new CheckUserMiddleware(server);
        middleware.linkWith(new CheckPermission());

        server.setMiddleware(middleware);

    }

    public static void main(String[] args) throws IOException {
        init();

        boolean done = false;

        do{
            System.out.println("Digite o email: ");
            String email = reader.readLine();
            System.out.println("Digite a senha: ");
            String password = reader.readLine();
            done = server.logIn(email, password);
        }while(!done);
    }
}
