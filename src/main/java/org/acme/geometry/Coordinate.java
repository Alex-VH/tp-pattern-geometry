package org.acme.geometry;

public class Coordinate {
	public double x;
	public double y;
	
	
	/**
	 * Constructeur vide de la classe 
	 */
	public Coordinate() {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}
	
	
	/**
	 * Constructeur de la classe prenant en parametre les coordonnées 
	 * selon l axe x et y
	 * @param x
	 * @param y
	 */
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * Getter de la coordonnée selon l'axe x
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	
	
	/**
	 * Getter de la coordonnée selon l'axe y
	 * @return
	 */
	public double getY() {
		return this.y;
	}
		
	
	/**
	 * Renvoie un boolean selon si la coordonnée est instanciée 
	 * à NaN ou non
	 * @return
	 */
	public boolean isEmpty() {
		return (Double.isNaN(x) || Double.isNaN(y));
	}
}
