package main;
import controller.Connect4Controller;
import model.Connect4Model;
import view.Connect4ConsoleView;
import view.Connect4GUIView;

/**
 * Main method of the project that links the MVC model.
 * 
 * @author A.Courtin, M.Duchene, F.Salpietro.
 */
public class Main {
	
	public static void main(String[] args) {
		
		if(args.length == 0){
			System.err.println("client or server");
			System.exit(1);
		}
		

		Connect4Model model = new Connect4Model();
		Connect4Controller controller = new Connect4Controller(model);
		Connect4ConsoleView consolView = new Connect4ConsoleView(model, controller);
		
		if(args[0].equals("server")){
			controller.setServer(true);
		}else{
			if(args.length != 1){
				System.err.println("Please specify server ip");
				System.exit(1);
			}
			controller.setServer(false);
			controller.setServerIP(args[1]);
		}
		
		controller.enableSocket();
		
		consolView.start();
	}
}
