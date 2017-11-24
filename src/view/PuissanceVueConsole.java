/**
 * 
 */
package view;
import java.util.Observer;
import java.util.Scanner;

import controller.PuissanceController;
import model.GrilleJeuModel;
import model.JoueurModel;

/**
 * @author ameliecourtin
 *
 */
public class PuissanceVueConsole extends PuissanceVue implements Observer(GrilleJeuModel grilleJeuModel, JoueurModel joueurModel, PuissanceController puissanceController ) {
	super(grilleJeuModel,joueurModel, puissanceController );
	protected Scanner sc;
	
	

}
