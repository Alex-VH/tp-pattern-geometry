package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;




public class PointTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testPoint() {
		Point p = new Point();
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(),EPSILON);
		
	}

	@Test
	public void testPointCoordinate() {
		Coordinate c = new Coordinate();
		Point p = new Point(c);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
		
				
	}

	@Test
	public void testGetType() {
		Point p = new Point();
		Assert.assertEquals("Point",p.getType());
	}
	
	
	@Test
	public void testTranslate() {
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		p.translate(1.0, 1.0);
		Assert.assertEquals(1.0,p.getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,p.getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testClone() {
		Coordinate c = new Coordinate(0.0,0.0);
		Point p = new Point(c);
		Point copy = p.clone();
		copy.translate(1.0, 1.0);
		
		Assert.assertEquals(0.0,p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(0.0,p.getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,copy.getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,copy.getCoordinate().getY(),EPSILON);
		
		
	}
}
