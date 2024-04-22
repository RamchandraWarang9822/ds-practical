import java.util.*;

public class BullyToken {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of process : ");
		int num = sc.nextInt();

		Process[] process = new Process[num];

		// Initiate all the process
		for (int i = 0; i < process.length; i++) {
			System.out.print("Enter the process id : ");
			int id = sc.nextInt();
			process[i] = new Process(i, id, true);
		}

		// Sort the Process according to ID
		Arrays.sort(process);

		// First Coordinator Selection
		process[num - 1].isActive = false;
		System.out.println("\nSelected Coordinator Process ID : " + process[num - 1].id);

		while (true) {
			// Print the Array
			System.out.println("\n[Index] : {Process ID}");
			for (int index = 0; index < num; index++) {
				String status = (process[index].isActive) ? "Active" : "Not Active";
				System.out.printf("[%d] : {%d} is %s\n", index, process[index].id, status);
			}

			System.out.println("\n1. Election 2. Quit -> ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:

					System.out.println("\nWho initiates election ? : ");
					int init = sc.nextInt();

					for (int sender = init; sender < num && process[sender].isActive; sender++) {
						int messRecieved = 0;

						System.out.println("\nCurrent Sender ID: " + process[sender].id);
						for (int reciever = sender + 1; reciever < num; reciever++) {
							System.out.print(process[sender].id + "----->" + process[reciever].id + " : ");
							if (process[reciever].isActive) {
								System.out.println("OK");
								messRecieved++;
							} else {
								System.out.println("No reply");
							}
						}

						if (messRecieved == 0) {
							System.out.println("\nSelected coordinator process id : " + process[sender].id);
							process[sender].isActive = false;
						}
					}

					break;
				case 2:
					System.out.println("Program Terminated!");
					sc.close();
					return;
				default:
					System.err.println("Invalid Input");
					break;
			}
		}

	}

}

class Process implements Comparable<Process> {
	int index;
	int id;
	boolean isActive;

	public Process(int index, int id, boolean isActive) {
		this.index = index;
		this.id = id;
		this.isActive = isActive;
	}

	@Override
	public int compareTo(Process other) {
		return this.id - other.id;
	}

}