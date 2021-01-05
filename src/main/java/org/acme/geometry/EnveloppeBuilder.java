package org.acme.geometry;

public class EnveloppeBuilder {
	
	protected Enveloppe enveloppe;
	
	
	public EnveloppeBuilder() {
		this.enveloppe = new Enveloppe();
	}
	
	
	public void insert(Coordinate coordinate) {
		
		if (enveloppe.isEmpty()) {
			enveloppe = new Enveloppe(
					new Coordinate(coordinate.getX(),coordinate.getY()),
					new Coordinate(coordinate.getX(),coordinate.getY()));
		}
		else {
			double xmin = enveloppe.getXmin();
			double xmax = enveloppe.getXmax();
			double ymin = enveloppe.getYmin();
			double ymax = enveloppe.getYmax();
			
			if (coordinate.getX() < xmin) {
				xmin = coordinate.getX();
			}
			if (coordinate.getX() > xmax) {
				xmax = coordinate.getX();
			}
			if (coordinate.getY() < ymin) {
				ymin = coordinate.getY();
			}
			if (coordinate.getY() > ymax) {
				ymax = coordinate.getY();
			}
			
			enveloppe = new Enveloppe(
					new Coordinate(xmin,ymin),
					new Coordinate(xmax,ymax));		
		}
		
	}
	
	public Enveloppe build() {
		return enveloppe;
	}
}
