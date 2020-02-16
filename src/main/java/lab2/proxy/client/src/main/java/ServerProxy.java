import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerProxy {

    public ServerProxy() {

    }

    public double multiply(double number1, double number2) {
        try (Socket socket = new Socket("localhost", 5555);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeDouble(number1);
            outputStream.writeDouble(number2);
            outputStream.flush();
            return inputStream.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.NaN;
    }

}
