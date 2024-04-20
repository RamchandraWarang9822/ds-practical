import java.rmi.*;
import java.util.Scanner;

public class Client {

   public static void main(String[] args) {
      try {
         Scanner sc = new Scanner(System.in);

         // Get Two strings to concatinate from the user
         System.out.println("Enter the First String : ");
         String string1 = sc.nextLine();
         System.out.println("Enter the First String : ");
         String string2 = sc.nextLine();

         ServerInterface si = (ServerInterface) Naming.lookup("rmi://localhost/Server");
         System.out.println(si.concat(string1, string2));
         
         sc.close();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

   }

}
