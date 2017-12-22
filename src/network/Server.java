/**
 * 
 */
package network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import controller.Connect4Controller;

/**
 * @author A.Courtin, M.Duchene, F.Salpietro.
 *
 */
public class Server {
	
	private ServerSocket ss;
	private ServerRunner sr;
	private Thread thread;

	public Server(Connect4Controller ctrl){
		try {
			this.ss = new ServerSocket(4242);
			this.sr = new ServerRunner(ss, ctrl);
			this.thread = new Thread(this.sr);
			ctrl.setRunner(sr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class ServerRunner implements Runnable{
		
		private ServerSocket server;
		private Socket client = null;
		private Connect4Controller ctrl;
		private PrintWriter writer;
		private BufferedInputStream reader;

		public ServerRunner(ServerSocket server, Connect4Controller ctrl) {
			this.ctrl = ctrl;
			this.server = server;
		}
		
		private String read() throws IOException{      
			String response = "";
			int stream;
			byte[] b = new byte[4096];
			stream = reader.read(b);
			response = new String(b, 0, stream);
			return response;
	    }
		
		public void write(String s) throws IOException{
			if(this.writer != null)
				writer.write(s);
		}

		@Override
		public void run() {
			while(true){
				try {
					this.client = this.server.accept();
					
					this.writer = new PrintWriter(this.client.getOutputStream());
		            this.reader = new BufferedInputStream(this.client.getInputStream());
		            
		            while(true){
		            	String message = this.read();
		            	ctrl.handle(message);
		            }
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
	public void start(){
		this.thread.start();
	}

}
