package org.acme.geometry;



import org.junit.Test;
import org.junit.Assert;

public class WktWriterTest {

	
	/**
	 * Test si le formatage en Wkt a focntionné
	 */
	@Test
	public void testWrite() {
		WktWriter writer = new WktWriter();
		Point p = Sample.pointEmpty();
		String sp = writer.write(p);
		
		Point p2 = Sample.pointA();
		String sp2 = writer.write(p2);
		
		LineString l = Sample.lineStringEmpty();
		String sl = writer.write(l);
		
		LineString l2 = Sample.LineString0A();
		String sl2 = writer.write(l2);

		Assert.assertEquals("POINT EMPTY", sp);
		Assert.assertEquals("POINT(3.0 5.0)", sp2);
		Assert.assertEquals("LINESTRING EMPTY", sl);
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 5.0)", sl2);
		
	}

}
