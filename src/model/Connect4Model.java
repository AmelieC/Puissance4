package model;
import java.util.Observable;

public class Connect4Model extends Observable {
	
	public boolean isGameRunning;
	public String[][] board = new String[7][15]; 
	
	public String[][] createBoard() 
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
		return board;
	}
	
	public void playRedDisk(String[][] b, int x) 
	{
		for(int i = 5; i >= 0; i--) 
		{
			if(b[i][x] == " ") 
			{
				b[i][x] = "R";
				break;
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	public void playYellowDisk(String [][] b, int x) 
	{
		for(int i = 5; i >= 0; i--) 
		{
			if(b[i][x] == " ") 
			{
				b[i][x] = "Y";
				break;
			}
		}
		
		setChanged();
		notifyObservers();
	}
	
	public String checkIfWinner(String [][] b) 
	{
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
}
