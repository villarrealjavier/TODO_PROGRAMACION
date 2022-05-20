package actividad.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FicheroReader {

	
	public static void imprimirFicheroPorLineas(String ruta) {
	
		String linea;
		try
		{
		FileReader flujoLectura=new FileReader(ruta);
		BufferedReader filtroLectura=new BufferedReader(flujoLectura);
		linea=filtroLectura.readLine();
		while (linea!=null){
			System.out.println(linea);
			linea=filtroLectura.readLine();
		}
			filtroLectura.close();
			flujoLectura.close();
		}
		catch(FileNotFoundException e){
				System.out.println("No existe el fichero " + ruta);
		}catch(IOException e){
			System.out.println( e.getMessage());
		}
	}
}
