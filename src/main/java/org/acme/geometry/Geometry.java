package org.acme.geometry;

public interface Geometry {
	
	/**
	 * Renvoie le type de geometrie sous forme de string
	 * @return
	 */
	public String getType();
	
	
	/**
	 * Renvoie un booleen selon si la geometrie est vide ou non
	 * @return
	 */
	public boolean isEmpty();
	
	
	/**
	 * Translate la geometrie de dx selon x et dy selon y
	 * @param dx
	 * @param dy
	 */
	public void translate(double dx, double dy);
	
	
	/**
	 * Clone la geometrie
	 * @return
	 */
	public Geometry clone();
	
	
	/**
	 * Renvoie l'enveloppe de la geometrie
	 * @return
	 */
	public Enveloppe getEnveloppe();
	
	
	/**
	 * Methode permettant à une geometrie d'accepter un visiteur donné en parametre
	 * @param visitor
	 */
	public void accept(GeometryVisitor visitor);
	
	
	/**
	 * Méthode permettant à une geometrie d'ajouter un écouteur donné en paramètre
	 * @param listener
	 */
	public void addListener(GeometryListener listener);
	
	
	/**
	 * Renvoie la geometrie au format WKT
	 */
	public String asText();
}
