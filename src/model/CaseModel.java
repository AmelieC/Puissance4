package model;
import java.util.Observable;

/**
 * @author ameliecourtin
 *
 */

public class CaseModel extends Observable {
	
	
	
	protected int coordonneeY;
	protected int coordonneeX;
	protected boolean estUtilisee;
	protected boolean estVide;
	private PionModel pion;
	
	public CaseModel() {
		
	}
	
	public CaseModel(int coordonneeY, int coordonneeX, boolean estUtilisee, boolean estVide) {
		
		
		this.coordonneeY = coordonneeY;
		this.coordonneeX = coordonneeX;
		this.estUtilisee = estUtilisee;
		this.estVide = estVide;
		
		
		
	}
	
	
	/**
	 * 
	 * @param coordonneeX
	 * @param coordonneeY
	 * @param positionX
	 * @param positionY
	 */
	
	
	

	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
		setChanged();
		notifyObservers();
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}
	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
		setChanged();
		notifyObservers();
	}
	public boolean getEstUtilisee() {
		return estUtilisee;
	}
	
	public void setEstUtilisee(boolean estUtilisee) {
		this.estUtilisee = estUtilisee;
		setChanged();
		notifyObservers();
	
	}


	public boolean getEstVide() {
		return estVide;
	}


	public void setEstVide(boolean estVide) {
		this.estVide = estVide;
		setChanged();
		notifyObservers();
	}
	
	public PionModel getPion() {
		return pion;
	}
	public void setPion(PionModel pion) {
		this.pion = pion;
		
	}
	
}
	
