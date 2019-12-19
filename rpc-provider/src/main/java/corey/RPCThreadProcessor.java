package corey;

import corey.dispatch.ServiceDispatch;

import java.io.*;
import java.net.Socket;

/**
 * @author corey
 * @date 2019-12-19
 */
public class RPCThreadProcessor implements Runnable {
    private Socket socket;

    RPCThreadProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            Object requestObject = ois.readObject();
            Object oo = ServiceDispatch.dispatch(requestObject);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(oo);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
