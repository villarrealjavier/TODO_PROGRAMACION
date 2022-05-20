package xml.writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import xml.model.Caseta;
import xml.reader.XMLReader;


public class MainApp {

	public static void main(String[] args) throws IOException, SAXException {
		XMLReader xl = new XMLReader();
		List<Caseta> lista= xl.cargarArchivos("./archivos/casetasferia.xml");
		System.out.println(lista);
		//xl.cargarArchivos("D:\\WORKSPACE JAVA\\CasetasFeria\\archivos\\casetasferia.xml");
		//System.out.println(xl.cargarArchivos("./archivos/casetasferia.xml"));
		//for (Caseta c: lista) {
			//System.out.println(c);
		//}
		
		/*List<Caseta> casetasNuevas= new ArrayList<>();
		Caseta c1 = new Caseta("PEPE HILLO 57", "PEPE HILLO", 57, 1, "FAMILIAR", "", 1900, 1900);
		Caseta c2 = new Caseta("TOMATE 88", "TOMATE ", 66, 6, "FAMILIAR", "", 1901, 1901);
		Caseta c3 = new Caseta("CASETINHA", "SEVILLA", 59, 1, "FAMILIAR", "", 1902, 1902);
		casetasNuevas.add(c1);
		casetasNuevas.add(c2);
		casetasNuevas.add(c3);
		
		XMLWriter writer= new XMLWriter();
		
		writer.crearArchivoDatosXML(casetasNuevas, "./archivos/casetasferia.xml");*/
		JsonWriter wr = new JsonWriter();
		wr.escribirJson(xl.ordenarJsonyEscribirlo()));
		
		

		
	}

}
