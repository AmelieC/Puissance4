/**
 * 
 */
package view;
import java.util.Observer;

import controller.PuissanceController;
import model.GrilleJeuModel;
import model.JoueurModel;

/**
 * @author ameliecourtin
 *
 */
public class PuissanceVue implements Observer {
	
	protected GrilleJeuModel grilleJeuModel;
	protected JoueurModel joueurModel;
	protected PuissanceController puissanceController;
	
	public PuissanceVue (GrilleJeuModel grilleJeuModel, JoueurModel joueurModel, PuissanceController puissanceController) {
		this.grilleJeuModel = grilleJeuModel;
		this.joueurModel = joueurModel;
		this.puissanceController = puissanceController;
		
	}
	
	
	//on précise que cette classe observe les models
	joueurModel.addObserver(this);
	grilleJeuModel.addObserver(this);
    
		
	
	

}
