package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(),EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
	}
	
	@Test
	public void testXYConstructor() {
		Coordinate c = new Coordinate(4.0,5.0);
		Assert.assertEquals(4.0, c.getX(), EPSILON);
		Assert.assertEquals(5.0, c.getY(), EPSILON);
	}
	
	@Test
	public void testIsEmpty() {
		Coordinate c = new Coordinate();
		Assert.assertEquals(true, c.isEmpty());
	}

}
