package net.fabricmc.api;

import java.io.*;
import java.net.*;

import net.fabricmc.movement.Listener;
public class Api implements Runnable {
	
	
	
	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	private String ip;
	private int port;
	public Api(String ip, int port) {
		
		
		
		this.ip = ip;
		this.port = port;
	}
	
	public void run() {
		try {
			clientSocket = new Socket(ip,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(clientSocket.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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


}
