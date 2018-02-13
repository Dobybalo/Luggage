import java.util.ArrayList;
import java.util.Collections;

public class Luggage {
	private int luggageHeight, luggageWidth;
	private int[][] matrix;
	private ArrayList<Item> items;
	private int zeroCounter; 	//sz�ml�l�, sz�montartjuk, h�ny �res hely van a poggy�szban
								// ez alapj�n lehet optimaliz�lni
	
	public Luggage(int h, int w, ArrayList<Item> items) {
		luggageHeight = h;
		luggageWidth = w;
		
		matrix = new int[h][w];
		this.items = items;
		
		fillMatrix();
	}
	
	//felt�ltj�k a m�trixot 0-kkal
	private void fillMatrix() {
		for (int i=0; i < luggageHeight; ++i) {
			for (int j=0; j < luggageWidth; ++j) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public void printMatrix() {
		for (int i=0; i < luggageHeight; ++i) {
			for (int j=0; j < luggageWidth; ++j) {   
				
				System.out.print(matrix[i][j]);
				if (j != luggageWidth-1) 
					System.out.print("\t");
			}
			if (i != luggageHeight-1)
				System.out.print("\n");
		}
	}
	
	//t�rgyak elhelyez�se
	public void placeItems() {
		
		//No. 1. : RENDEZ�S!
		//	egyel�re width -> height sorrend...
		Collections.sort(items, new ItemComparator());
		
		for (int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
			Item it = items.get(itemIndex);
			//v�gigmegy�nk...
			check: for (int i=0; i < luggageHeight; ++i) {
				for (int j=0; j < luggageWidth; ++j) {   
					
					//ha 0 van az adott helyen, megn�zegetj�k...
					if (matrix[i][j] == 0) {
						
						//megn�zz�k, a t�rgy egy�ltal�n bef�rHET-e a poggy�szba...
						if (i + it.getHeight() > luggageHeight) {
							
							//biztos hogy nem f�r be!
							//skip ITEM!
							
							break check;
						}
						if (j + it.getWidth() > luggageWidth) {
							
							//skip row
							break;
							
						}
						
						//megn�z�nk egy itemX*itemY m�ret� t�glalapot,
						//ha csak 0-k vannak benne, OK
						int itemHeight = it.getHeight();
						int itemWidth = it.getWidth();
						
						int[][] placeholder = new int[itemHeight][itemWidth];
						for (int k = 0; k < itemHeight; ++k) {
							for (int l = 0; l < itemWidth; ++l) {
								
								//kim�soljuk a megfelel� m�ret� t�glalapot
								placeholder[k][l] = matrix[i+k][j+l]; 
							}
						}
						
						//megn�zz�k, van-e 0-t�l elt�r� elem ebben a t�glalapban,
						//ha igen: 
						if ( checkZeros(placeholder, itemHeight, itemWidth) ) {
							//felt�ltj�k a megfelel� t�glalapot a "(t�rgy indexe+1)-gyel"
							for (int k = 0; k < itemHeight; ++k) {
								for (int l = 0; l < itemWidth; ++l) {
									matrix[i+k][j+l] = it.index + 1;
								}
							}	
							//jelezn�nk kell, hogy el van helyezve a t�rgy!
							break check;
						}
						
						//ha van 0-t�l elt�r�, akkor nem f�r ide, megy�nk tov�bb...
					}	
				}
			}
		}
	}
	
	//return true, ha minden eleme a mx-nak 0
	private boolean checkZeros(int[][] mx, int mxHeight, int mxWidth) {
		for (int i = 0; i < mxHeight; ++i) {
			for (int j = 0; j < mxWidth; ++j) {
				if (mx[i][j] != 0) return false;
			}
		}
		return true;
	}
}
