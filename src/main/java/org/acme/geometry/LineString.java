package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> points;
	
	public LineString(){
		this.points = new ArrayList<Point>();
	}
	
	
	public LineString(List<Point> points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}
	
	
	@Override
	public String getType() {
		return "LineString";
	}
	
	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}

	
	@Override
	public void translate(double x, double y) {
		for(int i = 0; i < this.points.size(); i++) {
			this.points.get(i).translate(x, y);
		}
	}
	
	
	@Override
	public Geometry clone() {
		try {
			Geometry clone = (LineString)super.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
}
