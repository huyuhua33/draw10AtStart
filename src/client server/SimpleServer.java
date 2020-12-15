
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
	public static void main(String args[])
	{
		ServerSocket			srverSocket = null;
		InputStream				in = null;
		OutputStream			out = null;
		byte []					buf = new byte[100];
		byte []    				buf2 = new byte[100];
		Socket					sc1 = null;
		Socket         			sc2 = null;
		int						port = 6666;
		int                  	round = 0; 



		try {
			// Creates a server socket, bound to the specified port.
			srverSocket = new ServerSocket(port);

			System.out.println("Waiting for request ...");
			try
			{
				while(true)
				{
					
					sc1 = srverSocket.accept();
					System.out.println("Player1 come in server!!");
					//in = sc1.getInputStream(); 
					//in.read(buf);
					out = sc1.getOutputStream();
					String data = "Connect success\n waiting for Player2";
					out.write(data.getBytes());
					data = "N";
					out.write(data.getBytes());

					sc2 = srverSocket.accept();
					System.out.println("Player2 come in server!!");
					//in = sc2.getInputStream();
					//in.read(buf); 
					out = sc2.getOutputStream();
					data = "Connect success\n player1 is in the game";
					out.write(data.getBytes());
					data = "Y";
					out.write(data.getBytes());


					out = sc1.getOutputStream();
					data = "Play2 is in the game ";
					out.write(data.getBytes());
					data = "Y";
					out.write(data.getBytes());


					
					in = sc1.getInputStream(); 
					in.read(buf);
					String datas = new String(buf);
					String[] tokens = datas.split("/");
					System.out.println(tokens[4]);
					out = sc1.getOutputStream();
					out.write(buf);

					/in = sc2.getInputStream(); 
					in.read(buf2);
					datas = new String(buf);
					tokens = datas.split("/");
					System.out.println(tokens[4]);
					out = sc2.getOutputStream();
					out.write(buf2);
					round++;
				}

			}
			catch(IOException e)
			{
				System.err.println(e);
			}
			finally
			{
				srverSocket.close();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
