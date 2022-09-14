/* CaesarCipherClient.java provides a Client class, with client functions that interact with the Server.
 *
 * Completed by: Justin Voss
 * Date: 04/21/2022
 ******************************************************/

import java.util.Scanner;
import java.lang.Character;
import java.net.*;
import java.io.*;


class CaesarCipherClient{
    public static void main(String [] args) {
        System.out.println("Welcome to Caesar Cipher Client. ");
        try {
            InetAddress hostAddress = InetAddress.getByName(args[0]);  // get address
            Integer portNumber = Integer.parseInt(args[1]);  // get port number
            Socket socket = new Socket(hostAddress, portNumber);  // socket with port number and address
            // input, output, and reader streams
            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());  
            BufferedReader in = new BufferedReader(inputStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            // input and output for taking in strings and printing strings
            String input = "";
            String output = "";

            System.out.println("Please enter a rotation number (1-25): ");
            input = reader.readLine();  // takes input 
            out.println(input);
            output = in.readLine();
            System.out.println("Reply: " + output);  // outputs rotation number

            while (true) {
            // System.out.println("Enter your message (type 'quit' to stop): ");
                input = reader.readLine();
                if (input.equals("quit"))  // if user types in quit, it quits
                    break;
                out.println(input);
                out.flush();
                output = in.readLine();
            // System.out.println("Reply: " + output);
            }
            // close streams
            in.close();
            out.close();
            reader.close();
            socket.close();
        }
        // much of the code above was able to be done because of this website:
        // https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html

        // catch exception
        catch(UnknownHostException e) {
        System.out.println("Error: Invalid address ");
        }
        catch (IOException e) {
            System.out.println("Error: Invalid port ");
        }
    }
     
}