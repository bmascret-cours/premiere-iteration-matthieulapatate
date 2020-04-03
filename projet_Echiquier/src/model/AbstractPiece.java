package model;

public abstract class AbstractPiece implements Pieces {

	Coord coord;
	Couleur couleur;

	@Override
	public int getX() {
		return this.coord.x;
	}
	
	@Override
	public int getY() {
		return this.coord.y;
	}
	
	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}

	
}
