package model;
import java.util.LinkedList;
import java.util.List;
import tools.*;

public class Jeu {
	
	public List<Pieces> pieces;
	
	public Jeu(Couleur C) {
		this.pieces=ChessPiecesFactory.newPieces(C);
	}
	
	@Override
	public String toString() {
		for(Pieces p:pieces) {
			System.out.println(p.toString());
		}
	return("");
	}
	
	public Pieces findPiece(int x,int y) {
		Pieces P=null;
		for(Pieces p:pieces) {
			if((((AbstractPiece)p).coord.x==x) && (((AbstractPiece)p).coord.y==y)){
				P=p;
			}
		}
		return P;
	}
	
	
	/**
	* @return une vue de la liste des pièces en cours
	* ne donnant que des accès en lecture sur des PieceIHM
	* (type piece + couleur + liste de coordonnées)
	*/
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		for (Pieces piece : pieces){
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
						existe = true;
						if (piece.getX() != -1){
								pieceIHM.add(new Coord(piece.getX(), piece.getY()));
						}
				}
			}
			// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			if (! existe) {
					if (piece.getX() != -1){
							newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
										piece.getCouleur());
							newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
							list.add(newPieceIHM);
					}
			}
		}
		return list;
	}
	
	
	
}
