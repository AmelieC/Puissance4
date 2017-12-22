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
public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Création du serveur
		 */
		ServerSocket serversocket = null;
		try {
			serversocket = new ServerSocket(11111);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		/*
		 * Boucle infini qui va permettre de recevoir des clients
		 */
		while (true) {
			try {
				Socket client = serversocket.accept();
				System.out.println("Un client s'est connecté");
				
				/*
				 * Création des objets permettant de communiquer avec le client
				 */
				BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintStream output = new PrintStream(client.getOutputStream());
				
				/*
				 * Note : On peut utiliser l'objet scanner au lieu du BufferedReader
				 */
				Scanner inputScanner = new Scanner(client.getInputStream());
				
				/*
				 * La communication se fera dans cette boucle
				 */
				while (true) {
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
