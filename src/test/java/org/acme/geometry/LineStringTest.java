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
		assertEquals(0.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		assertEquals(0.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
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
		assertEquals(0.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		assertEquals(0.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testGetPointNNotEmptyList() {
		Point p = new Point();
		List<Point> points = new ArrayList<Point>();
		points.add(p);
		LineString l = new LineString(points);
		assertEquals(1,l.getNumPoints());
	}
	
	@Test
//	public void testGetPointNEmptyList() {
//		LineString l = new LineString();
//		assertEquals(null,l.getPointN(0));
//	}

	@Test
	public void testGetType() {
		LineString l = new LineString();
		assertEquals("LineString",l.getType());
	}

}
