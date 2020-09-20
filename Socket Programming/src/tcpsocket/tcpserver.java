package tcpsocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpserver {

	public static void main(String[] args) throws Exception {
		
		System.out.println("S: Server is now running....");
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("S : Server is waiting for Client request...");
		Socket s = ss.accept();
		System.out.println("S : Server is now connected with the Client");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine();
		System.out.println("S : Data received from Client: " + str);
		
		String str1 = str.toUpperCase();
		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw = new PrintWriter(os);
		pw.println(str1);
		pw.flush();
		System.out.println("S : Data sent to Client after completion of operation...");
		
		pw.close();
		s.close();
		
	}

}
