package model;

public class Reine extends AbstractPiece{

	public Reine(Couleur couleur,Coord coord) {
		super(couleur, coord);
		
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		if((xFinal!=this.getX() & (yFinal==this.getY())) || (yFinal!=this.getY() & (xFinal==this.getX())) || (Math.abs(xFinal-this.getX())==Math.abs(yFinal-this.getY()))) {
			return true;
		}
		else return false;
	}
	
}
