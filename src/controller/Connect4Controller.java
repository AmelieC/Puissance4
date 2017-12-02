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
	
	public boolean getIsGameRunning() 
	{
		return model.getIsGameRunning();
	}
	
	public void setIsGameRunning(boolean x) 
	{
		model.setIsGameRunning(x);
	}
	
	public int getNbTurn() 
	{
		return model.getNbTurn();
	}
	
	public void setNbTurn(int x) 
	{
		model.setNbTurn(x);
	}
	
	public String[][] getBoard()
	{
		return model.getBoard();
	}
	
	public void setEmptyBoard() 
	{
		model.setEmptyBoard();
	}
}
