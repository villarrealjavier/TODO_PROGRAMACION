package xml.writer;

import java.io.File;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import xml.model.Caseta;

public class XMLWriter {

	public static final String ENTIDAD = "entidad";
	public static final String NUMERO = "numero";
	public static final String CLASE = "clase";
	public static final String CALLE = "calle";
	public static final String NOMBRE = "nombre";
	public static final String ID_CALLE = "id_calle";
	public static final String ID = "id";
	public static final String CASETA = "caseta";
	public static final String CASETAS = "casetas";

	/**
	 * Crea un xml con los datos de la coleccion pasada como primer argumento de la ruta especificada 
	 * @param casetas
	 * @param path
	 * @throws TransformerException 
	 */
	public void crearArchivosDatosXML (Collection<Caseta> casetas, String path) throws TransformerException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder= factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			
			//creamos el nodo principal
			Element raiz = document.createElement(CASETAS);
			document.appendChild(raiz);
				//creamos el elemento caseta 
			for (Caseta caseta: casetas){
				Element elementoCaseta = document.createElement(CASETA);
				raiz.appendChild(elementoCaseta);
				
				//creamos atributo
				Attr atributo = document.createAttribute(ID);
				atributo.setValue(caseta.getId().toString());
				elementoCaseta.setAttributeNode(atributo);
				//añadimos nuevo atributo//
				Attr atributo2 = document.createAttribute(ID_CALLE);
				atributo2.setValue(caseta.getId_calle().toString());
				elementoCaseta.setAttributeNode(atributo2);
				
				//creamos un elemento<nombre/> a la caseta
				Element nombre = document.createElement(NOMBRE);
				Node textoNombre =document.createTextNode(caseta.getTitulo());
				nombre.appendChild(textoNombre);
				elementoCaseta.appendChild(nombre);
				//creamos elemento <calle/> a la caseta
				Element calle = document.createElement(CALLE);
				Node textoCalle = document.createTextNode(caseta.getCalle());
				calle.appendChild(textoCalle);
				elementoCaseta.appendChild(calle);
				//creamos elemento <numero/> a la caseta
				Element numero = document.createElement(NUMERO);
				Node textoNumero = document.createTextNode(caseta.getNumero().toString());
				numero.appendChild(textoNumero);
				elementoCaseta.appendChild(numero);
				//añadimos el elemento Clase//
				Element clase = document.createElement(CLASE);
				Node textoClase = document.createTextNode(caseta.getClase());
				clase.appendChild(textoClase);
				elementoCaseta.appendChild(clase);
				//añadimos el elemento entidad
				Element entidad = document.createElement(ENTIDAD);
				Node textoEntidad = document.createTextNode(caseta.getTitulo());
				entidad.appendChild(textoEntidad);
				elementoCaseta.appendChild(entidad);
				
				
				
			}
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer transformer = tfactory.newTransformer();
			
			///IMPORTANTE NO VIENE EN APUNTES//
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource sourcer = new DOMSource(document);
			StreamResult result = new StreamResult(new File(path));
			
			transformer.transform(sourcer, result);
			
			
			
		}catch (ParserConfigurationException  | TransformerException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
