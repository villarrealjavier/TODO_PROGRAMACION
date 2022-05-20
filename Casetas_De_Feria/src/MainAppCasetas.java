import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import xml.model.Caseta;
import xml.model.ComparatorID;
import xml.reader.XMLReader;

/*1. Mostrar todas las casetas existentes en una calle.
2. Mostrar todas las casetas de tipo familiar.
3. Mostrar todas las casetas de tipo Distrito
4. Mostrar todas las casetas que no sean ni familiares ni distritos.
5. Mostrar para cada una de las calles del recinto ferial el n�mero de casetas de tipo familiar
que existen.
6. Mostrar para cada una de las calles del recinto ferial el n�mero de casetas de tipo Distrito
que existen.
7. Eliminar una caseta. Si se elimina una caseta se considerar� que el resto de las casetas
posteriores se desplazan, es decir si borro la caseta 5 de una calle, todas las casetas a partir
del n�mero 5 deber�n descender un n�mero si la caseta borrada tiene un m�dulo, dos si tiene
dos m�dulos, y as� sucesivamente. Se pedir� el nombre de la calle y el n�mero. Si no existe
se deber� mostrar un mensaje de error.
8. Salir.*/
				
public class MainAppCasetas {
		private static final String MENU =("1. Mostrar todas las casetas existentes en una calle.\r\n"
				+ "2. Mostrar todas las casetas de tipo familiar.\r\n"
				+ "3. Mostrar todas las casetas de tipo Distrito\r\n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos.\r\n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el n�mero de casetas de tipo familiar\r\n"
				+ "que existen.\r\n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el n�mero de casetas de tipo Distrito\r\n"
				+ "que existen.\r\n"
				+ "7. Eliminar una caseta. Si se elimina una caseta se considerar� que el resto de las casetas\r\n"
				+ "posteriores se desplazan, es decir si borro la caseta 5 de una calle, todas las casetas a partir\r\n"
				+ "del n�mero 5 deber�n descender un n�mero si la caseta borrada tiene un m�dulo, dos si tiene\r\n"
				+ "dos m�dulos, y as� sucesivamente. Se pedir� el nombre de la calle y el n�mero. Si no existe\r\n"
				+ "se deber� mostrar un mensaje de error.\r\n"
				+ "8. Salir.");
		
		
	public static void main(String[] args) throws SAXException, IOException {
		Scanner sc= new Scanner (System.in);
		List<Caseta> ListaCasetas = new ArrayList<>();
		XMLReader reader = new XMLReader();
		ListaCasetas= reader.cargarArchivoDeDatos("./Ficheros/casetasferia.xml");
		ListaCasetas.sort( new ComparatorID());
		
		xml.writer.JsonWriter gson = new xml.writer.JsonWriter();
		
		gson.toJSONFile(casetasCalleYCaseta(ListaCasetas), "./Ficheros/casetasConCalleyCasetas.json");//
		
		System.out.println(MENU);
		Integer opciones =Integer.valueOf(sc.nextLine());
		while(opciones!=8) {
		switch (opciones) {
		case 1:
			System.out.println("Indica la calle : ");
			String calle= sc.nextLine();

			System.out.println(devolverCasetasExistentesCalle(calle ,casetasCalleYCaseta(ListaCasetas)));
			break;
		case 2:
			devolverCasetasExistentesClaseFamiliar(ListaCasetas);
			break;
		case 3:
			devolverCasetasExistentesPorDistrito(ListaCasetas);
			break;
		case 4:
			devolverCasetasExistentesDiferentes(ListaCasetas);
			break;
		case 5:
			System.out.println(devolverContarCasetasExistentesClaseFamiliar(ListaCasetas));
			break;
		case 6:
			devolverContarCasetasExistentesDiferentes(ListaCasetas);
			break;
		case 7:
			try {
			System.out.println("Indica la calle : ");
			String calle2= sc.nextLine();
			System.out.println("Indica  el numero a borrar : ");
			Integer numeroABorrar=Integer.valueOf(sc.nextLine());
		
				eliminarCasetas(calle2, numeroABorrar);
				
			}catch (Exception e) {
				System.out.println(e);
			}
		default:
			
			break;
		}
		
		
		System.out.println(MENU);
		opciones =Integer.valueOf(sc.nextLine());
	
		}
		
		
	}

	
	
	
public void toJSONFile(Collection coleccion, String path) {
		
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();

		try {
			File f = new File(path);
			f.createNewFile();
			Writer w = new FileWriter(f);
			gson.toJson(coleccion, w);
			w.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
		
	}

public static Map<String, List<Caseta>> casetasCalleYCaseta(List<Caseta> listaArchivos) {
		Map<String, List<Caseta>> mapa = new HashMap<>();
	
		for (Caseta c: listaArchivos) {
			if (!mapa.containsKey(c.getCalle())) {
			mapa.put(c.getCalle(), new ArrayList<>());
		}
			mapa.get(c.getCalle()).add(c);
	}
	return mapa;
}


public static Map<String, List<Caseta>>  devolverCasetasExistentesCalle(String nombreCalle, Map<String, List<Caseta>> mapaCaseta) {
	Map<String, List<Caseta>> mapaCaseta2 = new HashMap<>();
	for(String calle : mapaCaseta.keySet()) {
		if(calle.equals(nombreCalle)) {
			mapaCaseta2.put(calle, mapaCaseta.get(calle));
		}
	}
	return mapaCaseta2;
}


public static void devolverCasetasExistentesClaseFamiliar(List<Caseta> ListaCasetas) {
	List<Caseta> NuevaListaPorClase = new ArrayList<>();
	
	for(Caseta c : ListaCasetas) {
	 if(c.getClase().equals("FAMILIAR")) {
		 NuevaListaPorClase.add(c);
	 }
	 
	}
	
}
public static void devolverCasetasExistentesPorDistrito(List<Caseta> ListaCasetas) {
	List<Caseta> NuevaListaPorClase = new ArrayList<>();
	
	for(Caseta c : ListaCasetas) {
	 if(c.getClase().equals("DISTRITO")) {
		 NuevaListaPorClase.add(c);
	 }
	 
	}
	System.out.println(NuevaListaPorClase);
}
public static void devolverCasetasExistentesDiferentes(List<Caseta> ListaCasetas) {
	List<Caseta> NuevaListaPorClase = new ArrayList<>();
	
	for(Caseta c : ListaCasetas) {
	 if(!c.getClase().equals("DISTRITO") && !c.getClase().equals("FAMILIAR")) {
		 NuevaListaPorClase.add(c);
	 }
	 
	}
	System.out.println(NuevaListaPorClase);
}

public static Integer devolverContarCasetasExistentesClaseFamiliar(List<Caseta> ListaCasetas) {
	devolverCasetasExistentesClaseFamiliar(ListaCasetas);
	
	return ListaCasetas.size();
}

public static void devolverContarCasetasExistentesDiferentes(List<Caseta> ListaCasetas) {
	List<Caseta> NuevaListaPorClase = new ArrayList<>();
	
	for(Caseta c : ListaCasetas) {
	 if(!c.getClase().equals("DISTRITO") && !c.getClase().equals("FAMILIAR")) {
		 NuevaListaPorClase.add(c);
	 }
	 
	}
	System.out.println(NuevaListaPorClase.size());
}

public static void eliminarCasetas(String nombreCalle, Integer numeroCaseta) throws Exception {
	Map<String, List<Caseta>> mapa = new HashMap<>();
	boolean esBorrado= false;
	
	for(String c: mapa.keySet()) {
		
		if(c.equals(nombreCalle)) {
			for(Caseta c1 : mapa.get(c)) {
				if(c1.getNumero().equals(numeroCaseta)) {
					mapa.get(c).remove(c1);
					esBorrado=true;
				
				}
				if(esBorrado==true) {
					c1.setNumero(c1.getNumero()-1);
				}
			}
		}
		if(esBorrado==false) {
			throw new Exception("Error no se ha encontrado");
		}
	}
	
	
}
}
	
