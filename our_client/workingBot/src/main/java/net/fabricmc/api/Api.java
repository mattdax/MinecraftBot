package net.fabricmc.api;

import java.io.*;
import java.net.*;
public class Api {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	public void start(String ip, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(ip,port);
		out = new PrintWriter(clientSocket.getOutputStream(),true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println("Python API Connected");
		String inputLine;
		
		while((inputLine = in.readLine())!= null){
			 if (".".equals(inputLine)) {
                 
                 break;
             }
             System.out.println(inputLine);
		}
	}
	public void close() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		System.out.println("Connection Closed");
	}
}
