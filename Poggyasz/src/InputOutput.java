import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {

	public static Scanner sc;
	public static int itemNum = 0;
	public static int luggageHeight = 0;
	public static int luggageWidth = 0;
	public static ArrayList<Item> items;
	
	public static void readInput() {
		
            //1. poggy�szm�ret,
            //2. t�rgyak sz�ma
            //3. t�rgyak
            
			sc = new Scanner(System.in);
		
            readSize();
            readItemsNum();
            readItems();
        
    }
       
	
	
	//1. magass�g �s sz�less�g, reader init.
	private static void readSize() {

			String line = sc.nextLine();
			String[] parts = line.split("\t");
			luggageHeight = Integer.parseInt(parts[0]);
			luggageWidth = Integer.parseInt(parts[1]);
		
	}
	
	//2. t�rgyak sz�ma
	private static void readItemsNum() {

		itemNum = 0;
		try {
		    itemNum = Integer.parseInt(sc.nextLine());
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	//3. soronk�nt 1-1 t�rgy
	private static void readItems() {
		items = new ArrayList<Item>();
		for (int i=0; i<itemNum; ++i) {
			int itemHeight, itemWidth;
			try {
				String line = sc.nextLine();
				String[] parts = line.split("\t");
				itemHeight = Integer.parseInt(parts[0]);
				itemWidth = Integer.parseInt(parts[1]);
				Item it = new Item(itemHeight, itemWidth, i);
				items.add(it);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	
	
}
