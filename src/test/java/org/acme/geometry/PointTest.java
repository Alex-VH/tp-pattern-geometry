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
		Point p = Sample.pointA();
		Assert.assertEquals(3.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5.0, p.getCoordinate().getY(), EPSILON);
		
				
	}

	@Test
	public void testGetType() {
		Point p = new Point();
		Assert.assertEquals("Point",p.getType());
	}
	
	@Test
	public void testEmpty() {
		Point p = new Point(new Coordinate());
		Assert.assertEquals(true, p.isEmpty());
	}
	
	
	@Test
	public void testTranslate() {
		Point p = Sample.point0();
		p.translate(1.0, 1.0);
		Assert.assertEquals(1.0,p.getCoordinate().getY(),EPSILON);
		Assert.assertEquals(1.0,p.getCoordinate().getY(),EPSILON);
	}

	@Test
	public void testClone() {
		Point p = Sample.point0();
		Point copy = p.clone();
		
		Assert.assertNotSame(p, copy);
		Assert.assertSame(p.getCoordinate(), copy.getCoordinate());
				
	}
	
	@Test
	public void testGetEnveloppe() {
		Point p = Sample.pointA();
		Enveloppe e = p.getEnveloppe();
		
		Assert.assertEquals(3.0, e.getXmin(),EPSILON);
		Assert.assertEquals(3.0, e.getXmax(),EPSILON);
		Assert.assertEquals(5.0, e.getYmin(),EPSILON);
		Assert.assertEquals(5.0, e.getYmax(),EPSILON);
	}
}
