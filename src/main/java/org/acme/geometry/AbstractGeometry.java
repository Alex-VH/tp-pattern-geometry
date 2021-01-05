package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

	public String asText() {
		WktVisitor visitor = new WktVisitor();
		accept(visitor);
		return visitor.getResult();
	}
	
	
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		accept(builder);
		return builder.build();
	}
	
	public abstract Geometry clone();

}
