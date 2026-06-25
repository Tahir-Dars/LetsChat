import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Socket socket;

    public Server(Socket socket) {
        try {
            this.socket = socket;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void main() {
        try (ServerSocket serverSocket = new ServerSocket(2003);) {
            while (true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
