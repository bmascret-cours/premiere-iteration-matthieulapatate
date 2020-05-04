package model;

public class Cavalier extends AbstractPiece {
	
	public Cavalier(Couleur couleur,Coord coord) {
		super(couleur,coord);
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		if((Math.abs(xFinal-this.getX()) ==1) & (Math.abs(yFinal-this.getY())==2)) {
			return true;
		}
		return false;
	}
	
	
}
