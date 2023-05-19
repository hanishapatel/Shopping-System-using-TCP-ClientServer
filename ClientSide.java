import java.io.*;
import java.net.*;
import java.util.*;


import java.net.InetAddress;

public class ClientSide {

    public static String router_number = "";
    public static ArrayList<String> temp = new ArrayList<>();
    public static void main(String args[]) throws IOException{


        InetAddress address= InetAddress.getLocalHost();
        Socket socket = new Socket(address,14866);
        System.out.println("Here this client is successfully connected to the server");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        

        String No_of_routers="";
        Boolean cond = true;
        while(cond == true){
            String readline = in.readLine();
            if (readline.equals("quit")) break;
            if(readline.split(" ").length<15){
                No_of_routers = readline;
            }
            else {
                router_number = readline.split(" ")[15];
                System.out.println(readline);
            }
            cond = false;
        }

       
        System.out.println(in.readLine());

        System.out.println("Put your's Username: \n");
        String username_value = br.readLine();
                
                
        System.out.println("Put your's Password: \n");
        String password_value = br.readLine();
        out.println(username_value);
        out.println(password_value);

        String readline2 = in.readLine();
        System.out.println("Server transgered Message is : "+ readline2);


        String groupPlan = in.readLine();
        System.out.println("This user is the part of"+" "+ groupPlan + "Group\n");

        String user_Credits = in.readLine();
        
        System.out.println("User have" + user_Credits + "Credit available");

        int User_points =Integer.parseInt(user_Credits);
        

        if(groupPlan.equals("Platinum"))
        {
            Socket plat_socket = new Socket(address,11);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in1 = new BufferedReader(new InputStreamReader(plat_socket.getInputStream()));
            PrintWriter out1 = new PrintWriter(plat_socket.getOutputStream(), true);

            System.out.println("User is now connected with Platinum Server" );
        
            out1.println("User is now connected with Platinum Server");

    
            String product =  in1.readLine();
            String[] array_Of_String = product.split(",");
            System.out.println("product includes as follows-\n");
            for (int i = 0; i < array_Of_String.length; i++){
                System.out.println(array_Of_String[i]);
    
            }
            String Products_price =  in1.readLine();
            String[] arrOfStr_price = Products_price.split(",");
            System.out.println("Prices of products are as follows-");
            for (int i = 0; i < arrOfStr_price.length; i++){
                System.out.println(arrOfStr_price[i]);
    
            }
        
            String Product_quantity =  in1.readLine();
            String[] arrOfStr_quantity = Product_quantity.split(",");
            System.out.println("Product Quantity of the products are as follows-");
            for (int i = 0; i < arrOfStr_quantity.length; i++){
                System.out.println(arrOfStr_quantity[i]);
    
            }

        
            System.out.println("Please pick one of the product");
            String selected_item = br.readLine();

            if(selected_item.equals(array_Of_String[0]))
            {
                int Product_price =Integer.parseInt(arrOfStr_price[0]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-Product_price) );
            }
            else if (selected_item.equals(array_Of_String[1]))
            {
                int price_amnt2 =Integer.parseInt(arrOfStr_price[1]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt2) );;

            }
            else if (selected_item.equals(array_Of_String[2]))
            {
                int price_amnt3 =Integer.parseInt(arrOfStr_price[2]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt3) ); 
            }
            else if (selected_item.equals(array_Of_String[3]))
            {
                int price_amnt4 =Integer.parseInt(arrOfStr_price[3]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt4) );
            }
            else if (selected_item.equals(array_Of_String[4]))
            {
                int price_amnt5 =Integer.parseInt(arrOfStr_price[4]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt5) );
            }
            else if (selected_item.equals(array_Of_String[5]))
            {
                int price_amnt6 =Integer.parseInt(arrOfStr_price[5]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt6) );
            }


    
        }
        else if (groupPlan.equals("Gold"))
        {
            Socket gold_socket = new Socket(address,12);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in2 = new BufferedReader(new InputStreamReader(gold_socket.getInputStream()));
            PrintWriter out2 = new PrintWriter(gold_socket.getOutputStream(), true);

            System.out.println(" User is now connected with Gold Server" );
            
            out2.println("User is now connected with Gold Server");

            String products =  in2.readLine();
            String[] array_Of_String = products.split(",");
            System.out.println("products are as follows-");
            for (int i = 0; i < array_Of_String.length; i++){
               
                System.out.println(array_Of_String[i]+",");
    
            }
            
            String Products_price =  in2.readLine();
            String[] array_Of_String_price = Products_price.split(",");
            System.out.println("Prices of products are as follows-");
            for (int i = 0; i < array_Of_String_price.length; i++){
               
                System.out.println(array_Of_String_price[i]+",");
    
            }
           
           

            String Products_quantity =  in2.readLine();
            String[] array_Of_String_quant = Products_quantity.split(",");
            System.out.println("Quantity of each respective item :");
            for (int i = 0; i < array_Of_String_quant.length; i++){
               
                System.out.println(array_Of_String_quant[i]+",");
    
            }

            System.out.println("Please pick one of the product-\n");
            String choose_item = br.readLine();

            if(choose_item.equals(array_Of_String[0]))
            {
                int price_amnt1 =Integer.parseInt(array_Of_String_price[0]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt1) );
            }
            else if (choose_item.equals(array_Of_String[1]))
            {
                int price_amnt2 =Integer.parseInt(array_Of_String_price[1]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt2) );;

            }
            else if (choose_item.equals(array_Of_String[2]))
            {
                int price_amnt3 =Integer.parseInt(array_Of_String_price[2]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt3) ); 
            }
            else if (choose_item.equals(array_Of_String[3]))
            {
                int price_amnt4 =Integer.parseInt(array_Of_String_price[3]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt4) );
            }
            else if (choose_item.equals(array_Of_String[4]))
            {
                int price_amnt5 =Integer.parseInt(array_Of_String_price[4]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt5) );
            }
            else if (choose_item.equals(array_Of_String[5]))
            {
                int price_amnt6 =Integer.parseInt(array_Of_String_price[5]); 
                System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt6) );
            }
           
            

        }
        else
        {
            try (Socket silver_socket3 = new Socket(address,13)) {
                BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

                BufferedReader in3 = new BufferedReader(new InputStreamReader(silver_socket3.getInputStream()));
                PrintWriter out3 = new PrintWriter(silver_socket3.getOutputStream(), true);

                
                System.out.println("User is now connected Silver Server" );
                
                out3.println("User is now connected Silver Server");
                
                String products =  in3.readLine();
                String[] array_Of_String = products.split(",");
                System.out.println("Items are: ");
                for (int i = 0; i < array_Of_String.length; i++){
                   
                    System.out.println(array_Of_String[i]+",");
   
                }
               
                String products_price =  in3.readLine();
                String[] array_Of_String_price = products_price.split(",");
                System.out.println("Prices of each respective item: ");
                for (int i = 0; i < array_Of_String_price.length; i++){
                   
                    System.out.println(array_Of_String_price[i]+",");
   
                }
               
                String product_quantity =  in3.readLine();
                String[] array_Of_String_quant = product_quantity.split(",");
                System.out.println("Quantity of each respective item :");
                for (int i = 0; i < array_Of_String_quant.length; i++){
                   
                    System.out.println(array_Of_String_quant[i]+",");
   
                }

                
                System.out.println("Please pick one of the product-\n");
                String choose_item = br.readLine();

                if(choose_item.equals(array_Of_String[0]))
                {
                    int price_amnt1 =Integer.parseInt(array_Of_String_price[0]); 
                    System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt1) );
                }
                else if (choose_item.equals(array_Of_String[1]))
                {
                    int price_amnt2 =Integer.parseInt(array_Of_String_price[1]); 
                    System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt2) );;
    
                }
                else if (choose_item.equals(array_Of_String[2]))
                {
                    int price_amnt3 =Integer.parseInt(array_Of_String_price[2]); 
                    System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt3) ); 
                }
                else if (choose_item.equals(array_Of_String[3]))
                {
                    int price_amnt4 =Integer.parseInt(array_Of_String_price[3]); 
                    System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt4) );
                }
                else if (choose_item.equals(array_Of_String[4]))
                {
                    int price_amnt5 =Integer.parseInt(array_Of_String_price[4]); 
                    System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt5) );
                }
                else if (choose_item.equals(array_Of_String[5]))
                {
                    int price_amnt6 =Integer.parseInt(array_Of_String_price[5]); 
                    System.out.println("Due Credits points of the user is now-"+ (User_points-price_amnt6) );
                }
               
            }

        }
        
      

        try{
            socket.close();
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

    
                
                  
}
