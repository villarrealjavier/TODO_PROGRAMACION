package main.java.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CityLoader {
	
	public List<City> cargarDirecciones(){
		List<City> direcciones = new ArrayList<>();
		String linea;
		try {
			File file = new File("./files/city.txt");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			bf.readLine();
			linea=bf.readLine();
			while(linea!=null) {
				String[] info = linea.split(",");
				Set <String> name = new HashSet<>();
				name.add(info[1]);
				List<Integer> id = new ArrayList<Integer>();
				id.add(Integer.valueOf(info[0]));
				List<String> country = new ArrayList<>();
				country.add(info[2]);
				List<LocalDateTime> tiempo = new ArrayList<>();
				tiempo.add(null);
				
				City city1 = new City(name,id,tiempo,country);
				direcciones.add(city1);
				
				
				
				
				
				
				linea=bf.readLine();
				
			}
			
		}catch (IOException e){
			
		}
		
		return direcciones;
	}
}
