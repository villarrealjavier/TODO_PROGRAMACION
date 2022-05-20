package main.java.model;

import java.util.Comparator;

public class ComparadorNotaMedia implements Comparator<Temporada> {

	@Override
	public int compare(Temporada o1, Temporada o2) {
		
		return o1.getNotaMedia().compareTo(o2.getNotaMedia());
	}

}
