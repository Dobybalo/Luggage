import java.util.ArrayList;
import java.util.Collections;

public class Luggage {
	private int luggageHeight, luggageWidth;
	private int[][] matrix;
	private ArrayList<Item> items;
	private int zeroCounter; 	//számláló, számontartjuk, hány üres hely van a poggyászban
								// ez alapján lehet optimalizálni
	
	public Luggage(int h, int w, ArrayList<Item> items) {
		luggageHeight = h;
		luggageWidth = w;
		
		matrix = new int[h][w];
		this.items = items;
		
		fillMatrix();
	}
	
	//feltöltjük a mátrixot 0-kkal
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
	
	//tárgyak elhelyezése
	public void placeItems() {
		
		//No. 1. : RENDEZÉS!
		//	egyelõre width -> height sorrend...
		Collections.sort(items, new ItemComparator());
		
		for (int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
			Item it = items.get(itemIndex);
			//végigmegyünk...
			check: for (int i=0; i < luggageHeight; ++i) {
				for (int j=0; j < luggageWidth; ++j) {   
					
					//ha 0 van az adott helyen, megnézegetjük...
					if (matrix[i][j] == 0) {
						
						//megnézzük, a tárgy egyáltalán beférHET-e a poggyászba...
						if (i + it.getHeight() > luggageHeight) {
							
							//biztos hogy nem fér be!
							//skip ITEM!
							
							break check;
						}
						if (j + it.getWidth() > luggageWidth) {
							
							//skip row
							break;
							
						}
						
						//megnézünk egy itemX*itemY méretû téglalapot,
						//ha csak 0-k vannak benne, OK
						int itemHeight = it.getHeight();
						int itemWidth = it.getWidth();
						
						int[][] placeholder = new int[itemHeight][itemWidth];
						for (int k = 0; k < itemHeight; ++k) {
							for (int l = 0; l < itemWidth; ++l) {
								
								//kimásoljuk a megfelelõ méretû téglalapot
								placeholder[k][l] = matrix[i+k][j+l]; 
							}
						}
						
						//megnézzük, van-e 0-tól eltérõ elem ebben a téglalapban,
						//ha igen: 
						if ( checkZeros(placeholder, itemHeight, itemWidth) ) {
							//feltöltjük a megfelelõ téglalapot a "(tárgy indexe+1)-gyel"
							for (int k = 0; k < itemHeight; ++k) {
								for (int l = 0; l < itemWidth; ++l) {
									matrix[i+k][j+l] = it.index + 1;
								}
							}	
							//jeleznünk kell, hogy el van helyezve a tárgy!
							break check;
						}
						
						//ha van 0-tól eltérõ, akkor nem fér ide, megyünk tovább...
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
