package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	
	/**
	 * Teste le constructeur vide
	 */
	@Test
	public void testDefaultConstructor(){
		
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(),EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
	}
	
	
	/**
	 * Teste le constructeur avec les coordonnées selon x et y
	 */
	@Test
	public void testXYConstructor() {
		Coordinate c = Sample.coordinateA();
		Assert.assertEquals(3.0, c.getX(), EPSILON);
		Assert.assertEquals(5.0, c.getY(), EPSILON);
	}
	
	
	/**
	 * Teste si la méthode isEmpty renvoie bien true si les coordonnées ne sont
	 * pas initialisées (NaN) et false sinon
	 */
	@Test
	public void testIsEmpty() {
		Coordinate c = new Coordinate();
		Assert.assertEquals(true, c.isEmpty());
		
		Coordinate c2 = Sample.coordinate0();
		Assert.assertEquals(false, c2.isEmpty());
	}

}
