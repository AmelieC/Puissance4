package view;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.Connect4Controller;
import model.Connect4Model;

public class Connect4ConsolView extends Connect4View implements Observer {

	protected Scanner sc;
	
	public Connect4ConsolView(Connect4Model model, Connect4Controller controller) 
	{
		super(model, controller);
	}
	
	public void displayBoard()
	{
		for (int i = 0;i < model.getBoard().length;i++)
	    {
			for (int j = 0;j < model.getBoard()[i].length;j++)
			{
				System.out.print(model.getBoard()[i][j]);
			}
			
			System.out.println();
	    }
	}
	
	public void start() 
	{
		controller.setIsGameRunning(true);
		displayBoard();
		
		while(controller.getIsGameRunning()) 
		{
			if(controller.getNbTurn() % 2 == 0) 
			{
				System.out.println("Player 1: drop a red disk (0-6)");
				sc = new Scanner(System.in);
				controller.playRedDisk(controller.getBoard(), 2 * sc.nextInt() + 1);
				controller.setNbTurn(controller.getNbTurn() + 1);
				
			}
			else 
			{
				System.out.println("Player 2: drop a yellow disk (0-6)");
				sc = new Scanner(System.in);
				controller.playYellowDisk(controller.getBoard(), 2 * sc.nextInt() + 1);
				controller.setNbTurn(controller.getNbTurn() + 1);
			}
			
			if(controller.checkIfWinner(controller.getBoard()) != null) 
			{
				if(controller.checkIfWinner(controller.getBoard()) == "R") 
				{
					System.out.println("The player 1 (red) won");
				}
				else 
				{
					System.out.println("The player 2 (yellow) won");
				}
				
				System.out.println("Wanna play again ? 0:No - 1:Yes");
				sc = new Scanner(System.in);
				int answer = sc.nextInt();
				
				if(answer == 0) 
				{
					controller.setIsGameRunning(false);
				}
				else if(answer == 1) 
				{
					controller.setNbTurn(0);
					controller.setEmptyBoard();
				}
			}
		}
		
		sc.close();
	}
	
	public void update(Observable o, Object arg) 
	{
		displayBoard();
	}
}
