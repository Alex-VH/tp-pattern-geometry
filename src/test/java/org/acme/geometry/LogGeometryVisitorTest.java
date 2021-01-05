package org.acme.geometry;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {

	
	/**
	 * Teste si l'affichage des logs d'un point est bon
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testVisitPoint() throws UnsupportedEncodingException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = Sample.pointA();
		geometry.accept(visitor);
		// result contiendra ce qui est écrit dans la console
		String result = os.toString("UTF8");

		Assert.assertEquals("Je suis un point avec x=3.0 et y =5.0",result);
	}

	
	/**
	 * Teste si l'affichage des logs d'une polyligne est bon
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testVisitLineString() throws UnsupportedEncodingException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = Sample.LineString0A();
		geometry.accept(visitor);
		// result contiendra ce qui est écrit dans la console
		String result = os.toString("UTF8");

		Assert.assertEquals("Je suis une polyligne définie par 2 point(s)",result);
	}

}
