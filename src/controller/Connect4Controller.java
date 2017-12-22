package controller;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Connect4Model;

/**
 * This class contents the action a view can do to alter the model
 * 
 * @author A.Courtin, M.Duchene, F.Salpietro.
 */
public class Connect4Controller {

	private Connect4Model model; //the model the controller will alter
	protected Scanner sc;
	protected boolean isNotValid;
	protected int answer;
	
	public Connect4Controller(Connect4Model model) 
	{
		this.model = model;
	}
	
	public void playRedDiskConsol() 
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
				model.playRedDisk(model.getBoard(), 2 * answer + 1);
				model.setNbTurn(model.getNbTurn() + 1);
				this.isNotValid = false;
			}
			else 
			{
				System.out.println("Please enter a valid column digit");
				this.isNotValid = true;
			}
		
		}while(isNotValid);;

	}
	
	public void playYellowDiskConsol() 
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
				model.playYellowDisk(model.getBoard(), 2 * answer + 1);
				model.setNbTurn(model.getNbTurn() + 1);
				this.isNotValid = false;
			}
			else 
			{
				System.out.println("Please enter a valid column digit");
				this.isNotValid = true;
			}
		
		}while(isNotValid);	
	}
	
	public void replayProposalConsol() 
	{
		do 
		{
		
			System.out.println("Wanna play again ? 0:No - 1:Yes");
			sc = new Scanner(System.in);
			
			try 
			{
				answer = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				answer = -1;
			}
			
			if(answer == 0) 
			{
				model.setIsGameRunning(false);
				this.isNotValid = false;
			}
			else if(answer == 1) 
			{
				model.setNbTurn(0);
				model.setEmptyBoard();
				this.isNotValid = false;
			}
			else 
			{
				System.out.println("Please enter a valid digit");
				this.isNotValid = true;
			}
		
		}while(isNotValid);
	}
	
	public String checkIfWinner(String [][] board) 
	{
		return model.checkIfWinner(board);
	}
	
	public void setIsGameRunning(boolean x) 
	{
		model.setIsGameRunning(x);
	}
	
	public void setNbTurn(int x) 
	{
		model.setNbTurn(x);
	}
	
	public void setEmptyBoard() 
	{
		model.setEmptyBoard();
	}
}
