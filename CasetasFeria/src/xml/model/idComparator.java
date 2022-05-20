package xml.model;

import java.util.Comparator;

public class idComparator implements Comparator<Caseta> {

	@Override
	public int compare(Caseta o1, Caseta o2) {
		
		return o1.getId().compareTo(o2.getId());
	}

}
