package tools;

public enum ChessPieceImage {

	TOURBLANC("TourBLANC","tourBlancS.png"),
	CAVALIERBLANC("CavalierBLANC", "cavalierBlancS.png"), 
	FOUBLANC("FouBLANC", "fouBlancS.png"), 
	REINEBLANC("ReineBLANC", "reineBlancS.png"), 
	ROIBLANC("RoiBLANC", "roiBlancS.png"),
	PIONBLANC("PionBLANC", "pionBlancS.png"),
			
	TOURNOIR("TourNOIR", "tourNoireS.png"),
	CAVALIERNOIR("CavalierNOIR", "cavalierNoirS.png"), 
	FOUNOIR("FouNOIR", "fouNoirS.png"), 
	REINENOIR("ReineNOIR", "reineNoireS.png"), 
	ROINOIR("RoiNOIR", "roiNoirS.png"),
	PIONNOIR("PionNOIR", "pionNoirS.png");
	
	public String nom;
	public String imageFile;
	
	ChessPieceImage( String nom, String imageFile) { 
		this.nom = nom;this.imageFile = imageFile;
	} 
	
}
