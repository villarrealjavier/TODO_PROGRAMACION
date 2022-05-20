package xml.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xml.model.Caseta;

public class XMLReader {
	List<Caseta> listaArchivos = new ArrayList<>();
	public List<Caseta> cargarArchivos(String path) throws SAXException, IOException{
		
		File file = new File(path);
		
		
		if (file.exists()) {
			try {
				String entidad="";
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document documento = builder.parse(file);
				
				documento.getDocumentElement().normalize();
				NodeList listaNodos = documento.getElementsByTagName("DatosLeidos");
				
				for (int i=0; i<listaNodos.getLength();i++) {
					Element elemento = (Element) listaNodos.item(i);
				
						String titulo = elemento.getElementsByTagName("TITULO").item(0).getTextContent();
						String calle = elemento.getElementsByTagName("CALLE").item(0).getTextContent();
						int numero = Integer.valueOf(elemento.getElementsByTagName("NUMERO").item(0).getTextContent());
						Integer modulos = Integer.valueOf(elemento.getElementsByTagName("MODULOS").item(0).getTextContent());
						String clase = elemento.getElementsByTagName("CLASE").item(0).getTextContent();
						if (elemento.getElementsByTagName("ENTIDAD").item(0)==null) {
							 entidad = "";
						}else {
							 entidad = elemento.getElementsByTagName("ENTIDAD").item(0).getTextContent();

						}
						Integer ID = Integer.valueOf(elemento.getElementsByTagName("ID").item(0).getTextContent());
						Integer ID_CALLE = Integer.valueOf(elemento.getElementsByTagName("ID_CALLE").item(0).getTextContent());
						
						Caseta d1 = new Caseta(titulo, calle, numero, modulos, clase, entidad, ID, ID_CALLE);
						listaArchivos.add(d1);
					


				}
				System.out.println(documento.getDocumentElement().getNodeName());
				
				
			}catch (ParserConfigurationException| SAXException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return listaArchivos;
		
	}
	
	public void ordenarJsonyEscribirlo(Collection listaArchivos) {
		Map<String, List<Caseta>> mapa = new HashMap<>();
		
		for (Caseta c: listaArchivos) {
			if (!mapa.containsKey(c.getCalle())) {
				mapa.put(c.getCalle(), new ArrayList<>());
			}
			mapa.get(c.getCalle()).add(c);
		}
		
	}
	

}
