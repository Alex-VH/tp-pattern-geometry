package org.acme.geometry;

public class Enveloppe {
	private Coordinate bottomLeft;
	private Coordinate topRight;
	
	
	/**
	 * Constructeur vide la classe
	 */
	public Enveloppe() {
		this.bottomLeft = new Coordinate();
		this.topRight = new Coordinate();
	}
	
	
	/**
	 * Constructeur prenant en paramètres les coordonnées des extrêmes 
	 * d'une enveloppe de géométrie (coin bas gauche et haut droit)
	 * @param bottomLeft
	 * @param topRight
	 */
	public Enveloppe (Coordinate bottomLeft, Coordinate topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	
	/**
	 * Renvoie un boolean selon si au moins une coordonnée est instanciée 
	 * à NaN ou non
	 * @return
	 */
	public boolean isEmpty() {
		return (this.bottomLeft.isEmpty() || this.topRight.isEmpty());
	}
	
	
	/**
	 * Renvoie la valeur de la coordonnée la plus petite selon x
	 * @return
	 */
	public double getXmin() {
		return this.bottomLeft.getX();
	}
	
	
	/**
	 * Renvoie la valeur de la coordonnée la plus grande selon x
	 * @return
	 */
	public double getXmax() {
		return this.topRight.getX();
		
	}
	
	
	/**
	 * Renvoie la valeur de la coordonnée la plus petite selon y
	 * @return
	 */
	public double getYmin() {
		return this.bottomLeft.getY();
	}
	
	
	/**
	 * Renvoie la valeur de la coordonnée la plus grande selon y
	 * @return
	 */
	public double getYmax() {
		return this.topRight.getY();
	}
}
