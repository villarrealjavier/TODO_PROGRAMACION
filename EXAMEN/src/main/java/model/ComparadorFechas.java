package main.java.model;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparadorFechas implements Comparator<LocalDate> {

	public ComparadorFechas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		return o1.compareTo(o2);
	}

}
