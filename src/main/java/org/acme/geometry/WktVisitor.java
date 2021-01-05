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
		this.write(point);
	}

	@Override
	public void visit(LineString lineString) {
		this.write(lineString);
	}
	
	
	private void write(Coordinate c) {
		if(c.isEmpty()) {
			return;
		}
		this.buffer.append(c.getX());
		this.buffer.append(" ");
		this.buffer.append(c.getY());
	}
	
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
