package org.acme.geometry;

public class Coordinate {
	public double x;
	public double y;
	
	public Coordinate() {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
		
	
	public boolean isEmpty() {
		return Double.isNaN(x);
	}
}
