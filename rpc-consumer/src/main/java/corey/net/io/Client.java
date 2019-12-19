package corey.net.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author corey
 * @date 2019-12-19
 */
public class Client {
    public static Object callRemoteService(String host, int port, Object requestObject) {
        Object o = null;
        Socket socket;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(requestObject);
            oos.flush();
            ois = new ObjectInputStream(socket.getInputStream());
            o = ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("something wrong");
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return o;
    }
}
