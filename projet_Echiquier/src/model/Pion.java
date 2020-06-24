package model;

public class Pion extends AbstractPiece implements Pions {
	boolean T1;

	public Pion(Couleur couleur,Coord coord) {
		super(couleur, coord);
		this.T1=true;
	}

	public boolean isMoveOk(int xFinal,int yFinal) {
		if(this.couleur==Couleur.NOIR){
			if((yFinal>this.getY()) & (yFinal-getY()<3) & (xFinal==this.getX())) {
				if(this.T1 & (yFinal-getY()<3))
					return true;
				else if(!this.T1 & (xFinal-getX()<2))
					return true;
				else return false;
			}
			else 
			return false;}
	
		else {

			if((yFinal<this.getY()) & (Math.abs(yFinal-getY())<3) & (xFinal==this.getX())) {
				if(this.T1 & (Math.abs(yFinal-getY())<3))
					return true;
				else if(!this.T1 & (Math.abs(xFinal-getX())<2))
					return true;
				else return false;
			}
			else 
				return false;
		}
		
	}

	@Override
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

}