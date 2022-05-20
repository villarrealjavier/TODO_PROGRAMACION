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

import xml.model.Caseta;

public class XMLReader {

	
	
	
	public List<Caseta> cargarArchivoDeDatos(String path) throws SAXException, IOException{
		List<Caseta> casetas = new ArrayList<>();
		
		File archivo= new File(path);
		if(archivo.exists()) {
			try {
				String entidad ="";
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document documento = builder.parse(archivo);
				
				documento.getDocumentElement().normalize();
				NodeList listaNodos = documento.getElementsByTagName("DatosLeidos");
				
				for(int i=0; i< listaNodos.getLength(); i++) {
					Element elemento =(Element)listaNodos.item(i);
					
						if(elemento.getNodeType()==elemento.ELEMENT_NODE) {
							
							String titulo= elemento.getElementsByTagName("TITULO").item(0).getTextContent();
							String calle= elemento.getElementsByTagName("CALLE").item(0).getTextContent();
							Integer numeros =Integer.valueOf(elemento.getElementsByTagName("NUMERO").item(0).getTextContent());
							Integer modulos =Integer.valueOf(elemento.getElementsByTagName("MODULOS").item(0).getTextContent());
							String clase= elemento.getElementsByTagName("CLASE").item(0).getTextContent();
							if(elemento.getElementsByTagName("ENTIDAD").item(0)==null) {
								 entidad=" ";
							}else {
								
								 entidad= elemento.getElementsByTagName("ENTIDAD").item(0).getTextContent();
							}
							
							Integer id =Integer.valueOf(elemento.getElementsByTagName("ID").item(0).getTextContent());
							Integer id_calle =Integer.valueOf(elemento.getElementsByTagName("ID_CALLE").item(0).getTextContent());
							
							
							
							Caseta caseta = new Caseta(titulo, calle, numeros, modulos, clase, entidad, id, id_calle);
							casetas.add(caseta);
							
						}
					
				}
				
				
				System.out.println(documento.getDocumentElement().getNodeName());
				
				
			}catch (ParserConfigurationException ex) {
				ex.printStackTrace();
			}
		}
		
		return casetas;
		
	}
}
