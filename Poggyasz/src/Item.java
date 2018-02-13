
public class Item {

	public int index;
	private int height = 0;
	private int width = 0;
	
	//nem biztos hogy kelleni fog
	public int area = 0;
	
	public Item(int h, int w, int index) {
		height = h;
		width = w;
		area = h*w;
		
		this.index = index;
	}
	
	public int getHeight() { return height; }
	public int getWidth() { return width; }
}
