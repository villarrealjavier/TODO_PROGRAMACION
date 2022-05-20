package xml.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xml.model.Coche;

public class XMLReader {

	public List<Coche> cargarArchivoDatos(String path){
		List<Coche> coches = new ArrayList<>();
		File file = new File(path);
		if (file.exists()) {
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document documento = builder.parse(file);
				
				documento.getDocumentElement().normalize();
				System.out.println(documento.getDocumentElement().getNodeName());
				
				NodeList listaNodos = documento.getElementsByTagName("coche");
				//Para cada nodo hijo lo transformo a elemento para poder acceder a sus atributos y nodos hijos.
				for (int i=0;i<listaNodos.getLength();i++) {
					//TRANSFORMO EL NODO A ELEMENT
					Element elemento = (Element) listaNodos.item(i);
					System.out.println(elemento.getAttribute("id"));
					System.out.println(elemento.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println(elemento.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println(elemento.getElementsByTagName("motor").item(0).getTextContent());
					
					((Element) elemento.getElementsByTagName("ruedas").item(0)).getElementsByTagName("rueda").item(3).getTextContent();
					System.out.println(elemento.getElementsByTagName("rueda").item(3).getTextContent());
					int id = Integer.valueOf(elemento.getAttribute("id"));
					String marca = elemento.getElementsByTagName("marca").item(0).getTextContent();
					String modelo = elemento.getElementsByTagName("modelo").item(0).getTextContent();
					String motor = elemento.getElementsByTagName("motor").item(0).getTextContent();
					
					Coche c1 = new Coche(id, marca, modelo, motor);
					coches.add(c1);
					
				}
				
				
			}catch (ParserConfigurationException e){
				
			}catch (SAXException e ) {
				
			}catch (IOException e) {
				
			}
		
		}
		
		return coches;
		
	}

	
}
