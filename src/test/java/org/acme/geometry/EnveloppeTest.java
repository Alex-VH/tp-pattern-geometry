package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;

public class EnveloppeTest {

	public static final double EPSILON = 1.0e-15;
	

	/**
	 * Teste si la méthode isEmpty renvoie bien true si les coordonnées de l'enveloppe ne sont
	 * pas initialisées (NaN) et false sinon
	 */
	@Test
	public void testIsEmpty() {
		Enveloppe e =  Sample.enveloppeEmpty();
		Assert.assertEquals(true,e.isEmpty());
		
		Enveloppe e2 = Sample.enveloppe0A();
		Assert.assertEquals(false,e2.isEmpty());
	}

	
	/**
	 * Teste si la méthode getXmin renvoie le min selon x
	 */
	@Test
	public void testGetXmin() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(0.0, e.getXmin(),EPSILON);
	}

	
	/**
	 * Teste si la méthode getXmax renvoie le max selon x
	 */
	@Test
	public void testGetXmax() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(3.0, e.getXmax(),EPSILON);
	}

	
	/**
	 * Teste si la méthode getYmin renvoie le min selon y
	 */
	@Test
	public void testGetYmin() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(0.0, e.getYmin(),EPSILON);
	}

	
	/**
	 * Teste si la méthode getYmax renvoie le max selon y
	 */
	@Test
	public void testGetYmax() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(5.0, e.getYmax(),EPSILON);
	}

}
