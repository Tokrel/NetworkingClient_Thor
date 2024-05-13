import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        Socket client = null;
        int portnumber = 50000;
        if(args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }
        for(int i = 0; i < 10; i++){
            try {
                String msg = " ";

                client = new Socket(InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created "+ client);

                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);

                InputStream clientIn = client.getInputStream();
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Skriv ditt namn. Skriv Bye för att lämna. ");
                msg = stdIn.readLine().trim();
                pw.println(msg);

                System.out.println("Meddelande från servern = "+ stdIn.readLine());

                pw.close();
                stdIn.close();
                client.close();

            }catch (IOException ie){
                System.out.println("I/O error: "+ ie);
            }
        }
    }
}
