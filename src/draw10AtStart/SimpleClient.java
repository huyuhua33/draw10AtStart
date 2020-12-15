
//*******************************************************************
//*  Network Programming - Unit 2 Simple Client and Server          *
//*  Program Name: SimpleClient2                                     *
//*  The program connects to server and send/receive message.       *
//*  The program gets the server IP from args[0].                   *
//*  2017.08.04                                                     *
//*******************************************************************
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient implements Runnable {
	Socket client = null;
	InputStream in = null;
	OutputStream out = null;
	int port = 6666;
	byte[] buf = new byte[100];
	String data;
	Boolean connected = true;

	public SimpleClient() {
		Thread t = new Thread(this, "SimpleClient");
		try {
			client = new Socket("127.0.0.1", port);
			checkDoubleConnection();
			connected = false;
		} catch (Exception e) {
			System.err.println(e);
		}
		t.start();
	}

	private byte[] intToByteArray(int value) {
		return new byte[] { (byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value };
	}

	private int ByteToInt(byte[] buf) {
		int i, value = 0;
		for (i = 0; i < 4; i++) {
			value = value * 256 + (buf[i] & 0x7F + ((buf[i] & 0x80) >> 7) * 128);
		}
		return value;
	}

	public void checkDoubleConnection() {
		try {
			in = client.getInputStream();
			in.read(buf);
		} catch (Exception e) {
			System.err.println(e);
		}
		while (buf != null) {
			try {
				// Send message to server
				in.read(buf);
				System.out.println("Receive message: " + new String(buf));

				if (new String(buf).indexOf("Y") != 0) {
					System.out.println("Y");
					connected = true;
					break;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

	public String battleFildDataTransform(String d) {
		data = d;
		if (connected) {
			try {
				out = client.getOutputStream();
				out.write(data.getBytes());
				in = client.getInputStream();
				in.read(buf);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return new String(buf);
	}

	public void endOfConnection() {
		try {
			in.close();
			out.close();
			client.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void run() {

	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public byte[] getBuf() {
		return buf;
	}

	public void setBuf(byte[] buf) {
		this.buf = buf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
}