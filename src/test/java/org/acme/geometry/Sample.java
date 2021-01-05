package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	
	public static Coordinate coordinateEmpty() {
		return new Coordinate();
	}
	
	public static Coordinate coordinate0() {
		return new Coordinate(0.0,0.0);
	}
	
	public static Coordinate coordinateA() {
		return new Coordinate(3.0,5.0);
	}
		
	
	public static Point pointEmpty() {
		return new Point();
	}
	
	public static Point point0() {
		return new Point(coordinate0());
	}
	
	
	public static Point pointA() {
		return new Point(coordinateA());
	}
	
	
	public static LineString lineStringEmpty() {
		return new LineString();
	}
	
	public static LineString LineStringA() {
		List<Point> points = new ArrayList<Point>();
		points.add(pointA());
		LineString l = new LineString(points);
		return l;
	}

}
