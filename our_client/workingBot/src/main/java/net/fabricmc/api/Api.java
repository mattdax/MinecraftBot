package net.fabricmc.api;

import java.io.*;
import java.net.*;
import java.util.Arrays;

import net.fabricmc.movement.Listener;
public class Api extends Thread {
	
	
	
	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	private String ip;
	private int port;
	public Api(String ip, int port) throws UnknownHostException, IOException {
		
		
		
		this.ip = ip;
		this.port = port;
		this.clientSocket = new Socket(ip,port);
		this.out = new PrintWriter(clientSocket.getOutputStream(),true);
		this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		
	}
	
	public void run() {
		
		System.out.println("Python API Connected");
		String inputLine;
		
		try {
			while((inputLine = in.readLine())!= null){
				 if (".".equals(inputLine)) {
			         
			         break;
			     }
			     System.out.println(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		System.out.println("Connection Closed");
	}
	public void sendMovement(int[] movements) {
		System.out.println(Arrays.toString(movements));
		this.out.println(Arrays.toString(movements));
	
	}

}
