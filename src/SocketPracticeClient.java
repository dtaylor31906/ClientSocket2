/**
 * Created by Nova on 1/31/2017.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class SocketPracticeClient
{

   public static void main(String[] args)
   {
       Socket clientSocket = null;
       DataOutputStream outputStream = null;
       DataInputStream inputStream = null;

       try {
           clientSocket = new Socket("NovaMasterMachine", 3333);
           outputStream = new DataOutputStream(clientSocket.getOutputStream());
           inputStream = new DataInputStream(clientSocket.getInputStream());
           String message = "Whats up socket world!\n" +
                   "I've come to master you!";
           outputStream.writeUTF(message);
           TimeUnit.SECONDS.sleep(1);
           String response = inputStream.readUTF();

           System.out.println("You: "+message+"\nServer: " + response);
           if (response.indexOf("Ok") != -1)
               outputStream.close();

           inputStream.close();
           clientSocket.close();
       }

           catch (UnknownHostException e)
           {
               System.err.println("Trying to connect to unknown host: " + e);
           }
           catch (IOException e)
           {
               System.err.println("IOException:  " + e);
           } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }


}

