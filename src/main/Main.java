package main;
import controller.Connect4Controller;
import model.Connect4Model;
import view.Connect4ConsolView;

public class Main {
	
	public static void main(String[] args) {
		Connect4Model model = new Connect4Model();
		Connect4Controller controller = new Connect4Controller(model);
		Connect4ConsolView consolView = new Connect4ConsolView(model, controller);
		
		consolView.start();
	}
}
