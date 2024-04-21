import java.util.Scanner;
import java.util.Arrays;

class Process implements Comparable<Process> {
    int index;
    int id;
    boolean flag;
    boolean isActive;

    public Process(int index, int id, boolean flag, boolean isActive) {
        this.index = index;
        this.id = id;
        this.flag = flag;
        this.isActive = isActive;
    }

    @Override
    public int compareTo(Process other) {
        return this.id - other.id;
    }
}

public class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            System.out.print("Enter the number of processes (min 2, max 10): ");
            num = sc.nextInt();

            if (num > 1 && num <= 10) {
                break;
            } else {
                System.out.println("Invalid number of processes. Please enter a value between 0 and 10.");
            }
        }

        Process process[] = new Process[num];

        // Object Initalization
        for (int index = 0; index < process.length; index++) {
            System.out.print("Enter process id : ");
            int id = sc.nextInt();

            process[index] = new Process(index, id, false, true);
        }

        // Print the Process Array
        for (int j = 0; j < num; j++) {
            System.out.printf("[%d] %d\n", j, process[j].id);
        }

        // Sort based on Id
        Arrays.sort(process);

        // Set the last process as co-ordinator
        process[num - 1].isActive = false;
        System.out.printf("\nCoordinater Selected pID : %d\n", process[num - 1].id);

        while (true) {
            // Take choice from the user
            System.out.println("\n1. Election 2. Quit ");
            System.out.print("Enter your choice -> ");
            int choice = sc.nextInt();

            // Set all flags to false
            for (Process current : process) {
                current.flag = false;
            }

            switch (choice) {
                case 1:
                    System.out.print("\nEnter the process index who initialsied election : ");
                    int init = sc.nextInt();

                    int curr = init;
                    int next = init + 1;

                    int max = -1;
                    while (next != init) {
                        if (process[next].isActive && process[next].flag == false) {
                            System.out.println("pID : " + process[curr].id + " send message to pID: "
                                    + process[next].id);
                            process[next].flag = true;
                            curr = next;
                            max = Math.max(max, process[next].id);
                        }
                        next = (next + 1) % num;
                    }
                    System.out.println("\nSelected Coordinator is pID : " + max);

                    // Update the coordinator
                    for (Process current : process) {
                        if (current.id == max) {
                            current.isActive = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Program terminated ...");
                    return;
                default:
                    System.out.println("\nInvalid response\n");
                    break;
            }
        }
    }
}