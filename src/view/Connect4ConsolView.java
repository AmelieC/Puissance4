package view;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.Connect4Controller;
import model.Connect4Model;

public class Connect4ConsolView extends Connect4View implements Observer {

	public Scanner sc;
	
	public Connect4ConsolView(Connect4Model model, Connect4Controller controller) 
	{
		super(model, controller);
	}
	
	public void displayBoard()
	{
		for (int i = 0;i < model.board.length;i++)
	    {
			for (int j = 0;j < model.board[i].length;j++)
			{
				System.out.print(model.board[i][j]);
			}
			
			System.out.println();
	    }
	}
	
	public void start() 
	{
		//Must implement for the game to work
	}
	
	public void update(Observable o, Object arg) 
	{
		displayBoard();
	}
}
