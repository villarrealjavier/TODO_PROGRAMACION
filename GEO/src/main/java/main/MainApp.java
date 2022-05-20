package main.java.main;

import main.java.model.AddressLoader;
import main.java.model.CityLoader;
import main.java.model.CountryLoader;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressLoader adl = new AddressLoader();
		System.out.println(adl.cargarDirecciones());
		CityLoader cl = new CityLoader();
		//System.out.println(cl.cargarDirecciones());
		CountryLoader col = new CountryLoader();
		//System.out.println(col.cargarDirecciones());
	}

}
