package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EnveloppeTest {

	public static final double EPSILON = 1.0e-15;
	
//	@Test
//	public void testEnveloppe() {
//		Enveloppe e = Sample.enveloppeEmpty();
//		Assert.assertEquals(Double.NaN, e.getXmin(),EPSILON);
//		Assert.assertEquals(Double.NaN, e.getXmax(),EPSILON);
//		Assert.assertEquals(Double.NaN, e.getYmin(),EPSILON);
//		Assert.assertEquals(Double.NaN, e.getYmax(),EPSILON);
//		
//	}
//
//	@Test
//	public void testEnveloppeCoordinateCoordinate() {
//		Enveloppe e = Sample.enveloppe0A();
//		Assert.assertEquals
//	}

	@Test
	public void testIsEmpty() {
		Enveloppe e =  Sample.enveloppeEmpty();
		Assert.assertEquals(true,e.isEmpty());
	}

	@Test
	public void testGetXmin() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(0.0, e.getXmin(),EPSILON);
	}

	@Test
	public void testGetXmax() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(3.0, e.getXmax(),EPSILON);
	}

	@Test
	public void testGetYmin() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(0.0, e.getYmin(),EPSILON);
	}

	@Test
	public void testGetYmax() {
		Enveloppe e = Sample.enveloppe0A();
		Assert.assertEquals(5.0, e.getYmax(),EPSILON);
	}

}
