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
	
}
