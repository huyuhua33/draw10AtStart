
//*******************************************************************
//*  Network Programming - Unit 2 Simple Client and Server          *
//*  Program Name: SimpleServer2                                    *
//*  The program creates a socket and waits for request.            *
//*  2017.08.04                                                     *
//*******************************************************************
import java.net.*;
import java.io.*;
//import draw10AtStart.*;

public class SimpleServer {
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
		ServerSocket srverSocket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		InputStream inmsg = null;
		OutputStream outmsg = null;
		byte[] buf = new byte[100];
		Socket sc1 = null;
		Socket sc2 = null;
		int port = 6666;

		try {
			// Creates a server socket, bound to the specified port.
			srverSocket = new ServerSocket(port);

			System.out.println("Waiting for request ...");
			try {
				while (sc2 == null) {
					try {
						sc1 = srverSocket.accept();
						System.out.println("Player1 come in server!!");
						in = new ObjectInputStream(new BufferedInputStream(sc1.getInputStream()));
						Object obj = in.readObject();
						Player player1 = (Player) obj;
						outmsg = sc1.getOutputStream();
						String data = "Connect success\n waiting for Player2.............";
						outmsg.write(data.getBytes());

						sc2 = srverSocket.accept();
						System.out.println("Player2 come in server!!");
						in = new ObjectInputStream(new BufferedInputStream(sc2.getInputStream()));
						obj = in.readObject();
						Player player2 = (Player) obj;
						outmsg = sc2.getOutputStream();
						data = "Connect success";
						outmsg.write(data.getBytes());

						outmsg = sc1.getOutputStream();
						data = "Play2 is ready ";
						outmsg.write(data.getBytes());
					} catch (Exception e) {
						System.err.println(e);
					}

				}
			} catch (Exception e) {
				System.err.println(e);
			} finally {
				srverSocket.close();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
