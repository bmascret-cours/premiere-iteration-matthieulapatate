package model;

import java.util.List;
import java.util.ArrayList;


public class Echiquier implements BoardGames {

	private Jeu J_Noir;
	private Jeu J_Blanc;
	private Couleur courant;
	private String message;
	
	
	public Echiquier() {
		super();
		this.J_Noir=new Jeu(Couleur.NOIR);
		this.J_Blanc=new Jeu(Couleur.BLANC);
		this.courant=Couleur.BLANC;
	}


	public String toString() {
		System.out.println(J_Blanc.toString());
		System.out.println(J_Noir.toString());
		return"";
	}


	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces P=findPiece(xInit,yInit);
		if(P.isMoveOk(xFinal, yFinal)) {
			P.move(xFinal, yFinal);
			System.out.println("La pièce "+P.getClass().getSimpleName()+" "+P.getCouleur()+" est désormais en position ["+P.getX()+","+P.getY()+"]");
			return true;
			}
		System.out.println("Impossible de déplacer");
		return false;
		
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return courant;
	}

	public Pieces findPiece(int x, int y) {
		Pieces P=null;
		if (J_Noir.findPiece(x, y)==null) {
			P=J_Blanc.findPiece(x, y);	
		}
		else
			P=J_Noir.findPiece(x, y);
		return P;
	}
	
	@Override
	public Couleur getPieceColor(int x, int y) {
		Pieces P=findPiece(x,y);
		if (P!=null)
			return P.getCouleur();
		return null;
	}
	
	public void switchjoueur() {
		this.courant=Couleur.values()[(courant.ordinal()+1)%2];
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces P=findPiece(xInit,yInit);
		Object O=findPiece(xFinal,yFinal);
		if (O instanceof Pieces) {
			if (((Pieces) O).getCouleur()==P.getCouleur())
				return false;
			else {
				System.out.println(O);
				((Pieces) O).Capture();
				return(P.isMoveOk(xFinal, yFinal));
			}
		}
		return(P.isMoveOk(xFinal, yFinal));
	}
	
	public List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> A=new ArrayList<>();
		A.addAll(J_Noir.getPiecesIHM());
		A.addAll(J_Blanc.getPiecesIHM());

		return A;
		
	}

}
