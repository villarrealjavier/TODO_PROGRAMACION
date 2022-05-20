package xml.write;

import java.util.Collection;

import xml.model.Coche;
import xml.reader.JsonLector;
import xml.reader.XMLReader;

public class MainApp {

	public static void main(String[] args) {
		XMLReader reader = new XMLReader();
		//reader.cargarArchivoDatos("./coches/coches.xml");
		//System.out.println(reader.cargarArchivoDatos("./coches/coches.xml"));
		
		JsonLector lector = new JsonLector();
		Collection<Coche> coches = lector.cargarDatosCoches("./coches/coches2.json");
		System.out.println(coches);
		JsonWriter escribir = new JsonWriter();
		escribir.escribirJson(coches,"./coches/cochesEscribir.json");
	}

}
