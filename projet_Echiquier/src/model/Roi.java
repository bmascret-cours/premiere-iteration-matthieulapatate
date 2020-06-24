package model;

public class Roi extends AbstractPiece{
		
	public Roi(Couleur couleur,Coord coord) {
		super(couleur, coord);
	}

	public boolean isMoveOk(int xFinal,int yFinal) {
		if((Math.abs(xFinal-this.getX())<2) & ((Math.abs(yFinal-this.getY())<2))) {
			return true;
		}
		else return false;
	}
	
}
