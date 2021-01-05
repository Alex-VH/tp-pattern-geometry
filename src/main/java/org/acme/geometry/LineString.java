package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry, Cloneable {
	
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
	public LineString clone() {
		
		List<Point> newPoints = new ArrayList<Point>(getNumPoints());
		for(int i = 0; i < this.points.size(); i++) {
			newPoints.add(this.getPointN(i).clone());
		}
		return new LineString(newPoints);
		
	}
	
	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		for(int i = 0; i < this.getNumPoints(); i++) {
			builder.insert(this.getPointN(i).getCoordinate());
		}
		return builder.build();
	}
}
