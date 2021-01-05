package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractGeometryTest {

	@Test
	public void testAsText() {
		AbstractGeometry geometry = Sample.pointA();
		assertEquals( "POINT(3.0 5.0)", geometry.asText() );
		
		AbstractGeometry geometry2 = Sample.LineString0A();
		assertEquals("LINESTRING(0.0 0.0,3.0 5.0)", geometry2.asText());
	}

}
