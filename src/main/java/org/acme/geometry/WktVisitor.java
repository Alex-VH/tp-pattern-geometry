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
		this.write(this.buffer,point);
	}

	@Override
	public void visit(LineString lineString) {
		this.write(this.buffer,lineString);
	}
	
	
	private void write(StringBuilder s, Coordinate c) {
		if(c.isEmpty()) {
			return;
		}
		s.append(c.getX());
		s.append(" ");
		s.append(c.getY());
	}
	
	private void write(StringBuilder s, Point p) {
		s.append("POINT");
		if(p.isEmpty()) {
			s.append(" EMPTY");
			return;
		}
		
		s.append("(");
		this.write(s, p.getCoordinate());
		s.append(")");
			
	}
	
	
	private void write(StringBuilder s, LineString l) {
		s.append("LINESTRING");
		if(l.isEmpty()) {
			s.append(" EMPTY");
			return;
		}
		s.append("(");
		for(int i = 0; i < l.getNumPoints(); i++) {
			this.write(s,l.getPointN(i).getCoordinate());
			if (i < l.getNumPoints() -1) {
				s.append(",");
			}
		}
		s.append(")");
		
	}

}
