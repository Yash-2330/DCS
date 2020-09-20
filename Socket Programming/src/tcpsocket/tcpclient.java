/**
 * 
 */
package tcpsocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
/**
 * @author C30
 *
 */
public class tcpclient {

	
	public static void main(String[] args) throws Exception {
	
		String ip = "localhost";
		int port =  9999; // 0-1023 -> reserved, 1024 to 65535 can be used
		Socket s = new Socket(ip,port);
		
		String str = "Hi my name is Yash";
		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw = new PrintWriter(os);
		pw.println(str);
		pw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str1 = br.readLine();
		
		System.out.println("C : Data received from Server : " + str1);
		
		pw.close();
		s.close();
		
	}

}
