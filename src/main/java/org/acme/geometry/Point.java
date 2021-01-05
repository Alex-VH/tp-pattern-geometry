package org.acme.geometry;

public class Point extends AbstractGeometry {
	
	private Coordinate coordinate;
	
	/**
	 * Constructeur vide la classe
	 */
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	/**
	 * Constructeur de la classe prenant des coordonnées en paramètre
	 * @param coordinate
	 */
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	
	/**
	 * Getter des coordonnées de la classe
	 * @return
	 */
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	
	@Override
	public String getType() {
		return "Point";
	}
	
	
	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	
	@Override
	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(
				(this.coordinate.getX() + dx),
				(this.coordinate.getY() + dy));
		this.triggerChange();
	}
	
	
	@Override
	public Point clone() {
		return new Point(this.coordinate);	
	}

	
	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		builder.insert(this.coordinate);
		return builder.build();
	}
	
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
