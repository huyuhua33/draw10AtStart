
//*******************************************************************
//*  Network Programming - Unit 2 Simple Client and Server          *
//*  Program Name: SimpleClient2                                     *
//*  The program connects to server and send/receive message.       *
//*  The program gets the server IP from args[0].                   *
//*  2017.08.04                                                     *
//*******************************************************************
import java.net.*;
import java.io.*;
import java.nio.*;
import java.util.Scanner;
import draw10AtStart.*;

public class SimpleClient {
	public static byte[] intToByteArray(int value) {
		return new byte[] { (byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value };
	}

	public static int ByteToInt(byte[] buf) {
		int i, value = 0;
		for (i = 0; i < 4; i++) {
			value = value * 256 + (buf[i] & 0x7F + ((buf[i] & 0x80) >> 7) * 128);
		}
		return value;
	}

	public static void main(String args[]) {
		Socket client = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		InputStream inmsg = null;
		OutputStream outmsg = null;
		int port = 6666;
		byte[] buf = new byte[100];
		int count = 0;

		Scanner scanner = new Scanner(System.in);

		try {
			// Creates a stream socket and connects it to the specified port number
			// at the specified IP address.
			client = new Socket("127.0.0.1", port);

			// Send message to server
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

			Player player = new Player(null, null);
			out.writeObject(player);
			out.flush();
			outmsg = client.getOutputStream();

			// Read message from server
			inmsg = client.getInputStream();
			inmsg.read(buf);
			System.out.println("Receive message: " + new String(buf));

			out.close();
			in.close();

			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}