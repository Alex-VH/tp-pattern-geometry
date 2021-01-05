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
		LineString l = Sample.LineStringA();
		
		assertEquals(1,l.getNumPoints());
		assertEquals(3.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		assertEquals(5.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testGetNumPointsEmptyList() {
		LineString l = new LineString();
		assertEquals(0,l.getNumPoints());
	}
	
	@Test
	public void testGetNumPointsNotEmptyList() {
		LineString l = Sample.LineStringA();
		assertNotEquals(0,l.getNumPoints());
		assertEquals(1,l.getNumPoints());
	}

	@Test
	public void testGetPointNNotEmptyList() {
		LineString l = Sample.LineStringA();
		assertEquals(3.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		assertEquals(5.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
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
	public void testIsEmpty() {
		LineString l = Sample.lineStringEmpty();
		
		Assert.assertEquals(true, l.isEmpty());
	}
	
	
	@Test
	public void testTranslate() {
		LineString l = Sample.LineStringA();
		l.translate(1.0, 1.0);
		Assert.assertEquals(4.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(6.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}
	
	
	@Test
	public void testClone() {
		LineString l = Sample.LineStringA();
		LineString copy = l.clone();
		
		
		Assert.assertNotSame(l.getPointN(0),copy.getPointN(0));
		Assert.assertEquals(3.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(3.0,copy.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0,copy.getPointN(0).getCoordinate().getY(),EPSILON);	
	}
	
	@Test
	public void testGetEnveloppe() {
		LineString l = Sample.LineString0A();
		Enveloppe e = l.getEnveloppe();
		
		Assert.assertEquals(0.0, e.getXmin(),EPSILON);
		Assert.assertEquals(3.0, e.getXmax(),EPSILON);
		Assert.assertEquals(0.0, e.getYmin(),EPSILON);
		Assert.assertEquals(5.0, e.getYmax(),EPSILON);
	}

}
