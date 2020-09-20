/*
	Name:		Yash D. Gandhi
	Roll No.:	45017	
	Assignment:	2
	
	To develop any distributed application using Message Passing Interface(MPI). 
*/
import mpi.MPI;
import java.util.*;
import java.lang.*;

public class MPJStrrev {
	public static void main(String args[]) {
		// Initialize MPI execution environment
		MPI.Init(args);
		// Get the id of the process
		int rank = MPI.COMM_WORLD.Rank();
		// total number of processes is stored in size
		int size = MPI.COMM_WORLD.Size();
		int root = 0;
		// array which will be filled with data by root process
		String sendbuf[];

		sendbuf = new String[size];

		// creates data to be scattered
		if (rank == root) {
			sendbuf[0] = "rolls";
			sendbuf[1] = "royce";
			sendbuf[2] = "is";
			sendbuf[3] = "a dream car";

			// print current process number
			System.out.print("Processor " + rank + " has data: ");
			for (int i = 0; i < size; i++) {
				System.out.print(sendbuf[i] + " ");
			}
			System.out.println();
		}
		// collect data in recvbuf
		String recvbuf[] = new String[1];

		// following are the args of Scatter method
		// send, offset, chunk_count, chunk_data_type, recv, offset, chunk_count,
		// chunk_data_type, root_process_id
		MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.OBJECT, recvbuf, 0, 1, MPI.OBJECT, root);
		System.out.println("Processor " + rank + " has data: " + recvbuf[0]);
		System.out.println("Processor " + rank + " is reversing string");
		
		StringBuilder d2 = new StringBuilder();
        d2.append(recvbuf[0]);
        d2 = d2.reverse();
		recvbuf[0] = String.valueOf(d2);
		// following are the args of Gather method
		// Object sendbuf, int sendoffset, int sendcount, Datatype sendtype,
		// Object recvbuf, int recvoffset, int recvcount, Datatype recvtype,
		// int root)
		MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.OBJECT, sendbuf, 0, 1, MPI.OBJECT, root);
		// display the gathered result
		if (rank == root) {
			System.out.println("Process 0 has data: ");
			for (int i = 0; i < 4; i++) {
				System.out.print(sendbuf[i] + " ");
			}
		}
		// Terminate MPI execution environment
		MPI.Finalize();
	}
}
/*

				++ OUTPUT++				
				
	D:\Codes\DCS CODES\DCS Final codes\2> export MPJ_HOME=D:\Software\mpj-v0_44
	D:\Codes\DCS CODES\DCS Final codes\2> javac -cp $MPJ_HOME/lib/mpj.jar MPJStrrev.java
	D:\Codes\DCS CODES\DCS Final codes\2> $MPJ_HOME/bin/mpjrun.sh -np 4 MPJStrrev


	MPJ Express (0.44) is started in the multicore configuration
	Processor 0 has data: rolls royce is a dream car
	Processor 0 has data: rolls
	Processor 0 is reversing string
	Processor 1 has data: royce
	Processor 1 is reversing string
	Processor 3 has data: is
	Processor 3 is reversing string
	Processor 2 has data: a dream car
	Processor 2 is reversing string
	Process 0 has data: 
	sllor ecyor si a meard rac

*/
