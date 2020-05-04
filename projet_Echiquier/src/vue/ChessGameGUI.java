package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;



import javax.swing.*;


import controler.ChessGameControlers;
import controler.controlerLocal.ChessGameControler;
import model.Coord;
import model.Couleur;
import tools.ChessImageProvider;
import tools.ChessPiecePos;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {

	private JLayeredPane layeredPane;
	private JPanel chessBoard;
	private JLabel chessPiece;
	private int xAdjustment;
	private int yAdjustment;
	Coord initiale;
	ChessGameControlers chessGameControler;

	private static final long serialVersionUID = 1L;

	public ChessGameGUI(String nom,ChessGameControlers chessGameControler,Dimension dim) {
		this.chessGameControler=chessGameControler;
		  this.setTitle(nom);
		  this.layeredPane = new JLayeredPane();
		  this.getContentPane().add(layeredPane);
		  layeredPane.addMouseListener(this);
		  layeredPane.setPreferredSize(dim);
		  layeredPane.addMouseMotionListener(this);

		  chessBoard = new JPanel();
		  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout( new GridLayout(8, 8) );
		  chessBoard.setPreferredSize( dim );
		  chessBoard.setBounds(0, 0, dim.width, dim.height);
		  
		  for (int i = 0; i < 64; i++) {
			  JPanel square = new JPanel( new BorderLayout() );
			  chessBoard.add( square );
		  
			  int row = (i / 8) % 2;
			  if (row == 0)
			  square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
			  else
			  square.setBackground( i % 2 == 0 ? Color.white : Color.blue );}
		 
		  for (int i = 0; i < ChessPiecePos.values().length; i++) {
				for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
					JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(ChessPiecePos.values()[i].nom, ChessPiecePos.values()[i].couleur)) );
					int pos=ChessPiecePos.values()[i].coords[j].x+ChessPiecePos.values()[i].coords[j].y*8;
					JPanel panel = (JPanel)chessBoard.getComponent(pos);
					panel.add(piece);
				}
			}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent me) {
		  if (chessPiece == null) return;
		  chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		chessPiece = null;
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());

		  if (c instanceof JPanel) 
		  return;
		  
		  Point parentLocation = c.getParent().getLocation();
		  this.initiale=new Coord((parentLocation.x-2)/87,(parentLocation.y-2)/87);
		  if (this.chessGameControler.isPlayerOK(new Coord((parentLocation.x-2)/87,(parentLocation.y-2)/87))){
		  xAdjustment = parentLocation.x - e.getX();
		  yAdjustment = parentLocation.y - e.getY();
		  chessPiece = (JLabel)c;
		  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(chessPiece == null) return;
		  chessPiece.setVisible(false);
		  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		  //if(this.chessGameControler.move(new Coord(this.x,this.y), new Coord((parentLocation.x-2)/87,(parentLocation.y-2)/87))){
		  
		  if (c instanceof JLabel){
			  Container parent = c.getParent();
		  	  if(this.chessGameControler.move(this.initiale,new Coord((parent.getLocation().x-2)/87,(parent.getLocation().y-2)/87))){
		  		  parent.remove(0);
		  		  parent.add( chessPiece );
		  	  }
		  }
		  
		  else {
			  
			  Container parent = (Container)c;
			  if(this.chessGameControler.move(this.initiale, new Coord((c.getLocation().x-2)/87,(c.getLocation().y-2)/87))) {
			  		parent.add( chessPiece );
			  }
			  else{
				JPanel panel = (JPanel)chessBoard.getComponent(this.initiale.x+this.initiale.y*8);
				panel.add(chessPiece);
			   }
		  }
		  
		  chessPiece.setVisible(true);
	}


	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
