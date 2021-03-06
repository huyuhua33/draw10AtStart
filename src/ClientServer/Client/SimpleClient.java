package ClientServer.Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import ClientServer.Data_frame;

public class SimpleClient implements Runnable {
	Socket client = null;
	InputStream in = null;
	OutputStream out = null;
	String ip = "127.0.0.1";
	int port = 6666;
	byte[] buf = new byte[100];
	byte[] Guibuf = new byte[100];
	String data;
	Boolean connected = false;
	Data_frame datf;
	int timeoutCounter;

	public SimpleClient() {
		Thread t = new Thread(this, "SimpleClient");
		try {
			client = new Socket(ip, port);
			checkDoubleConnection();
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
		try {
			// Send message to server
			do {
				in.read(buf);
				System.out.println("Receive message: " + new String(buf));
				if (new String(buf).indexOf("Y") != -1) {
					System.out.println("Y");
					connected = true;
					System.out.println("get Connect");
				}
			} while (new String(buf).indexOf("Y") == -1);
		} catch (

		Exception e) {
			System.err.println(e);
		}

	}

	public boolean gameStart() {
		try {
			out = client.getOutputStream();
			data = "GameStart";
			out.write(data.getBytes());

			do {
				in = client.getInputStream();
				in.read(buf);
			} while (new String(buf).compareTo("gameStart") == 0);
			System.out.println(" n GameStart");
			return true;
		} catch (Exception e) {
			System.err.println("GameStart err" + e);// TODO: handle exception
			return false;
		}
	}

	public String battleFildDataTransform(String d) {
		data = d;
		if (connected) {
			try {
				// data = Integer.toString(200) + "/" + Integer.toString(20) + "/" + "AAA" + "/"
				// + "A" + "/" + Integer.toString(100);//action
				// hp + speed + name + type + num //
				out = client.getOutputStream();
				System.out.println("write: " + data);
				out.write(data.getBytes());
				in = client.getInputStream();
				for (int i = 0; i < buf.length; i++) {
					buf[i] = ' ';
				}
				in.read(buf);
				data = new String(buf);
				System.out.println("read: " + data);
				// String[] sc1Data = data.split("/");
				/*
				 * for (String s : sc1Data) { System.out.println(s); }
				 */
				datf = new Data_frame(data);

				System.out.println(data);
				System.out.println(datf);

				// System.out.println("sc1>>." + sc1Data[4]);

			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public byte[] getGuibuf() {
		return Guibuf;
	}

	public void setGuibuf(byte[] guibuf) {
		Guibuf = guibuf;
	}

	public Data_frame getDatf() {
		return datf;
	}

	public void setDatf(Data_frame datf) {
		this.datf = datf;
	}

}