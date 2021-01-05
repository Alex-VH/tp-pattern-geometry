package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {
	
	private List<Point> points;
	
	
	/**
	 * Constructeur vide de la classe
	 */
	public LineString(){
		this.points = new ArrayList<Point>();
	}
	
	
	/**
	 * Constructeur prenant en parametre la liste des point s de la polyligne
	 * @param points
	 */
	public LineString(List<Point> points) {
		this.points = points;
	}
	
	
	/**
	 * Renvoie le nombre de points de la liste de points en attribut
	 * @return
	 */
	public int getNumPoints() {
		return this.points.size();
	}
	
	
	/**
	 * Renvoie le point numéro N de la liste de point en attribut
	 * @param n
	 * @return
	 */
	public Point getPointN(int n) {
		assert this.getNumPoints() > n : "Indice incorrect";
		return this.points.get(n);
	}
	
	
	@Override
	public String getType() {
		return "LineString";
	}
	
	
	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}

	
	@Override
	public void translate(double dx, double dy) {
		for(int i = 0; i < this.points.size(); i++) {
			this.points.get(i).translate(dx, dy);
		}
		
//		On previent que les coordonnées ont changé
		this.triggerChange();
	}
	
	
	@Override
	public LineString clone() {
		
		List<Point> newPoints = new ArrayList<Point>(getNumPoints());
		for(int i = 0; i < this.points.size(); i++) {
			newPoints.add(this.getPointN(i).clone());
		}
		return new LineString(newPoints);
	
	}
	
	
	@Override
	public Enveloppe getEnveloppe() {
		EnveloppeBuilder builder = new EnveloppeBuilder();
		for(int i = 0; i < this.getNumPoints(); i++) {
			builder.insert(this.getPointN(i).getCoordinate());
		}
		return builder.build();
	}
	
	
	@Override
	public void accept(GeometryVisitor visitor){
		visitor.visit(this);
	}
}
