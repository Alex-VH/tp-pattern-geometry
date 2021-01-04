package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;




public class PointTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testPoint() {
		Point p = new Point();
		Assert.assertEquals(p.getCoordinate().getX(), 0.0,EPSILON);
		Assert.assertEquals(p.getCoordinate().getY(), 0.0,EPSILON);
		
	}

	@Test
	public void testPointCoordinate() {
		Coordinate c = new Coordinate();
		Point p = new Point(c);
		Assert.assertEquals(p.getCoordinate().getX(), 0.0,EPSILON);
		Assert.assertEquals(p.getCoordinate().getY(), 0.0,EPSILON);
		
				
	}

	@Test
	public void testGetType() {
		Point p = new Point();
		Assert.assertEquals("Point",p.getType());
	}

}
