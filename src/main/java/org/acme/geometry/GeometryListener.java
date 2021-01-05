package org.acme.geometry;

public interface GeometryListener {
	
	/**
	 * Méthode définissant l'action à réaliser en cas de changement 
	 * (du listener)
	 * @param geometry
	 */
	public void onChange(Geometry geometry);
}
