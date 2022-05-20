package main.java.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class AddressLoader {
	
	public AddressLoader() {
		
	}
	
	

	public List<Address> cargarDirecciones(){
		List<Address> direcciones = new ArrayList<>();
		String linea;
		try {
			File file = new File("./files/address.txt");
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			bf.readLine();
			linea=bf.readLine();
			while(linea!=null) {
				String[] info = linea.split(",");
				Set <String> direccion = new HashSet<>();
				if (info.length<4) {
					linea=bf.readLine();
				}else {
					direccion.add(info[1]);
					List<Integer> id = new ArrayList<Integer>();
					id.add(Integer.valueOf(info[0]));
					List<String> state = new ArrayList<>();
					state.add(info[2]);
					List<String> city = new ArrayList<>();
					city.add(info[3]);
					Address adr1 = new Address(direccion,id,state,city);
					direcciones.add(adr1);
				}
				
				
				
				
				
				
				
				
				
				linea=bf.readLine();
				
			}
			
		}catch (IOException e){
			
		}
		
		return direcciones;
	}
}
