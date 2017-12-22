package view;

import javax.swing.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import controller.Connect4Controller;
import model.Connect4Model;

public class Connect4GUIView extends Connect4View implements Observer
{		
	JFrame f = new JFrame("Connect4");
	
	public Connect4GUIView(Connect4Model model, Connect4Controller controller) 
	{
		super(model, controller);
		
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createBoard();
	}
	
	
	public void createBoard() 
	{
		Box line1 = Box.createHorizontalBox();
		Box line2 = Box.createHorizontalBox();
		Box line3 = Box.createHorizontalBox();
		Box line4 = Box.createHorizontalBox();
		Box line5 = Box.createHorizontalBox();
		Box line6 = Box.createHorizontalBox();
		
		for(int i = 1; i < 14; i+=2) 
		{
			if(model.getBoard()[0][i].equals(" ")) 
			{
				line1.add(new JLabel(new ImageIcon("img/empty.png")));
			}
			else if(model.getBoard()[0][i].equals("R"))
			{
				line1.add(new JLabel(new ImageIcon("img/red.png")));
			}
			else 
			{
				line1.add(new JLabel(new ImageIcon("img/black.png")));
			}
		}
		
		for(int i = 1; i < 14; i+=2) 
		{
			if(model.getBoard()[1][i].equals(" ")) 
			{
				line2.add(new JLabel(new ImageIcon("img/empty.png")));
			}
			else if(model.getBoard()[1][i].equals("R"))
			{
				line2.add(new JLabel(new ImageIcon("img/red.png")));
			}
			else 
			{
				line2.add(new JLabel(new ImageIcon("img/black.png")));
			}
		}
		
		for(int i = 1; i < 14; i+=2) 
		{
			if(model.getBoard()[2][i].equals(" ")) 
			{
				line3.add(new JLabel(new ImageIcon("img/empty.png")));
			}
			else if(model.getBoard()[2][i].equals("R"))
			{
				line3.add(new JLabel(new ImageIcon("img/red.png")));
			}
			else 
			{
				line3.add(new JLabel(new ImageIcon("img/black.png")));
			}
		}
		
		for(int i = 1; i < 14; i+=2) 
		{
			if(model.getBoard()[3][i].equals(" ")) 
			{
				line4.add(new JLabel(new ImageIcon("img/empty.png")));
			}
			else if(model.getBoard()[3][i].equals("R"))
			{
				line4.add(new JLabel(new ImageIcon("img/red.png")));
			}
			else 
			{
				line4.add(new JLabel(new ImageIcon("img/black.png")));
			}
		}
		
		for(int i = 1; i < 14; i+=2) 
		{
			if(model.getBoard()[4][i].equals(" ")) 
			{
				line5.add(new JLabel(new ImageIcon("img/empty.png")));
			}
			else if(model.getBoard()[4][i].equals("R"))
			{
				line5.add(new JLabel(new ImageIcon("img/red.png")));
			}
			else 
			{
				line5.add(new JLabel(new ImageIcon("img/black.png")));
			}
		}
		
		for(int i = 1; i < 14; i+=2) 
		{
			if(model.getBoard()[5][i].equals(" ")) 
			{
				line6.add(new JLabel(new ImageIcon("img/empty.png")));
			}
			else if(model.getBoard()[5][i].equals("R"))
			{
				line6.add(new JLabel(new ImageIcon("img/red.png")));
			}
			else 
			{
				line6.add(new JLabel(new ImageIcon("img/black.png")));
			}
		}
		dropDiskButtonListener listener1 = new dropDiskButtonListener(1);
		dropDiskButtonListener listener2 = new dropDiskButtonListener(2);
		dropDiskButtonListener listener3 = new dropDiskButtonListener(3);
		dropDiskButtonListener listener4 = new dropDiskButtonListener(4);
		dropDiskButtonListener listener5 = new dropDiskButtonListener(5);
		dropDiskButtonListener listener6 = new dropDiskButtonListener(6);
		dropDiskButtonListener listener7 = new dropDiskButtonListener(7);
		
		JButton dropDiskButton = new JButton("  +  ");
		dropDiskButton.addActionListener(listener1);
		
		JButton dropDiskButton1 = new JButton("  +  ");
		dropDiskButton1.addActionListener(listener2);
		
		JButton dropDiskButton2 = new JButton("  +  ");
		dropDiskButton2.addActionListener(listener3);
		
		JButton dropDiskButton3 = new JButton("  +  ");
		dropDiskButton3.addActionListener(listener4);
		
		JButton dropDiskButton4 = new JButton("  +  ");
		dropDiskButton4.addActionListener(listener5);
		
		JButton dropDiskButton5 = new JButton("  +  ");
		dropDiskButton5.addActionListener(listener6);
		
		JButton dropDiskButton6 = new JButton("  +  ");
		dropDiskButton6.addActionListener(listener7);

		Box buttonBar = Box.createHorizontalBox();
		buttonBar.add(dropDiskButton);
		buttonBar.add(dropDiskButton1);
		buttonBar.add(dropDiskButton2);
		buttonBar.add(dropDiskButton3);
		buttonBar.add(dropDiskButton4);
		buttonBar.add(dropDiskButton5);
		buttonBar.add(dropDiskButton6);
			
		Box board = Box.createVerticalBox();
		board.add(buttonBar);
		board.add(line1);
		board.add(line2);
		board.add(line3);
		board.add(line4);
		board.add(line5);
		board.add(line6);
	
		Container contentPane = f.getContentPane();
		contentPane.add(board);
		
		f.setVisible(true);
	}
	
	public void refreshBoard() 
	{
		
	}
	
	
	public class dropDiskButtonListener implements ActionListener
	{
		int id;
		
		public dropDiskButtonListener(int x) 
		 { 
			this.id = x;
		 }
		
		
		public void actionPerformed(ActionEvent event) 
		{
			switch (this.id)
			{
				case 1: model.playRedDisk(model.getBoard(), 3);
						break;
				case 2: model.playRedDisk(model.getBoard(), 5);
						break;
				case 3: model.playRedDisk(model.getBoard(), 7);
						break;
				case 4: model.playRedDisk(model.getBoard(), 9);
						break;
				case 5: model.playRedDisk(model.getBoard(), 11);
						break;
				case 6: model.playRedDisk(model.getBoard(), 13);
						break;
				case 7: model.playRedDisk(model.getBoard(), 15);
						break;
			}
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		Connect4Model model = new Connect4Model();
		Connect4Controller controller = new Connect4Controller(model);
		
		Connect4GUIView gui = new Connect4GUIView(model, controller);
	}
	
	public void update(Observable o, Object arg) 
	{
		createBoard();
	}
}
