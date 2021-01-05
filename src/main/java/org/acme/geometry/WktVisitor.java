package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
	
	private StringBuilder buffer;
	
	
	public WktVisitor() {
		this.buffer = new StringBuilder();
	}
	
	public WktVisitor(StringBuilder buffer) {
		this.buffer = buffer;
	}
	
	public String getResult() {
		return this.buffer.toString();
	}
	

	@Override
	public void visit(Point point) {
		String s = "POINT";
		if(point.isEmpty()) {
			s += " EMPTY";
		}
		else {
			s = s + "("+ point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
		}
		this.buffer = new StringBuilder(s);
	}

	@Override
	public void visit(LineString lineString) {
		String s = "LINESTRING";
		if(lineString.isEmpty()) {
			s += " EMPTY";
		}
		else {
			s += "(";
			for(int i = 0; i < lineString.getNumPoints(); i++) {
				s = s + lineString.getPointN(i).getCoordinate().getX() + " " + lineString.getPointN(i).getCoordinate().getY();
				if (i < lineString.getNumPoints() -1) {
					s += ",";
				}
			}
			s += ")";
		}
		this.buffer = new StringBuilder(s);

	}

}
