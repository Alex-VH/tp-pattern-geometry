package org.acme.geometry;

public class GeometryWithCachedEnveloppe implements Geometry {
	
	private Geometry original;
	private Enveloppe cachedEnveloppe;
	
	public GeometryWithCachedEnveloppe(Geometry original) {
		this.original = original;
		this.cachedEnveloppe = original.getEnveloppe();
	}

	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double x, double y) {
		this.original.translate(x, y);
	}

	@Override
	public GeometryWithCachedEnveloppe clone() {
		return new GeometryWithCachedEnveloppe(this.original);
	}

	@Override
	public Enveloppe getEnveloppe() {
		return this.cachedEnveloppe;
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.accept(visitor);
		
	}
}
