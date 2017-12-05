package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Connect4ModelTest {

	@Test
	void playRedDiskTest() 
	{
		Connect4Model model = new Connect4Model();
		String [][]arrayTest = model.getBoard();
		arrayTest[5][1] = "R";
		model.playRedDisk(model.getBoard(), 3);
		assertEquals(arrayTest, model.getBoard());
	}
	
	@Test
	void playYellowDiskTest() 
	{
		Connect4Model model = new Connect4Model();
		String [][]arrayTest = model.getBoard();
		arrayTest[5][5] = "Y";
		model.playRedDisk(model.getBoard(), 7);
		assertEquals(arrayTest, model.getBoard());
	}
	
	@Test
	void checkIfWinnerTestHorizontal() 
	{
		Connect4Model model = new Connect4Model();
		
		//test horizontal winning line
		model.playRedDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 5);
		model.playRedDisk(model.getBoard(), 7);
		model.playRedDisk(model.getBoard(), 9);
		assertEquals("R", model.checkIfWinner(model.getBoard()));
		
		//reset array to test other combination
		model.setEmptyBoard();
		
		//test vertical winning line
		model.playRedDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 3);
		assertEquals("R", model.checkIfWinner(model.getBoard()));
		
		model.setEmptyBoard();
		
		//test first diagonal winning line
		model.playYellowDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 5);
		model.playYellowDisk(model.getBoard(), 5);
		model.playRedDisk(model.getBoard(), 7);
		model.playRedDisk(model.getBoard(), 7);
		model.playYellowDisk(model.getBoard(), 7);
		model.playRedDisk(model.getBoard(), 9);
		model.playRedDisk(model.getBoard(), 9);
		model.playRedDisk(model.getBoard(), 9);
		model.playYellowDisk(model.getBoard(), 9);
		assertEquals("Y", model.checkIfWinner(model.getBoard()));
		
		model.setEmptyBoard();
		
		//test second diagonal winning line
		model.playRedDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 3);
		model.playYellowDisk(model.getBoard(), 3);
		model.playRedDisk(model.getBoard(), 5);
		model.playRedDisk(model.getBoard(), 5);
		model.playYellowDisk(model.getBoard(), 5);
		model.playRedDisk(model.getBoard(), 7);
		model.playYellowDisk(model.getBoard(), 7);
		model.playYellowDisk(model.getBoard(), 9);
		assertEquals("Y", model.checkIfWinner(model.getBoard()));		
		
		model.setEmptyBoard();
		
		//test no winning lane
		assertEquals(null, model.checkIfWinner(model.getBoard()));
	}
}
