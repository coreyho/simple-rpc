package corey;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 * @author heankang
 */
public class Provider {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ServerSocket echoServer = null;
        Socket clientSocket;
        try {
            echoServer = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                assert echoServer != null;
                clientSocket = echoServer.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + "connect!");
                executorService.execute(new RPCThreadProcessor(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}