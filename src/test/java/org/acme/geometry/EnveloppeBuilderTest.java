package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;

public class EnveloppeBuilderTest {
	
	public static final double EPSILON = 1.0e-15;

	
	/**
	 * Teste si l'insertion de la coordonnée et donc la maj de l'enveloppe se fait bien
	 */
	@Test
	public void testInsert() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		builder.insert(Sample.coordinate0());
		builder.insert(Sample.coordinateA());
		
		Assert.assertEquals(0.0,builder.enveloppe.getXmin(), EPSILON);
		Assert.assertEquals(0.0,builder.enveloppe.getYmin(), EPSILON);
		Assert.assertEquals(3.0,builder.enveloppe.getXmax(), EPSILON);
		Assert.assertEquals(5.0,builder.enveloppe.getYmax(), EPSILON);
	}

	
	/**
	 * Teste si la construction de l'enveloppe à l'aide du builder fonctionne
	 */
	@Test
	public void testBuild() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		builder.insert(Sample.coordinate0());
		builder.insert(Sample.coordinateA());
		
		Enveloppe e = builder.build();
		
		Assert.assertEquals(0.0,e.getXmin(), EPSILON);
		Assert.assertEquals(0.0,e.getYmin(), EPSILON);
		Assert.assertEquals(3.0,e.getXmax(), EPSILON);
		Assert.assertEquals(5.0,e.getYmax(), EPSILON);
	}
}
