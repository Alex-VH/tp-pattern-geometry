package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {

	public static final double EPSILON = 1.0e-15;
	
	
	/**
	 * Teste si l'affichage au format WKT fonctionne
	 */
	@Test
	public void testAsText() {
		AbstractGeometry geometry = Sample.pointA();
		assertEquals( "POINT(3.0 5.0)", geometry.asText() );
		
		AbstractGeometry geometry2 = Sample.LineString0A();
		assertEquals("LINESTRING(0.0 0.0,3.0 5.0)", geometry2.asText());
	}
	
	
	/**
	 * Teste si l'enveloppe des geometries point et ligne est correcte
	 */
	@Test
	public void testGetEnveloppe() {
		AbstractGeometry geometry = Sample.point0();
		Enveloppe e = geometry.getEnveloppe();
		
		Assert.assertEquals(0.0,e.getXmin(), EPSILON);
		Assert.assertEquals(0.0,e.getYmin(), EPSILON);
		Assert.assertEquals(0.0,e.getXmax(), EPSILON);
		Assert.assertEquals(0.0,e.getYmax(), EPSILON);
		
		AbstractGeometry geometry2 = Sample.LineString0A();
		Enveloppe e2 = geometry2.getEnveloppe();
		
		Assert.assertEquals(0.0,e2.getXmin(), EPSILON);
		Assert.assertEquals(0.0,e2.getYmin(), EPSILON);
		Assert.assertEquals(3.0,e2.getXmax(), EPSILON);
		Assert.assertEquals(5.0,e2.getYmax(), EPSILON);
		
	}

}
