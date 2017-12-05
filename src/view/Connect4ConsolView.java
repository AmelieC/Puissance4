package view;
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.Connect4Controller;
import model.Connect4Model;

public class Connect4ConsolView extends Connect4View implements Observer {

	protected Scanner sc;
	protected int answer;
	protected boolean isNotValid;
	
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
		
		while(model.getIsGameRunning()) 
		{
			if(model.getNbTurn() % 2 == 0) 
			{
				do
				{
					System.out.println("Player 1: drop a red disk (1-7)");
					sc = new Scanner(System.in);
					
					try 
					{
						answer = sc.nextInt();
					}
					catch(InputMismatchException e) 
					{
						answer = -1;
					}
					
					if(answer >= 1 && answer <= 7) 
					{
						controller.playRedDisk(model.getBoard(), 2 * answer + 1);
						controller.setNbTurn(model.getNbTurn() + 1);
						this.isNotValid = false;
					}
					else 
					{
						System.out.println("Please enter a valid column digit");
						this.isNotValid = true;
					}
				
				}while(isNotValid);
				
			}
			else 
			{
				do
				{
					System.out.println("Player 1: drop a yellow disk (1-7)");
					sc = new Scanner(System.in);
					
					try 
					{
						answer = sc.nextInt();
					}
					catch(InputMismatchException e)
					{
						answer = -1;
					}
					
					if(answer >= 1 && answer <= 7) 
					{
						controller.playYellowDisk(model.getBoard(), 2 * answer + 1);
						controller.setNbTurn(model.getNbTurn() + 1);
						this.isNotValid = false;
					}
					else 
					{
						System.out.println("Please enter a valid column digit");
						this.isNotValid = true;
					}
				
				}while(isNotValid);
			}
			
			if(controller.checkIfWinner(model.getBoard()) != null) 
			{
				if(controller.checkIfWinner(model.getBoard()) == "R") 
				{
					System.out.println("The player 1 (red) won");
				}
				else 
				{
					System.out.println("The player 2 (yellow) won");
				}
				
				do 
				{
				
					System.out.println("Wanna play again ? 0:No - 1:Yes");
					sc = new Scanner(System.in);
					int answer = sc.nextInt();
					
					if(answer == 0) 
					{
						controller.setIsGameRunning(false);
						this.isNotValid = false;
					}
					else if(answer == 1) 
					{
						controller.setNbTurn(0);
						controller.setEmptyBoard();
						this.isNotValid = false;
					}
					else 
					{
						System.out.println("Please enter a valid digit");
						this.isNotValid = true;
					}
				
				}while(isNotValid);
			}
		}
		
		sc.close();
	}
	
	public void update(Observable o, Object arg) 
	{
		displayBoard();
	}
}
