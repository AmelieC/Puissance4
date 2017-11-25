
	/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author ameliecourtin
 *
 */
public class JoueurModel extends Observable {
	
	private String couleur;
	private int nbPionALigne;
	private PionModel [] pion;
	private GrilleJeuModel grillejeu;
	private int indicePionAPositionner;
	private int casePionAPositionner;
	private boolean sonTour;
	
	
	public JoueurModel (String couleur) {
		this.nbPionALigne = 0;
		this.couleur = couleur;
		this.indicePionAPositionner = 0;
		this.casePionAPositionner = 0;
		
		pion =new PionModel[1];
		pion [1] = new PionModel ("jaune");
		pion [1] = new PionModel ("rouge");
		
		
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public int getNbPionALigne() {
		return nbPionALigne;
	}


	public void setNbPionALigne(int nbPionALigne) {
		this.nbPionALigne = nbPionALigne;
	}


	public PionModel[] getPion() {
		return pion;
	}


	public void setPion(PionModel[] pion) {
		this.pion = pion;
	}


	public GrilleJeuModel getGrillejeu() {
		return grillejeu;
	}


	public void setGrillejeu(GrilleJeuModel grillejeu) {
		this.grillejeu = grillejeu;
		setChanged();
		notifyObservers();
	}


	public int getIndicePionAPositionner() {
		return indicePionAPositionner;
	}


	public void setIndicePionAPositionner(int indicePionAPositionner) {
		this.indicePionAPositionner = indicePionAPositionner;
		setChanged();
		notifyObservers();
	}


	public int getCasePionAPositionner() {
		return casePionAPositionner;
	}


	public void setCasePionAPositionner(int casePionAPositionner) {
		this.casePionAPositionner = casePionAPositionner;
		setChanged();
		notifyObservers();
	}


	public boolean getSonTour() {
		return sonTour;
	}


	public void setSonTour(boolean sonTour) {
		this.sonTour = sonTour;
		setChanged();
		notifyObservers();
	}
	
	
	
	
	

}
