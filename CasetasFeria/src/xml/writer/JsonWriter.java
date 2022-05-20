package xml.writer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {

	
public void escribirJson(Object coleccion, String path) {
	
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File fichero = new File(path);
		
			
		
			try {
				fichero.createNewFile();
				FileReader fr = new FileReader(fichero);
				Writer writer = new FileWriter(fichero);
				gson.toJson(coleccion, writer);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	
		
	}
public void escribirJsonOrdenado(Collection coleccion, String path) {
	
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	File fichero = new File(path);
	
		
	
		try {
			fichero.createNewFile();
			FileReader fr = new FileReader(fichero);
			Writer writer = new FileWriter(fichero);
			gson.toJson(coleccion, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	
}
}
