package xml.model;

import java.util.Comparator;

public class ComparatorID implements Comparator<Caseta> {

	public ComparatorID() {
		
	}

	@Override
	public int compare(Caseta id1, Caseta id2) {
		return id1.getId().compareTo(id2.getId());
	}

}
