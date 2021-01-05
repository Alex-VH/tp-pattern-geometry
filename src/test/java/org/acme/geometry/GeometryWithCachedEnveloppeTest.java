package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeometryWithCachedEnveloppeTest {

	@Test
	public void testGeometryWithCachedEnveloppe() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		assertSame(a,b);
	}

}
