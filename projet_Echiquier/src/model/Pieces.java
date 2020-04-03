/**
 * 
 */
package model;

/**
 * @author mriou
 *
 */
public interface Pieces {

	public boolean capture();
	
	public boolean move(int xFinal,int yFinal);
	
	public boolean isMoveOk(int xFinal,int yFinal);
	
	public Couleur getCouleur();
	
	public int getX();
	
	public int getY();
	
}
