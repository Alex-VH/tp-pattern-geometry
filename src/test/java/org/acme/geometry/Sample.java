package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	
	
	/**
	 * Coordonnées vides NaN
	 * @return
	 */
	public static Coordinate coordinateEmpty() {
		return new Coordinate();
	}
	
	
	/**
	 * Coordonnées en 0 0
	 * @return
	 */
	public static Coordinate coordinate0() {
		return new Coordinate(0.0,0.0);
	}
	
	
	/**
	 * Coordonnées en 3 5
	 * @return
	 */
	public static Coordinate coordinateA() {
		return new Coordinate(3.0,5.0);
	}
		
	
	/**
	 * Point vide NaN
	 * @return
	 */
	public static Point pointEmpty() {
		return new Point();
	}
	
	
	/**
	 * Point en 0 0
	 * @return
	 */
	public static Point point0() {
		return new Point(coordinate0());
	}
	
	
	/**
	 * Point en 3 5
	 * @return
	 */
	public static Point pointA() {
		return new Point(coordinateA());
	}
	
	
	/**
	 * Ligne vide NaN
	 * @return
	 */
	public static LineString lineStringEmpty() {
		return new LineString();
	}
	
	
	/**
	 * Ligne composée d un point 3 5
	 * @return
	 */
	public static LineString LineStringA() {
		List<Point> points = new ArrayList<Point>();
		points.add(pointA());
		LineString l = new LineString(points);
		return l;
	}

	
	/**
	 * Ligne composée de 2 point 0 0, 3 5
	 * @return
	 */
	public static LineString LineString0A() {
		List<Point> points = new ArrayList<Point>();
		points.add(point0());
		points.add(pointA());
		LineString l = new LineString(points);
		return l;
	}
	
	
	/**
	 * Enveloppe vide NaN
	 * @return
	 */
	public static Enveloppe enveloppeEmpty() {
		return new Enveloppe();
	}
	
	
	/**
	 * Enveloppe compsée des points 0 0, 3 5
	 * @return
	 */
	public static Enveloppe enveloppe0A() {
		return new Enveloppe(coordinate0(),coordinateA());
	}
}
