package junittestcase;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	private List<String> lstFruits = new ArrayList<>();

	public void add(String fruit) {
		lstFruits.add(fruit);
	}

	public void remove(String fruit) {
		lstFruits.remove(fruit);
	}

	public int size() {
		return lstFruits.size();
	}
	
	public void removeAll(){
		lstFruits.clear();
	}
}
