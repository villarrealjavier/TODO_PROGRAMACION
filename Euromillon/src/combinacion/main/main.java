package combinacion.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import combinacion.utils.Combinacion;



public class main {

	public static void main(String[] args) {
		
		/*Combinacion nuevacombinacion = new Combinacion(1, 5, 6, 8, 34, 7, 9);
		Combinacion nuevacombinacion2 = new Combinacion(1, 5, 6, 8, 34, 5, 9);
	
		System.out.println(nuevacombinacion.comprobarCombinacion(nuevacombinacion2));
		System.out.println(nuevacombinacion.devolverNumeros());
		System.out.println(nuevacombinacion.devolverEstrellas());
		System.out.println(nuevacombinacion.toString());*/
		cargarHistorico();
		

	}
	
	private static void numerosRepetidos(List<Combinacion> combinaciones) {
		Map<Integer,Integer> numerosRepetidos=new HashMap<>();
		for(Combinacion c: combinaciones ) {
			c.getNumeros();
		}
	}

	private static void cargarHistorico() {
		List<Combinacion> historial=new ArrayList<>();
		try {
			
			
			File file = new File("/home/estudiante/Vídeos/Euromillones - 2004 a 2022.csv");
			
			FileReader fr = new FileReader(file);
			
			BufferedReader br= new BufferedReader(fr);
			br.readLine();
			String cadena=br.readLine();
			while(cadena!=null) {
				String[] info=cadena.split(",");
				Set<Integer> numeros = new HashSet<>();
				numeros.add(Integer.valueOf(info[1]));
				numeros.add(Integer.valueOf(info[2]));
				numeros.add(Integer.valueOf(info[3]));
				numeros.add(Integer.valueOf(info[4]));
				numeros.add(Integer.valueOf(info[5]));
				
				Set<Integer> estrellas = new HashSet<>();
				estrellas.add(Integer.valueOf(info[7]));
				estrellas.add(Integer.valueOf(info[8]));
				
				Combinacion combinacion=new Combinacion(numeros, estrellas);
				historial.add(combinacion);
				
				cadena=br.readLine();
			}
			
			fr.close();
			br.close();
			System.out.println(historial);
		}catch(IOException io) {
			
		}
	}

}
