import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String []args) {


        try{

            while(true){
                ServerSocket serverSocket = new ServerSocket(1080);
                Socket cn = serverSocket.accept();
                try{
                    System.out.println("Listening... ");
                    DataInputStream dis = new DataInputStream(cn.getInputStream());
                    int number1 = dis.readInt();
                    int number2 = dis.readInt();

                    PrintWriter pr = new PrintWriter(cn.getOutputStream(),true);
                    int sum=number1+number2 ;

                    DataOutputStream dos = new DataOutputStream(cn.getOutputStream());

                    dos.writeUTF("The sum of the two numbers is :"+sum);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    cn.close();
                    serverSocket.close();
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}