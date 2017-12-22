/**
 * 
 */
package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author A.Courtin, M.Duchene, F.Salpietro.
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * L'objet socket a besoin de l'IP et du Port du ServerSocket
		 */
                Socket client = null;
		try {
			client = new Socket(<IP>, <PORT_DU_SERVEUR>);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
		/*
		 * Cr�ation des objets permettant de communiquer avec le client
		 */
		PrintStream output = null;
		BufferedReader input = null;
		try {
			output = new PrintStream(client.getOutputStream());
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		/*
		 * Boucle principale
		 */
		while (true) {
			
		}
	
	}
}



