package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
	
	private StringBuilder buffer;
	
	
	/**
	 * Constructeur vide de la classe
	 */
	public WktVisitor() {
		this.buffer = new StringBuilder();
	}
	
	
	/**
	 * Constructeur prenant en paramètre un buffer de caractères
	 * @param buffer
	 */
	public WktVisitor(StringBuilder buffer) {
		this.buffer = buffer;
	}
	
	
	/**
	 * Renvoie le résultat de la conversion de l'affichage de la 
	 * géométrie au format WKT
	 * @return
	 */
	public String getResult() {
		return this.buffer.toString();
	}
	

	@Override
	public void visit(Point point) {
		this.write(point);
	}

	
	@Override
	public void visit(LineString lineString) {
		this.write(lineString);
	}
	
	
	
	/**
	 * Méthode permettant de convertir l'affichage d'une coordonnée au 
	 * format WKT
	 * @param c
	 */
	private void write(Coordinate c) {
		if(c.isEmpty()) {
			return;
		}
		this.buffer.append(c.getX());
		this.buffer.append(" ");
		this.buffer.append(c.getY());
	}
	
	
	/**
	 * Méthode permettant de convertir l'affichage d'un point au 
	 * format WKT
	 * @param p
	 */
	private void write(Point p) {
		this.buffer.append("POINT");
		if(p.isEmpty()) {
			this.buffer.append(" EMPTY");
			return;
		}
		
		this.buffer.append("(");
		this.write(p.getCoordinate());
		this.buffer.append(")");
			
	}
	
	
	/**
	 * Méthode permettant de convertir l'affichage d'une polyligne au 
	 * format WKT
	 * @param l
	 */
	private void write(LineString l) {
		this.buffer.append("LINESTRING");
		if(l.isEmpty()) {
			this.buffer.append(" EMPTY");
			return;
		}
		this.buffer.append("(");
		for(int i = 0; i < l.getNumPoints(); i++) {
			this.write(l.getPointN(i).getCoordinate());
			if (i < l.getNumPoints() -1) {
				this.buffer.append(",");
			}
		}
		this.buffer.append(")");
	}

}
