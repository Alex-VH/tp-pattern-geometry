package org.acme.geometry;


import org.junit.Test;
import org.junit.Assert;

public class GeometryWithCachedEnveloppeTest {
	
	public static final double EPSILON = 1.0e-15;

	
	/**
	 * Teste si le constructeur vide de la classe fonctionne
	 */
	@Test
	public void testGeometryWithCachedEnveloppe() {
		Geometry g = Sample.pointA();
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		Assert.assertSame(a,b);
	}
	
	
	/**
	 * Teste si la méthode translate modifie bien les coordonnée de la géométrie
	 */
	@Test
	public void testTranslate() {
		Geometry g = Sample.pointA();
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		Assert.assertSame(a,b);
		
		
		g.translate(1.0, 1.0);
		Assert.assertEquals(4.0, g.getEnveloppe().getXmin(),EPSILON);
		Assert.assertEquals(6.0, g.getEnveloppe().getYmin(),EPSILON);
		Assert.assertEquals(4.0, g.getEnveloppe().getXmax(),EPSILON);
		Assert.assertEquals(6.0, g.getEnveloppe().getYmax(),EPSILON);
	}
	
	
	/**
	 * Teste si la fonction onChange est bien appelée lors du changement des coordonnées (translate)
	 */
	@Test
	public void testOnChange() {
		Geometry g = Sample.pointA();
		// décoration
		g = new GeometryWithCachedEnveloppe(g);
		
		Enveloppe a = g.getEnveloppe() ; // calcul et stockage dans cachedEnvelope
		Enveloppe b = g.getEnveloppe() ; // renvoi de cachedEnvelope
		Assert.assertSame(a,b);
		
		g.translate(1.0, 1.0);
		Enveloppe c = g.getEnveloppe() ; // renvoi de cachedEnvelope
		Assert.assertSame(a,b);
		Assert.assertNotSame(a,c);
		Assert.assertEquals(4.0, g.getEnveloppe().getXmin(),EPSILON);
		Assert.assertEquals(6.0, g.getEnveloppe().getYmin(),EPSILON);
		Assert.assertEquals(4.0, g.getEnveloppe().getXmax(),EPSILON);
		Assert.assertEquals(6.0, g.getEnveloppe().getYmax(),EPSILON);
	}
}
