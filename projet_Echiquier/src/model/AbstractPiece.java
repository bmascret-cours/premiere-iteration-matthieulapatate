package model;

public abstract class AbstractPiece implements Pieces {

	Coord coord;
	Couleur couleur;

	
	public AbstractPiece(Couleur couleur,Coord coord) {
		this.coord=coord;
		this.couleur=couleur;
	}
	
	@Override
	public boolean move(int xFinal,int yFinal) {
		if(this.isMoveOk(xFinal,yFinal)){
			this.coord.x=xFinal;
			this.coord.y=yFinal;
			return true;
		}
		else return false;
	}
	
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
	
	@Override
	public boolean Capture() {
		this.coord.x=-1;
		this.coord.y=-1;
		return true;
	}
	
	@Override
	public String toString() {
		String S="Je suis un "+this.getClass().getSimpleName()+" de couleur "+(this.couleur==Couleur.BLANC ? "blanche":"noire")+" et je me situe en : ["+this.coord.x+","+this.coord.y+"]";
		return S;
	}

}
