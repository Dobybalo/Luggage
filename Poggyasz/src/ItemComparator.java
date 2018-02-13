import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

	//hackeljük meg: adjuk vissza az ellentettjét mindegyiknek!
	@Override
	public int compare(Item i1, Item i2) {
		Integer i1_height = i1.getHeight();
		Integer i2_height = i2.getHeight();
		int heightComparison = i1_height.compareTo(i2_height);
		if (heightComparison == 0) {
			Integer i1_width = i1.getWidth();
			Integer i2_width = i2.getWidth();
			return 0 - i1_width.compareTo(i2_width);
		}
		return 0 - heightComparison;
		
		
	}

}
