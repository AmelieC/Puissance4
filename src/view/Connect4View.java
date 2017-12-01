package view;
import java.util.Observer;

import controller.Connect4Controller;
import model.Connect4Model;

public abstract class Connect4View implements Observer {
	
	protected Connect4Model model;
	protected Connect4Controller controller;
	
	Connect4View(Connect4Model model, Connect4Controller controller)
	{
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
}
