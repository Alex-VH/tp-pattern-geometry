package org.acme.geometry;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class LogGeometryVisitorTest {

	
   
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
