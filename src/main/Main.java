package main;
import controller.Connect4Controller;
import model.Connect4Model;
import view.Connect4ConsoleView;

/**
 * Main method of the project that links the MVC model.
 * 
 * @author A.Courtin, M.Duchene, F.Salpietro.
 */
public class Main {
	
	public static void main(String[] args) {
		Connect4Model model = new Connect4Model();
		Connect4Controller controller = new Connect4Controller(model);
		Connect4ConsoleView consolView = new Connect4ConsoleView(model, controller);
		
		consolView.start();
	}
}
