package org.acme.geometry;

public class EnveloppeBuilder implements GeometryVisitor{
	
	protected Enveloppe enveloppe;
	
	/**
	 * Constructeur vide de la classe
	 */
	public EnveloppeBuilder() {
		this.enveloppe = new Enveloppe();
	}
	
	
	/**
	 * Methode permettant de mettre à jour la valeur de l'enveloppe
	 * si la coordonnée passée en parametre depasse un des extremes
	 * déjà stocké
	 * @param coordinate
	 */
	public void insert(Coordinate coordinate) {
		
//		Si l'enveloppe est vide on lui attribue directement les 
//		valeurs de la coordonnée
		if (enveloppe.isEmpty()) {
			enveloppe = new Enveloppe(
					new Coordinate(coordinate.getX(),coordinate.getY()),
					new Coordinate(coordinate.getX(),coordinate.getY()));
		}
		
//		Sinon on fait les tests sur les 4 extremes
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
	
	
	
	/**
	 * Renvoie l'enveloppe de la classe
	 * @return
	 */
	public Enveloppe build() {
		return enveloppe;
	}


	@Override
	public void visit(Point point) {
		insert(point.getCoordinate());	
	}


	@Override
	public void visit(LineString lineString) {
		for(int i = 0; i < lineString.getNumPoints(); i++) {
			insert(lineString.getPointN(i).getCoordinate());
		}
		
	}
}
