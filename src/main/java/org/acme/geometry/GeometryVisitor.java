package org.acme.geometry;

public interface GeometryVisitor {
	
	/**
	 * Methode à implémenter pour un visiteur de la classe point
	 * @param point
	 */
	public void visit(Point point);
	
	
	/**
	 * Methode à implémenter pour un visiteur de la classe lineString
	 * @param point
	 */
	public void visit(LineString lineString);
}
