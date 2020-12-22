package ClientServer.Server;

//*******************************************************************
//*  Network Programming - Unit 2 Simple Client and Server          *
//*  Program Name: SimpleServer2                                    *
//*  The program creates a socket and waits for request.            *
//*  2017.08.04                                                     *
//*******************************************************************
//import draw10AtStart.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class SimpleServer implements Runnable {
	ServerSocket srverSocket = null;
	InputStream in = null;
	OutputStream out = null;
	byte[] buf = new byte[100];
	byte[] buf2 = new byte[100];
	Socket sc1 = null;
	Socket sc2 = null;
	int port = 6666;
	int round = 0;
	Boolean connected = false;
	Boolean start = false;
	String data;

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

	public SimpleServer() {
		Thread t = new Thread(this, "SimpleServer");
		try {
			srverSocket = new ServerSocket(port);
		} catch (Exception e) {
			// TODO: handle exception
		}
		t.start();
	}

	public void checkDoubleConnection() {
		while (!connected) {
			try {
				sc1 = srverSocket.accept();
				System.out.println("Player1 come in server!!");
				out = sc1.getOutputStream();
				String data = "Connect success waiting for Player2";
				out.write(data.getBytes());
				data = "N";
				out.write(data.getBytes());
				sc2 = srverSocket.accept();
				System.out.println("Player2 come in server!!");
				// in = sc2.getInputStream();
				// in.read(buf);
				out = sc2.getOutputStream();
				data = "Connect success player1 is in the game";
				out.write(data.getBytes());
				data = "Y";
				out.write(data.getBytes());

				out = sc1.getOutputStream();
				data = "Play2 is in the game ";
				out.write(data.getBytes());
				data = "Y";
				out.write(data.getBytes());
				System.out.println(sc2.isConnected());
				System.out.println(sc1.isConnected());
				connected = sc2.isConnected() && sc1.isConnected();

			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	public void gameStart() {
		try {
			System.out.println("GameStartScanning");
			do {
				in = sc1.getInputStream();
				in.read(buf);
			} while ( new String(buf).equals("GameStart") );
			System.out.println("sc1 Connected");
			in = sc2.getInputStream();
			do {
				in.read(buf);
			} while (new String(buf).equals("GameStart"));
			System.out.println("sc2 Connected");
			data = "gameStart";
			out = sc2.getOutputStream();
			out.write(data.getBytes());// 0,0 update state
			out = sc1.getOutputStream();
			out.write(data.getBytes());
			System.out.println("SC" + new String(buf));
			start = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void battleFildDataTransform() {
	

		if (connected) {// limit connection sc1 then sc2 or change to non-blocking mode
			try {
				in = sc1.getInputStream();
				in.read(buf);

				in = sc2.getInputStream();
				in.read(buf2);

				out = sc1.getOutputStream();
				out.write(buf2);

				out = sc2.getOutputStream();
				out.write(buf);

				round++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void run() {

		try {
			// Creates a server socket, bound to the specified port.
			System.out.println("Waiting for request ...");
			try {
				while (!connected) {
					checkDoubleConnection();

				}
				while (connected && !start) {
					gameStart();

				}
				while (connected && start) {
					battleFildDataTransform();
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

	public ServerSocket getSrverSocket() {
		return srverSocket;
	}

	public void setSrverSocket(ServerSocket srverSocket) {
		this.srverSocket = srverSocket;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	public byte[] getBuf() {
		return buf;
	}

	public void setBuf(byte[] buf) {
		this.buf = buf;
	}

	public byte[] getBuf2() {
		return buf2;
	}

	public void setBuf2(byte[] buf2) {
		this.buf2 = buf2;
	}

	public Socket getSc1() {
		return sc1;
	}

	public void setSc1(Socket sc1) {
		this.sc1 = sc1;
	}

	public Socket getSc2() {
		return sc2;
	}

	public void setSc2(Socket sc2) {
		this.sc2 = sc2;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
}
