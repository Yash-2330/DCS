/**
 * 
 */
package socketudp;

import java.net.*;

/**
 * @author C30
 *
 */

public class udpclient {

	public static void main(String[] args) throws Exception 
	{
		// Socket is used to send data and Packet is used to receive data 
		DatagramSocket ds = new DatagramSocket();
		
		// this part is to send data to server on port 9999, any available port can be used
		int i = 8;
		byte[] b = String.valueOf(i).getBytes();  // udp socket accepts only byte format data so convert int to byte 
		
		InetAddress ia = InetAddress.getLocalHost(); // get ip address of the machine 
		DatagramPacket dp = new DatagramPacket(b,b.length,ia,9999); // 4 args - data, data length, ip addr, port number
		ds.send(dp);
		
		// receive data from server
		byte[] b1 = new byte[1024];
		DatagramPacket dp1 = new DatagramPacket(b1, b1.length); // 2 args - buffer which will receive data from server and the length of the buffer 
		ds.receive(dp1);
		
		String str = new String(dp1.getData(),0,dp1.getLength());
		System.out.println("The result is: " + str);
	}

}
