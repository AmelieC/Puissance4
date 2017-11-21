package model;
import java.util.Observable;

/**
 * @author ameliecourtin
 * Cette class determine les caracteristiques d'un pion, sa couleur, sa position
 *
 */


public class PionModel extends Observable {
	
	public class BateauModel extends Observable {
		

		private String couleur;
		private CaseModel[] position;
		private boolean estVide;// a voir
		
		/**
		 * Constructeur:
		 *@param couleur
		 * @param position
		 * @return 
		 */
		public void PionModel(String couleur,CaseModel[] position){
			
			this.couleur=couleur;
			this.position=position;
			for(CaseModel a:position){
				a.setEstUtilisee(true);
			}
			this.estVide=false;
		
		}


		public String getCouleur() {
			return couleur;
		}
		public void setCouleur(String couleur) {
			this.couleur=couleur;
			setChanged();
			notifyObservers();
		}


		public CaseModel[] getPosition() {
			return position;
		}
		public void setPosition(CaseModel[] position) {
			this.position = position;
			for(CaseModel a:position){
				a.setEstUtilisee(true);
			}
			setChanged();
			notifyObservers();
		}
		public void setPositionToIndex(CaseModel position,int i){
			this.position[i]=position;
			//setChanged();
			//notifyObservers();
		}
		public boolean estVide() {
			return estVide;
		}
		public void setEstVide(boolean estVide) {
			this.estVide = estVide;
			setChanged();
			notifyObservers();
		}

	}
}
