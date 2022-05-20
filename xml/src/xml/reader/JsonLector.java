package xml.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import xml.model.Coche;

public class JsonLector {

	
	public Collection cargarDatosCoches(String path) {
		List<Coche> coches = new ArrayList<>();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			File fichero = new File(path);
			FileReader fr = new FileReader(fichero);
			
			Coche[] cochesArray = gson.fromJson(fr, Coche[].class);
			coches.addAll(Arrays.asList(cochesArray));
			
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		
		return coches;
	}
}
