import java.util.Scanner;
import java.util.InputMismatchException;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nodes, sender, reciever, data;

        System.out.print("Enter the number of nodes : ");
        nodes = sc.nextInt();
        
        // Print the nodes
        for (int i = 0; i < nodes; i++) {
            System.out.print(i + " ");
        }
        System.out.println("0");

        // Take Data
        int choice = 1;
        while (choice == 1) {
            System.out.print("Enter the Sender : ");
            sender = sc.nextInt();
            System.out.print("Enter the Reciever : ");
            reciever = sc.nextInt();
            System.out.print("Enter your Data : ");
            data = sc.nextInt();

            // Print Data passing
            System.out.printf("Sender : %d sending Data : %d\n", sender, data);
            for (int i = sender + 1; i != reciever; i = (i + 1) % nodes) {
                System.out.printf("Data : %d forwarded by %d\n", data, i);
            }
            System.out.printf("Reciever : %d recieved Data : %d\n\n", reciever, data);

            while (choice != 2) {
                try {
                    System.out.print("Do you want to retry? 1. Yes 2. No \nEnter -> ");
                    choice = sc.nextInt();
                    if (choice != 1) {
                        System.out.println("Invalid Input!");
                    }
                } catch (InputMismatchException ie) {
                    System.err.println("Invalid Input! Please enter a valid integer.");
                    sc.next();
                }
            }

        }
        sc.close();
    }
}