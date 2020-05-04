package model;

public class Tour extends AbstractPiece {

	public Tour(Couleur couleur,Coord coord) {
		super(couleur, coord);
	}

	
	public boolean isMoveOk(int xFinal,int yFinal) {
		if((xFinal!=this.getX() & (yFinal==this.getY())) || (yFinal!=this.getY() & (xFinal==this.getX()))) {
			return true;
		}
		else return false;
	}
}
