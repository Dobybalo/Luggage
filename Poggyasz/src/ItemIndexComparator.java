import java.util.Comparator;

public class ItemIndexComparator implements Comparator<Item> {
	
	
	//igazából visszarendezzük az eredeti sorrendbe a tárgyakat!
	@Override
	public int compare(Item i1, Item i2) {
		Integer i1_index = i1.index;
		Integer i2_index = i2.index;
		return i1_index.compareTo(i2_index);
	}
}
