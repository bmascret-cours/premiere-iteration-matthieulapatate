import java.util.List;

import model.*;

public class Main {
	
	  public static void main(String[] args){
		  Echiquier E=new Echiquier();
		  //System.out.println(E.toString());
		  System.out.println(E.isMoveOk(3,6,3,4));
		  E.move(3, 6, 3, 4);

	  }
}
