import mpi.MPI;

public class ArrSum {
	
	public static void main(String[] args) throws Exception {
		
		MPI.Init(args);
		
		int root = 0, unitsize= 5;
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		
		int[] sendBuffer = null;
		int[] recieveBuffer = new int[5];
		int[] newRecieveBuffer = new int[size];
		
		
		if(root == rank) {
			int totalSize = unitsize * size;
			sendBuffer = new int[totalSize];
			for(int i = 0; i < totalSize; i++) {
				sendBuffer[i] = i;
				System.out.println("Elements " + i + "\t : " + i );
			}
		}
		
		MPI.COMM_WORLD.Scatter(sendBuffer, 0, unitsize, MPI.INT, recieveBuffer, 0, unitsize, MPI.INT, root);
		
		int sum = 0;
		for (int i = 0; i < unitsize; i++) {
			sum += recieveBuffer[i];
		}
		System.out.println("Intermidiate Sum : " + sum);
		
		MPI.COMM_WORLD.Gather(new int[]{sum}, 0, 1, MPI.INT, newRecieveBuffer, 0, 1, MPI.INT, root);
		
		if ( root == rank ) {
			int totalSum = 0;
			for(int i = 0; i < size; i++) {
				totalSum = newRecieveBuffer[i];
			}
			System.out.println("Final Sum : " + totalSum);
		}
		
		MPI.Finalize();
	}
}
