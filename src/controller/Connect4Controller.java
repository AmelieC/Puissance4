package controller;

import java.io.IOException;

import model.Connect4Model;
import network.Server;
import network.Server.ServerRunner;

/**
 * This class contents the action a view can do to alter the model
 * 
 * @author A.Courtin, M.Duchene, F.Salpietro.
 */
public class Connect4Controller {

	private Connect4Model model; //the model the controller will alter
	private ServerRunner runner;
	
	public Connect4Controller(Connect4Model model) 
	{
		this.model = model;
	}
	
	public void playRedDisk(int answer) 
	{
		if(true){
			try {
				if(runner != null)
					this.runner.write(Integer.toString(2*answer+1));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.playRedDisk(model.getBoard(), 2 * answer + 1);
			model.setNbTurn(model.getNbTurn() + 1);
		}
	}
	
	public void playYellowDisk(int answer) 
	{
		if(true){
			model.playYellowDisk(model.getBoard(), 2 * answer + 1);
			model.setNbTurn(model.getNbTurn() + 1);	
		}
	}
	
	public void empty(){
		model.setNbTurn(0);
		model.setEmptyBoard();
	}
	
	public void quit(){
		model.setNbTurn(0);
		model.setEmptyBoard();
		this.setIsGameRunning(false);
	}
	
	public void replay() {

		model.setNbTurn(0);
		model.setEmptyBoard();
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

	public void setServer(boolean isServer) {
		model.setServer(isServer);
	}

	public void setServerIP(String server) {
		model.setServerIP(server);
	}

	public void enableSocket() {
		if(model.isServer()){
			Server s = new Server(this);
			s.start();
		}else{
			
		}
		
	}

	public boolean awaitingMessage() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setRunner(ServerRunner sr) {
		this.runner = sr;
		
	}

	public void handle(String message) {
		this.playYellowDisk(Integer.parseInt(message));
		
	}

}
