package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class WktVisitorTest {


	@Test
	public void testGetResult() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = Sample.pointA();
		geometry.accept(visitor);
		assertEquals( "POINT(3.0 5.0)", visitor.getResult() );

		WktVisitor visitor2 = new WktVisitor();
		Geometry geometry2 = Sample.LineString0A();
		geometry2.accept(visitor2);
		assertEquals("LINESTRING(0.0 0.0,3.0 5.0)", visitor2.getResult());
	}

}
