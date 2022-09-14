/* CaesarCipherServer.java provides a Server class, with server functions that interact with the Client.
 *
 * Completed by: Justin Voss
 * Date: 04/21/2022
 ******************************************************/


import java.util.Scanner;
import java.lang.Character;
import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
import java.lang.Thread; 
import java.time.format.DateTimeFormatter; 
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalDateTime; 
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.lang.Character;
import java.net.*;
import java.io.*;

public class CaesarCipherServer extends Thread{
    private ServerSocket socket;
    private int port;
    private boolean running = false;
    
    // Much help from this website about socket programming:
    // https://www.infoworld.com/article/2853780/socket-programming-for-scalable-systems.html
    // I will refer to this website as infoworld.com

    // using infoworld.com
    public CaesarCipherServer(int port)
    {
        this.port = port;
    }

        // using infoworld.com
    public void startServer()
    {
        try
        {
            socket = new ServerSocket( port );
            this.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

        // using infoworld.com
    public void stopServer()
    {
        running = false;
        this.interrupt();
    }
// using infoworld.com
    @Override
    public void run()
    {
        running = true;
        while( running )
        {
            try
            {
                System.out.println( "Listening for a connection" );

                // Call accept() to receive the next connection
                Socket nextSocket = socket.accept();

                // Pass the socket to the RequestHandler thread for processing
                MultiThreadedServer mtServer = new MultiThreadedServer( nextSocket );
                mtServer.start();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    // using infoworld.com
    public static void main( String[] args )
    {
        if(args.length == 0){
            System.out.println("Usage: CaesarCipherServer <port>");
            System.exit(0);
        }
        int port = Integer.parseInt(args[0]);
        System.out.println( "Start server on port: " + port );
        CaesarCipherServer server = new CaesarCipherServer(port);
        server.startServer();
        // Shuts down in 1 minute

        server.stopServer();
    }
}

// help from https://www.geeksforgeeks.org/multithreaded-servers-in-java/
class MultiThreadedServer extends Thread
{
    // using infoworld.com
    private Socket socket;

    MultiThreadedServer( Socket socket )
    {
        this.socket = socket;
    }

    @Override

    public void run(){

        try{
            // message for being connected
            System.out.println(new Date().toString() + " is connected to "+ socket.getRemoteSocketAddress().toString());
            
            // using infoworld.com
            // input and output streams
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            PrintWriter out = new PrintWriter( socket.getOutputStream() );

            String line;
            line = in.readLine();
            System.out.println(line);
            //out.println(rotationNumber);
            try{
                // variables for encryption
                int rotationNumber = Integer.valueOf(line);
                int basePosition = 0;
                int newPosition = 0;
                char newCharacter = 'a';
                String message = "";
                if (rotationNumber > 0 && rotationNumber < 26) {

                    // using infoworld.com
                    out.println(rotationNumber);
                    out.flush();
                    
                    while ((line = in.readLine()) != null && !line.equals("quit"))
                    {
                       
                     // encrypt the message
                        System.out.println("Start of while loop");
                        message = ""; // clears message
                        
                        for(int i=0; i < line.length(); i++){
                            //  if lower case
                            if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z'){
                                basePosition = line.charAt(i) - 'a'; // takes base position
                                newPosition = (basePosition + rotationNumber) % 26; // New position adds the rotation. It loops around if need be
                                newCharacter = (char) ('a' + newPosition); // gets new encrypted character
                                message += newCharacter;
                            }
                            // if a space
                            else if (line.charAt(i) == ' '){
                                message += ' ';
                            }
                            // Else if uppercase
                            else {
                                basePosition = line.charAt(i) - 'A'; // takes base position
                                newPosition = (basePosition + rotationNumber) % 26; // New position adds the rotation. It loops around if need be
                                newCharacter = (char) ('A' + newPosition); // gets new encrypted character
                                message += newCharacter;
                            }
                            
                        }
                        // prints 
                        out.println(message);
                        System.out.println(message);
                        out.flush();
                    }
                }
                else{
                    out.println("Invalid number for rotation");
                }
                // closes sockets
                in.close();
                out.close();
                socket.close();
                System.out.println( "Connection closed" );
           }
            catch(NumberFormatException e){
                // catches invalid input for rotation
                in.close();
                out.close();
                socket.close();
                System.out.println( "Connection closed" );
                System.out.println( "Input has to be a number" );
            }

        }
        catch( Exception e)
        {
            System.out.println("Error: Raised exception while connecting to client ");
            //e.printStackTrace();
        }

    }

}
        
