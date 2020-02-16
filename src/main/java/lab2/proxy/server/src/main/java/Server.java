import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(5555);
             Socket socket = serverSocket.accept();
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
            outputStream.writeDouble(multiply(inputStream.readDouble(), inputStream.readDouble()));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

}
