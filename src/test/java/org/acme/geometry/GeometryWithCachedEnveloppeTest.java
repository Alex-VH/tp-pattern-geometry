package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class GeometryWithCachedEnveloppeTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testGeometryWithCachedEnveloppe() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		assertSame(a,b);
	}
	
	
	@Test
	public void testTranslate() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		assertSame(a,b);
		
		
		g.translate(1.0, 1.0);
		assertEquals(4.0, g.getEnveloppe().getXmin(),EPSILON);
		
	}
	
	
	@Test
	public void testOnChange() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		assertSame(a,b);
		
		g.translate(1.0, 1.0);
		Enveloppe c = g.getEnveloppe() ; // renvoi de cachedEnvelope
		assertSame(a,b);
		assertNotSame(a,c);
	}

}
