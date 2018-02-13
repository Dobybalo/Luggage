import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		InputOutput.readInput();
		InputOutput.sc.close();
		
			//MOST - teszt:
			//InputOutput.readInput("mintak2.txt");
			//teszt:
			/*
			ArrayList<Item> items = new ArrayList<Item>();
			Item it = new Item(2,2,0);
			Item it2 = new Item(4,2,1);
			Item it3 = new Item(1,1,2);
			Item it4 = new Item(1,1,3);
			items.add(it);
			items.add(it2);
			items.add(it3);
			items.add(it4);
			*/
			
			//Luggage lg = new Luggage(5,7,items);
			Luggage lg = new Luggage(InputOutput.luggageHeight, InputOutput.luggageWidth, InputOutput.items);
			
			//megpróbáljuk elrendezni a tárgyakat a poggyászban
			lg.placeItems();
			
			//kiírás
			lg.printMatrix();
		
	}
	
}
