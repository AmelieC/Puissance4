package view;
import java.util.Observable;
import java.util.Observer;

import controller.Connect4Controller;
import model.Connect4Model;

/**
 * This class represents how the console view should interact
 * 
 * @author A.Courtin, M.Duchene, F.Salpietro.
 */
public class Connect4ConsoleView extends Connect4View implements Observer {
	
	public Connect4ConsoleView(Connect4Model model, Connect4Controller controller) 
	{
		super(model, controller);
	}
	
	/**
	 * Method that display the current model's board in console.
	 */
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
	
	/**
	 * The central method of the console view that will control how it react
	 */
	public void start() 
	{
		controller.setIsGameRunning(true); 
		displayBoard();
		
		while(model.getIsGameRunning()) 
		{
			if(model.getNbTurn() % 2 == 0) 
			{
				
				controller.playRedDiskConsol();
			}
			else 
			{
				controller.playYellowDiskConsol();
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
				
				controller.replayProposalConsol();
			}
		}
		
		//sc.close();
	}
	
	/**
	 * Method that is triggers when the observer is altered.
	 */
	public void update(Observable o, Object arg) 
	{
		displayBoard();
	}
}
