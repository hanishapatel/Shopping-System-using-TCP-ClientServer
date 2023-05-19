import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class GroupServer extends Thread {

    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int opt1 = 0; 
        int opt2 = 0; 
        int opt3 = 0; 
    
        System.out.print("\n\n This is the TCP Group Server Side \n");

        ArrayList<Plat_servThread> Plat_servArr = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ServerSocket Plat_listener = new ServerSocket(11);
        opt1 = 1;
        Socket Platinum_socket = null;
        if(opt1 == 1)
        {

            Platinum_socket = Plat_listener.accept();
            System.out.println("Its the Platinum Server\n");
            Plat_servThread Platinumserverthread = new Plat_servThread(Platinum_socket);
            PrintWriter Platinum_out = new PrintWriter(Platinum_socket.getOutputStream(), true);
            Plat_servArr.add(Platinumserverthread);
            executor.execute(Platinumserverthread);  
            Plat_listener.close();
        }

        
        ArrayList<GoldserverThread> GoldserverArr = new ArrayList<>();
        ExecutorService executor2 = Executors.newFixedThreadPool(10);
        ServerSocket Gold_listener = new ServerSocket(12);
        opt2 = 2;
        Socket Gold_socket = null;
        if(opt2 == 2)
        {

            Gold_socket = Gold_listener.accept();
            System.out.println("Gold Server\n");
            GoldserverThread Goldserverthread = new GoldserverThread(Gold_socket);
            PrintWriter Gold_out = new PrintWriter(Gold_socket.getOutputStream(), true);
            GoldserverArr.add(Goldserverthread);
            executor2.execute(Goldserverthread); 
            Gold_listener.close();
        }

     
        ArrayList<SilverserverThread> SilverserverArr = new ArrayList<>();
        ExecutorService executor3 = Executors.newFixedThreadPool(10);
        ServerSocket silver_listener = new ServerSocket(13);
        opt3 = 3;
        Socket Silver_socket = null;
        if(opt3 == 3)
        {
            Silver_socket = silver_listener.accept();
            System.out.println("Silver Server\n");
            SilverserverThread Silverserverthread = new SilverserverThread(Silver_socket);
            PrintWriter Silver_out = new PrintWriter(Silver_socket.getOutputStream(), true);
            SilverserverArr.add(Silverserverthread);
            executor3.execute(Silverserverthread); 
            silver_listener.close();      

        }

        
        
      
}


       
}

class Plat_servThread implements Runnable{
    Socket Platinum_socket;
    BufferedReader in;
    PrintWriter out;

    public Plat_servThread(Socket Platinum_socket) throws IOException{
        this.Platinum_socket = Platinum_socket;
        in = new BufferedReader(new InputStreamReader(Platinum_socket.getInputStream()));
        out = new PrintWriter(Platinum_socket.getOutputStream(), true);
    }
    public void run(){
        try
        {
            int dig = 1;
            while(dig!=0){
                String read_line = in.readLine();
                System.out.println(read_line);
                
                
            
            
                String[] products = {"chair","table","microwave","fridge","cooker","mixer"};
                String product = String.join(",", products);
                out.println(product);

                String[] products_prices = {"240","400","550","560","600","750"};
                String product_prices = String.join(",", products_prices);
                out.println(product_prices);


                String[] products_quantity = {"15","6","13","45","18","24"};
                String product_quantity = String.join(",", products_quantity);
                out.println(product_quantity);

                String read_line2 = in.readLine();
                System.out.println(read_line2);
                
                     
                dig--;

    
            }
        }
        
        catch(Exception e){
            
        }
        finally{
            try{
                Platinum_socket.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        }
    }


// Gold Group server Thread class - To recieve the messages from the Middle server side.
class GoldserverThread implements Runnable{
    Socket Gold_socket;
    BufferedReader in;
    PrintWriter out;

    public GoldserverThread(Socket Gold_socket) throws IOException{
        this.Gold_socket = Gold_socket;
        in = new BufferedReader(new InputStreamReader(Gold_socket.getInputStream()));
        out = new PrintWriter(Gold_socket.getOutputStream(), true);
    }
    public void run(){
        try
        {
            int dig = 1;
            while(dig!=0){
                String read_line = in.readLine();
                System.out.println(read_line);

                
                
                
                String[] products = {"chair","table","microwave","fridge","cooker","mixer"};
                String product = String.join(",", products);
                out.println(product);

                String[] products_prices = {"240","400","550","560","600","750"};
                String product_prices = String.join(",", products_prices);
                out.println(product_prices);


                String[] products_quantity = {"15","6","13","45","18","24"};
                String product_quantity = String.join(",", products_quantity);
                out.println(product_quantity);

                String read_line2 = in.readLine();
                System.out.println(read_line2);
                dig--;
    
            }
        }
        
        catch(Exception e){
            
        }
        finally{
            try{
                Gold_socket.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        }
    }



// Silver Group server Thread class - To recieve the messages from the Middle server side.
class SilverserverThread implements Runnable{
    Socket Silver_socket;
    BufferedReader in;
    PrintWriter out;
    



    public SilverserverThread(Socket Silver_socket) throws IOException{
        this.Silver_socket = Silver_socket;
        in = new BufferedReader(new InputStreamReader(Silver_socket.getInputStream()));
        out = new PrintWriter(Silver_socket.getOutputStream(), true);
    }
    public void run(){
        try
        {
            int dig = 1;
            while(dig!=0){
                String read_line = in.readLine();
                System.out.println(read_line);

                String[] products = {"chair","table","microwave","fridge","cooker","mixer"};
                String product = String.join(",", products);
                out.println(product);

                String[] products_prices = {"240","400","550","560","600","750"};
                String product_prices = String.join(",", products_prices);
                out.println(product_prices);


                String[] products_quantity = {"15","6","13","45","18","24"};
                String product_quantity = String.join(",", products_quantity);
                out.println(product_quantity);

                String readline2 = in.readLine();
                System.out.println(readline2);
                
                dig--;
    
            }
        }
        
        catch(Exception e){
            
        }
        finally{
            try{
                Silver_socket.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        }
    }




   
    


