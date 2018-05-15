import java.util.ArrayList;

public class Items {
	private ArrayList<Object> inv;
	
	public Items() {
		inv = new ArrayList<Object>();
	}
	
	public ArrayList<Object> getItems() {
		return inv;
	}
	
	public Object getItem(int i) {
		return inv.get(i);
	}
	
	public void sortItems() {
		
	}
}
