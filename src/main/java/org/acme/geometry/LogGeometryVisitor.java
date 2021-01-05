package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
	
	
	private PrintStream out;
	
	public LogGeometryVisitor() {
		this(System.out);
	}
	
	public LogGeometryVisitor(PrintStream out) {
		this.out =out;
	}
	

	@Override
	public void visit(Point point) {
		String s = "Je suis un point avec x=" + point.getCoordinate().getX() + " et y =" + point.getCoordinate().getY();
		s = s.replaceAll("\\n", "").replaceAll("\\r","");
		out.print(s);
	}

	@Override
	public void visit(LineString lineString) {
		String s = "Je suis une polyligne définie par " + lineString.getNumPoints() + " point(s)";
		s = s.replaceAll("\\n", "").replaceAll("\\r","");
		out.print(s);
	}

}
