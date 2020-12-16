/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

/**
 *
 * @author Ala Hamadi
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;
    
    
    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
        
        
        int n = Integer.parseInt(str);
        
        
        for(int i=1;i<=n;i++){
            int ok=0;
            for (int j=2;j<=i-1;j++){
                if(i%j==0){
                    ok=1;
                    break;
                }
            }
            if(ok==0)
                System.out.println(i);
        }
            


        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}