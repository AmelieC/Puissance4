package controller;
import model.Connect4Model;

public class Connect4Controller {

	private Connect4Model model;
	
	public Connect4Controller(Connect4Model model) 
	{
		this.model = model;
	}
	
	public void playRedDisk(String [][] b, int x) 
	{
		model.playRedDisk(b, x);
	}
	
	public void playYellowDisk(String [][] b, int x) 
	{
		model.playYellowDisk(b, x);
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
