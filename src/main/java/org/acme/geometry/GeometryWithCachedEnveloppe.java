package org.acme.geometry;

public class GeometryWithCachedEnveloppe implements Geometry, GeometryListener {
	
	private Geometry original;
	private Enveloppe cachedEnveloppe;
	
	public GeometryWithCachedEnveloppe(Geometry original) {
		this.original = original;
		this.original.addListener(this);
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
		return new GeometryWithCachedEnveloppe(this.original.clone());
	}

	@Override
	public Enveloppe getEnveloppe() {
		if (this.cachedEnveloppe == null) {
			this.cachedEnveloppe = this.original.getEnveloppe();
		}
		return this.cachedEnveloppe;
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.accept(visitor);
		
	}

	@Override
	public void onChange(Geometry geometry) {
		this.cachedEnveloppe = null;
	}

	@Override
	public void addListener(GeometryListener listener) {
		this.original.addListener(listener);
	}
}
