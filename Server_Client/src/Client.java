import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try{
            while(true)
            {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the first number: ");
                int number1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the second number: ");
                int number2 = scanner.nextInt();

                Socket socket = new Socket("127.0.0.1", 1080);
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(number1);
                dos.writeInt(number2);

                DataInputStream dos1 = new DataInputStream(socket.getInputStream());
                String sum = dos1.readUTF();

                System.out.println(sum);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

}