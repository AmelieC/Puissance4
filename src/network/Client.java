/**
 * 
 */
package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author A.Courtin, M.Duchene, F.Salpietro.
 *
 */
public class Client {

	private Socket clientSocket;
	private PrintWriter writer;
	

	private BufferedReader reader;

	public Client(){
		try {
			this.clientSocket = new Socket("localhost", 4242);
			this.writer = new PrintWriter(this.clientSocket.getOutputStream());
			this.reader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PrintWriter getWriter() {
		return writer;
	}

	public BufferedReader getReader() {
		return reader;
	}
	
}



