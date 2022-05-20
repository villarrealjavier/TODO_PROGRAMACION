package main.java.model;

import java.util.List;
import java.util.Set;

public class Address {
	
	
	private Set<String> direccion;
	private List<Integer> id;
	private List<String> city;
	private List<String> state;
	
	public Address(Set<String> direccion, List<Integer> id,List<String> state, List<String> city) {
		this.direccion=direccion;
		this.id=id;
		this.state=state;
		this.city=city;
	}

	@Override
	public String toString() {
		return "Address [direccion=" + direccion + ", id=" + id + ", city=" + city + ", state=" + state + "]";
	}
	
}
