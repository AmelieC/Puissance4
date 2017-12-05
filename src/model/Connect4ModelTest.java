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

}
