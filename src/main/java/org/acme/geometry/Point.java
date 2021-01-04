package org.acme.geometry;

public class Point implements Geometry {
	
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

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
	public void translate(double x, double y) {
		this.coordinate.setX(this.coordinate.getX() + x);
		this.coordinate.setY(this.coordinate.getY() + y);
	}
	
	
	@Override
	public Geometry clone() {
		try {
			Geometry clone = (Point)super.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}

}
