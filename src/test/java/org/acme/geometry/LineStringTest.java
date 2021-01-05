package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;

	
	/**
	 * Teste le constructeur vide
	 */
	@Test
	public void testLineString() {
		LineString l = new LineString();
		Assert.assertEquals(l.getNumPoints(),0);
	}

	
	/**
	 * Teste le constructeur avec la liste de point 
	 */
	@Test
	public void testLineStringListOfPoint() {
		LineString l = Sample.LineStringA();
		
		Assert.assertEquals(1,l.getNumPoints());
		Assert.assertEquals(3.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}

	
	/**
	 * Teste la méthode de récupération du nombre de point avec une liste vide
	 */
	@Test
	public void testGetNumPointsEmptyList() {
		LineString l = new LineString();
		Assert.assertEquals(0,l.getNumPoints());
	}
	
	
	/**
	 * Teste la méthode de récupération du nombre de point avec une liste non vide
	 */
	@Test
	public void testGetNumPointsNotEmptyList() {
		LineString l = Sample.LineStringA();
		Assert.assertNotEquals(0,l.getNumPoints());
		Assert.assertEquals(1,l.getNumPoints());
	}

	
	/**
	 * Teste la méthode de récupération de point avec une liste non vide
	 */
	@Test
	public void testGetPointNNotEmptyList() {
		LineString l = Sample.LineStringA();
		Assert.assertEquals(3.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}
	

	/**
	 * Teste si la valeur de retour de la méthode getType est bonne
	 */
	@Test
	public void testGetType() {
		LineString l = new LineString();
		Assert.assertEquals("LineString",l.getType());
	}
	
	
	/**
	 * Teste si la méthode isEmpty renvoie bien true si les coordonnées de la polyligne ne sont
	 * pas initialisées (NaN) et false sinon
	 */
	@Test
	public void testIsEmpty() {
		LineString l = Sample.lineStringEmpty();
		Assert.assertEquals(true, l.isEmpty());
		
		LineString l2 = Sample.LineStringA();
		Assert.assertEquals(false, l2.isEmpty());
		
		
	}
	
	
	/**
	 * Teste si la méthode de translation agit bien sur la polyligne
	 */
	@Test
	public void testTranslate() {
		LineString l = Sample.LineStringA();
		l.translate(1.0, 1.0);
		Assert.assertEquals(4.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(6.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
	}
	
	
	/**
	 * Teste si la méthode de clonage fonctionne (pas de probleme memoire)
	 */
	@Test
	public void testClone() {
		LineString l = Sample.LineStringA();
		LineString copy = l.clone();
		
		Assert.assertNotSame(l.getPointN(0),copy.getPointN(0));
		Assert.assertEquals(3.0,l.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0,l.getPointN(0).getCoordinate().getY(),EPSILON);
		Assert.assertEquals(3.0,copy.getPointN(0).getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0,copy.getPointN(0).getCoordinate().getY(),EPSILON);	
	}
	
	
	/**
	 * Teste si la méthode d'acquisition d'enveloppe renvoie les bonnes valeurs
	 */
	@Test
	public void testGetEnveloppe() {
		LineString l = Sample.LineString0A();
		Enveloppe e = l.getEnveloppe();
		
		Assert.assertEquals(0.0, e.getXmin(),EPSILON);
		Assert.assertEquals(3.0, e.getXmax(),EPSILON);
		Assert.assertEquals(0.0, e.getYmin(),EPSILON);
		Assert.assertEquals(5.0, e.getYmax(),EPSILON);
	}
}
