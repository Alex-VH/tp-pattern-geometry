package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {
	
	private List<GeometryListener> listeners = new ArrayList<GeometryListener>();

	
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
	
	
	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}
	
	
	protected void triggerChange() {
		for(int i = 0; i < this.listeners.size(); i++) {
			this.listeners.get(i).onChange(this);
		}
	}
}
