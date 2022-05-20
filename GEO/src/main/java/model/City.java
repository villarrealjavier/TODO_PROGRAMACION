package main.java.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class City {
	private Set<String> name;
	private List<Integer> id;
	private List<LocalDateTime> tiempo;
	private List<String> country;
	
	public City(Set<String> name, List<Integer> id, List<LocalDateTime> tiempo, List<String> country) {
		this.name=name;
		this.id=id;
		this.tiempo=tiempo;
		this.country=country;
	}
	
	private Integer city_id;
	private String city;
	private List<City> listCity;
	
	@Override
	public String toString() {
		return "City [name=" + name + ", id=" + id + ", tiempo=" + tiempo + ", country=" + country;
	}
}
