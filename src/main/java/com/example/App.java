package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String stringaServer;
            do{
                System.out.println("inserisci testo: ");
                String st = in.readLine();
                out.writeBytes(st + '\n');
                stringaServer = inServ.readLine();
                if (stringaServer.equals("u"))
                {
                    System.out.println("server chiuso correttamente");
                    
                }
                if (stringaServer.equals("lista"+"\n"))
                {
                    System.out.println(in.readLine());
                } 
                else{
                    System.out.println("nota aggiunta");
                }
            }while(!stringaServer.equals("u"));
                
                s.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante la comunicazione!");
            System.exit(1);
        }
    }
}
