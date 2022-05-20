package main.java.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Country {
	private Set<String> name;
	private List<Integer> id;
	private List<LocalDateTime> tiempo;
	
	public Country(Set<String> name, List<Integer> id, List<LocalDateTime> tiempo) {
		this.name=name;
		this.id=id;
		this.tiempo=tiempo;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", id=" + id + ", tiempo=" + tiempo + "]";
	}
	
	
	
}
