package model;
import java.util.Observable;

/**
 * This class defines the properties and the action you 
 * can make on a Connect4's board. 
 * 
 * @author A.Courtin, M.Duchene, F.Salpietro. 
 */
public class Connect4Model extends Observable {
	
	private boolean isGameRunning; //define if a game is running or not
	private int nbTurn; //define the number of the current turn
	private boolean isServer;
	
	public boolean isServer() {
		return isServer;
	}

	public String getServerIP() {
		return serverIP;
	}

	public String serverIP;
	
	/* The board here is composed by a pedestal, which it's represented by
	 * an additional row, and by separator between columns which 
	 * is represented by columns + 1 additional columns.
	 * The formula for rows and columns is: 
	 * rows = rows + 1
	 * columns = 2 * columns + 1
	 * 
	 * So here board is composed by 6 rows and 7 columns. 
	 */
	private String[][] board = new String[7][15];
	
	public Connect4Model() 
	{
		setEmptyBoard();  //Prepare an empty board when instantiated
	}
	
	/**
	 * This method add a red disk to the column specified by the user.
	 * 
	 * @param b must be a 2 dimension array of string,
	 * you have to adapt the i variable if you don't use
	 * the same rows and columns I use.
	 * Adapt it this way: i = rows - 1 
	 *
	 * @param x must be an int between 1 and the number of effective columns
	 */
	public void playRedDisk(String[][] b, int x) 
	{	
		for(int i = 5; i >= 0; i--) 
		{
			if(b[i][x - 2] == " ") 
			{
				b[i][x - 2] = "R";
				break;
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * This method add a yellow disk to the column specified by the user.
	 * 
	 * @param b must be a 2 dimension array of string,
	 * you have to adapt the i variable if you don't use
	 * the same rows and columns I use.
	 * Adapt it this way: i = rows - 1 
	 *
	 * @param x must be an int between 1 and the number of effective columns
	 */
	public void playYellowDisk(String [][] b, int x) 
	{	
		for(int i = 5; i >= 0; i--) 
		{
			if(b[i][x - 2] == " ") 
			{
				b[i][x - 2] = "Y";
				break;
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Scans a 2 dimension array to check if a winner combination has been made.
	 * The signature must be adapt to the number of rows and columns you want.
	 * 
	 * @param b must be a 2 dimension array
	 * @return false if no winning combination has been found.
	 *         'R' if the red player won.
	 *         'Y' if the yellow player won.
	 */
	public String checkIfWinner(String [][] b) 
	{
		//check for horizontal winning line
		for(int i = 0;i < 6;i++) 
		{
			for(int j = 0;j < 7;j+=2) 
			{
				if((b[i][j + 1] != " ")
				&& (b[i][j + 3] != " ")
				&& (b[i][j + 5] != " ")
				&& (b[i][j + 7] != " ")
				&& ((b[i][j + 1] == b[i][j + 3])
				&& (b[i][j + 3] == b[i][j + 5])
				&& (b[i][j + 5] == b[i][j + 7])))	
				{
					return b[i][j + 1];
				}
			}
		}
		
		//check for vertical winning line
		for (int i = 1;i < 15;i+=2)
		{
			for (int j = 0;j < 3;j++)
			{
				if((b[j][i] != " ")
				&& (b[j + 1][i] != " ")
				&& (b[j + 2][i] != " ")
				&& (b[j + 3][i] != " ")
				&& ((b[j][i] == b[j + 1][i])
				&& (b[j + 1][i] == b[j + 2][i])
				&& (b[j + 2][i] == b[j + 3][i])))
				{
					return b[j][i];
				}
			}
		}
		
		//check for diagonal winning line
		for (int i=0;i<3;i++)
		{
			for (int j=1;j<9;j+=2)
			{
				if((b[i][j] != " ")
				&& (b[i+1][j+2] != " ")
				&& (b[i+2][j+4] != " ")
				&& (b[i+3][j+6] != " ")
				&& ((b[i][j] == b[i+1][j+2])
				&& (b[i+1][j+2] == b[i+2][j+4])
				&& (b[i+2][j+4] == b[i+3][j+6])))
				{
					return b[i][j]; 
				}
			}
		}
		
		//check for the other diagonal winning line 
		for (int i=0;i<3;i++)
		{
			for (int j=7;j<15;j+=2)
			{
				if((b[i][j] != " ")
				&& (b[i+1][j-2] != " ")
				&& (b[i+2][j-4] != " ")
				&& (b[i+3][j-6] != " ")
				&& ((b[i][j] == b[i+1][j-2])
				&& (b[i+1][j-2] == b[i+2][j-4])
				&& (b[i+2][j-4] == b[i+3][j-6])))
				{
					return b[i][j]; 
				}
			} 
		}
		
		return null;
	}
	
	//Getters 
	public boolean getIsGameRunning() 
	{
		return this.isGameRunning;
	}
	
	public int getNbTurn() 
	{
		return this.nbTurn;
	}
	
	public String[][] getBoard()
	{
		return this.board;
	}
	
	//Setters
	public void setIsGameRunning(boolean x) 
	{
		this.isGameRunning = x;
	}
	
	public void setNbTurn(int x) 
	{
		this.nbTurn = x;
	}
	
	/**
	 * This method empty the potentials disks the board contains.
	 */
	public void setEmptyBoard() 
	{
		for(int i = 0;i < board.length; i++)
		{
			for(int j = 0;j < board[i].length; j++) 
			{
				if(j % 2 == 0) 
				{
					board[i][j] = "|";
				}else
				{
					board[i][j] = " ";
				}
				
				if(i == 6)
				{
					board[i][j] = "-";
				}
			}
		}
		
		setChanged();
		notifyObservers();
	}

	public void setServer(boolean isServer) {
		this.isServer = isServer;
		
	}

	public void setServerIP(String server) {
		this.serverIP = server;
		
	}
}
