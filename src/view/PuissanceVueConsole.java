/**
 * 
 */
package view;
import java.io.IOException;
import java.util.Observer;
import java.util.Scanner;

import controller.PuissanceController;
import model.GrilleJeuModel;
import model.JoueurModel;

/**
 * @author ameliecourtin
 *
 */
public class PuissanceVueConsole extends PuissanceVue implements Observer{
	protected Scanner sc;
	
	

	public PuissanceVueConsole(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible,PuissanceController puissanceController) throws IOException{
		super(grilleJeuModel, joueurModel,puissanceController);
		sc=new Scanner(System.in);
		
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		puissanceController.afficherGrilleModel();
			System.out.println("Veuillez positionner:"+joueurModel.getPion()[joueurModel.getIndicePionAPositionner()].getCouleur()+"   (couleur: "+joueurModel.getPion()[joueurModel.getIndicePionAPositionner()].getCouleur()+")");
			
		}
}



