package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DebugGraphics;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testLineString() {
		LineString l = new LineString();
		assertEquals(l.getNumPoints(),0);
	}

	@Test
	public void testLineStringListOfPoint() {
		Point p = new Point();
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		LineString l = new LineString(points);
		assertEquals(1,l.getNumPoints());
		assertEquals(Double.NaN,l.getPointN(0).getCoordinate().getX(),EPSILON);
		assertEquals(Double.NaN,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testGetNumPointsEmptyList() {
		LineString l = new LineString();
		assertEquals(0,l.getNumPoints());
	}
	
	@Test
	public void testGetNumPointsNotEmptyList() {
		Point p = new Point();
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		LineString l = new LineString(points);
		assertEquals(Double.NaN,l.getPointN(0).getCoordinate().getX(),EPSILON);
		assertEquals(Double.NaN,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testGetPointNNotEmptyList() {
		Point p = new Point();
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		LineString l = new LineString(points);
		assertEquals(1,l.getNumPoints());
	}
	
//	@Test
//	public void testGetPointNEmptyList() {
//		LineString l = new LineString();
//		assertEquals(null,l.getPointN(0));
//	}

	@Test
	public void testGetType() {
		LineString l = new LineString();
		assertEquals("LineString",l.getType());
	}
	
	
	@Test
	public void testTranslate() {
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		LineString l = new LineString(points);
		l.translate(1.0, 1.0);
		Assert.assertEquals(1.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}
	
	
	@Test
	public void testClone() {
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		LineString l = new LineString(points);
		LineString copy = l.clone();
		copy.translate(1.0, 1.0);
		
		Assert.assertEquals(0.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(0.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,copy.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,copy.getPointN(0).getCoordinate().getY(),EPSILON);
		
		
	}

}
