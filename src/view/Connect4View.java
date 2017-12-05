package view;
import java.util.Observer;

import controller.Connect4Controller;
import model.Connect4Model;

/**
 * This class represents the base all the different views
 * must have
 * @author A.Courtin, M.Duchene, F.Salpietro.
 */
public abstract class Connect4View implements Observer {
	
	protected Connect4Model model; //the model the view will observe
	protected Connect4Controller controller; //the controller the view will pass the user's actions 
	
	public Connect4View(Connect4Model model, Connect4Controller controller)
	{
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
}
