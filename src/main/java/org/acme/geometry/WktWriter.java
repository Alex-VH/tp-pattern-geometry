package org.acme.geometry;

public class WktWriter {
	
	public WktWriter() {}
	
	
	/**
	 * Méthode permettant d'afficher une géométrie au format WKT
	 * @param geometry
	 * @return
	 */
	public String write(Geometry geometry) {
		String s = "";

		if (geometry.getType() == "Point") {
			s += "POINT";
			Point p = (Point)geometry;
			if (p.isEmpty()) {
				s += " EMPTY";
			}
			else {
				s = s + "("+ p.getCoordinate().getX() + " " + p.getCoordinate().getY() + ")";
			}
		}
		
		else if (geometry.getType() == "LineString") {
			s += "LINESTRING";
			LineString l = (LineString)geometry;
			if (l.isEmpty()) {
				s += " EMPTY";
			}
			else {
				s += "(";
				for(int i = 0; i < l.getNumPoints(); i++) {
					s = s + l.getPointN(i).getCoordinate().getX() + " " + l.getPointN(i).getCoordinate().getY();
					if (i < l.getNumPoints() -1) {
						s += ",";
					}
				}
				s += ")";
			}		
		}
		else {
			throw new RuntimeException("geometry type not supported");
		}
		return s;
	}

}
