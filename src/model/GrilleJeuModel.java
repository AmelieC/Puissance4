/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author ameliecourtin
 *
 */
public class GrilleJeuModel extends Observable {
	protected CaseModel[][] tabCase;




/**
 * Constructeur: Construit une grille contenant des Cases.
 * @param nbColonnes
 * @param nbLignes
 * 
 */


public GrilleJeuModel(int nbColonnes,int nbLignes){
	tabCase=new CaseModel[6][7];
	for(int i=0;i<nbLignes;i++){
		for(int j=0;j<nbColonnes;j++){	
			tabCase[i][j]=new CaseModel();
			
		}
	}
	
}


public CaseModel[][] getTabCase() {
	return tabCase;
}

public void setTabCase(CaseModel[][] tabCase) {
	this.tabCase = tabCase;
	setChanged();
	notifyObservers();
}


}


