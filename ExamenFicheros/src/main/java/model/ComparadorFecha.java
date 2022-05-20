package main.java.model;

import java.util.Comparator;

public class ComparadorFecha implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		int resultado=0;
		if (o1.getAnno()>o2.getAnno()) {
			resultado=-1;
		}else if (o1.getAnno()<o2.getAnno()) {
			resultado=1;
		}
		return resultado;
	}
}
