import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MiddleserverRouter {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException{

        ArrayList<clientside_Thread> clientside_Array = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        System.out.print("\n Its the Middle Server \n");
        System.out.print("\n Kindly put Port number for connection: ");
        int port_num = Integer.parseInt( br.readLine());
        ServerSocket client_listener = new ServerSocket(port_num);

        Socket client_socket = null;

        String[] routes=null;

        int digit = 1;
        try{
            while (digit!=0) {
                System.out.println("Please go and start to connect the client with middle server\n");
                client_socket = client_listener.accept();
                System.out.println("Now, Middle Server Client Connected with the client\n");
                clientside_Thread clientthread = new clientside_Thread(client_socket);
                PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
                clientside_Array.add(clientthread);
                out.println(digit);
                out.println("This is Router R"+(clientside_Array.indexOf(clientthread)+1));
                executor.execute(clientthread);
                digit--;
                client_listener.close();
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(digit+1 +" -"+ "Clients are in connection with the midde server\n");

   

 }

}

class clientside_Thread implements Runnable{
    Socket client_socket;
    BufferedReader in;
    PrintWriter out;
  

    public clientside_Thread(Socket client_socket) throws IOException{
        this.client_socket = client_socket;
        in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
        out = new PrintWriter(client_socket.getOutputStream(), true);
    }
    public void run(){
        try{
            File file = new File("C:/Users/hanis/Desktop/Hanisha Patel AOS PROJECT 1/userList.txt");
            Scanner scan = new Scanner(file);
            
            while(true){
                
                String username = in.readLine();
                String password = in.readLine();
                System.out.println("Client Username -  "+ username + "  " + "Client password- " + password);
                
                String line = scan.nextLine();
                
                while(true){
                    String[] arrayofstring = line.split(" ");
                    
                    if(username.equals(arrayofstring[0]))
                    {
                        if(password.equals(arrayofstring[1]))
                        {
                            
                            System.out.println("Now, Client sucessfully login with all credentials validates");
                            out.println("Now, Client sucessfully login with all credentials validates");
                            out.println(arrayofstring[2]);
                            out.println(arrayofstring[3]);
                          
                        }                            
                    }
                    
                    line = scan.nextLine();
                    if(line.equals(" "))
                    {
                        break;
                    }

                }
              
    
                
            } 
            
        }
        catch(Exception e){
        }
        finally{
            try{
                client_socket.close();
            }
            catch(Exception e){

            }
        }
    }
}
