//*******************************************************************
//*  Network Programming - Unit 2 Simple Client and Server          *
//*  Program Name: SimpleServer2                                    *
//*  The program creates a socket and waits for request.            *
//*  2017.08.04                                                     *
//*******************************************************************
import java.net.*;
import java.io.*;


class ThreadBySubclass extends Thread
{
	String	ThreadName;
	Socket			sc = null;
	ObjectInputStream		in = null;
	ObjectOutputStream	out = null;
	byte []			buf = new byte[100];
	int count = 0;
	
	public ThreadBySubclass(String name,Socket sc)		// Constructor
	{
		ThreadName = name;
		this.sc = sc;
	}
	public static byte[] intToByteArray(int value)
	{
		return new byte[]
		{
			(byte)(value >> 24),
			(byte)(value >> 16),
			(byte)(value >> 8),
			(byte)value
		};
	}

	public  static int ByteToInt(byte[] buf)
	{
		int i,value = 0;
		for(i = 0;i < 4;i++)
		{
			value = value * 256 + (buf[i] &0x7F + ((buf[i]&0x80)>>7)*128) ; 
		}
		return value;
	}

	public void run()	// execute after thread has been initialized
	{
		try
		{
			Thread	t = Thread.currentThread();
			
			t.setName(ThreadName);
			System.out.println("Thread " + ThreadName + " is created!!");
				// Read message from client
				// Returns an input stream for socket sc.
		
			in = new ObjectOutputStream(sc.getInputStream());
			Player obj  = (Player)in.readObject();  
				// Send reply message to client
				// Returns an output stream for socket sc.
			out = new ObjectOutputStream(sc.getOutputStream());
			String data = "Server reply!!";
			out.write(data.getBytes());
			while(true)
			{	
				in.read(buf);
				count = ByteToInt(buf);
				System.out.printf("T%s:%d\n",ThreadName,count);
				if(count == 0)
				{
					out.write(buf);
					break;
				}
				count = count - 1;
				buf = intToByteArray(count);
				out.write(buf);
			} 
					// Closes in/out stream and releases any system resources associated with this stream.	
			in.close();
			out.close();
			//Closes this socket
			sc.close();
		}	
		catch(IOException e)
		{
			System.err.println(e);
		}
		
	}
}

public class SimpleServer
{
	public static void main(String args[])
	{
		ServerSocket	srverSocket = null;
		Socket			sc = null;
		int				port = 6666;
		int name = 0;

		
		try
		{
		    // Creates a server socket, bound to the specified port.
			srverSocket = new ServerSocket(port);
			
			System.out.println("Waiting for request ...");
			try
			{
			    // Listens for a connection to be made to this socket and accepts it.
				Thread	t = Thread.currentThread();
				while(true)
				{
					sc = srverSocket.accept();
					ThreadBySubclass thread = new ThreadBySubclass( Integer.toString(name++),sc);
					thread.start(); 
					sc = null;
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
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
}
