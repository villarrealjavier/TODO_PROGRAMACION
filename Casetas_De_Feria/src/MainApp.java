
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import xml.model.Caseta;
import xml.reader.XMLReader;
import xml.writer.XMLWriter;

public class MainApp {

	public static void main(String[] args) throws SAXException, IOException, TransformerException {
		
		
		XMLReader reader = new XMLReader();
		reader.cargarArchivoDeDatos("./Ficheros/casetasferia.xml");
		System.out.println(reader.cargarArchivoDeDatos("./Ficheros/casetasferia.xml"));
		//"./Ficheros/casetasferia.xml//
		/*
		List<Caseta> casetasNuevas = new ArrayList<>();
		
		Caseta c = new Caseta("Jacaranda", "Rafael Gomez Ortega", 2, 1, "MUNICIPAL", "", 10, 20);
		Caseta c1 = new Caseta("Los amigos", "Vicente Villarreal", 5, 2, "MUNICIPAL", "", 11, 22);
		Caseta c2 = new Caseta("Jacaranda", "Rafael Gomez Ortega", 3, 3, "MUNICIPAL", "", 12, 25);
		//importante añadir el las casetas a la lista//
		casetasNuevas.add(c);
		casetasNuevas.add(c1);
		casetasNuevas.add(c2);*/
		
		/*XMLWriter writer = new XMLWriter();
		writer.crearArchivosDatosXML(reader.cargarArchivoDeDatos("./Ficheros/casetasferia.xml"), "./Ficheros/nuevasCasetas.xml");*/
		
		
		
	}

	
			
}

