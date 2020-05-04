package model;

public class Fou extends AbstractPiece{

	public Fou(Couleur couleur,Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if((Math.abs(xFinal-this.getX())==Math.abs(yFinal-this.getY()))){
			return true;
		}
		else return false;
	}

}
