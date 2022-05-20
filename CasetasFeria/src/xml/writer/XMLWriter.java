package xml.writer;

import java.io.File;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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

	public static final String MODULO = "modulo";
	public static final String NUMERO = "numero";
	private static final String ENTIDAD = "entidad";
	public static final String CLASE = "clase";
	public static final String CALLE = "calle";
	public static final String ID_CALLE = "id_calle";
	public static final String NOMBRE = "nombre";
	public static final String CASETAS = "casetas";
	public static final String CASETA2 = "caseta";
	public static final String ID = "id";

	//./archivos/casetasferia.xml
	public void crearArchivoDatosXML(Collection<Caseta> casetas, String path) {
	try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document documento = builder.newDocument();
		
		Element raiz = documento.createElement(CASETAS);
		documento.appendChild(raiz);
		
		for (Caseta caseta: casetas) {
			Element c = documento.createElement(CASETA2);
			raiz.appendChild(c);
			
			//AÑADO ATRIBUTO A LA CASETA
			Attr atributo = documento.createAttribute(ID);
			atributo.setValue(caseta.getId().toString());
			c.setAttributeNode(atributo);
			
			//AÑADO UN ELEMENTO <NOMBRE/> A LA CASETA
			Element nombre = documento.createElement(NOMBRE);
			Node textoNombre = documento.createTextNode(caseta.getTitulo());
			nombre.appendChild(textoNombre);
			c.appendChild(nombre);
			
			//AÑADE ATRIBUTO ID_CALLE 
			Attr atributo_calle = documento.createAttribute(ID_CALLE);
			atributo_calle.setValue(caseta.getId_calle().toString());
			c.setAttributeNode(atributo_calle);
			
			//AÑADO LOS ELEMENTOS CALLE
			Element calle = documento.createElement(CALLE);
			Node textoCalle = documento.createTextNode(caseta.getCalle());
			calle.appendChild(textoCalle);
			c.appendChild(calle);
			
			//AÑADO LOS ELEMENTOS CLASE
			Element clase = documento.createElement(CLASE);
			Node textoClase = documento.createTextNode(caseta.getCalle());
			clase.appendChild(textoClase);
			c.appendChild(clase);
			
			//AÑADO LOS ELEMENTOS ENTIDAD
			Element entidad = documento.createElement(ENTIDAD);
			Node textoEntidad = documento.createTextNode(caseta.getEntidad());
			entidad.appendChild(textoEntidad);
			c.appendChild(entidad);
			
			//AÑADO LOS ELEMENTOS NUMERO
			Element numero = documento.createElement(NUMERO);
			Node textoNumero = documento.createTextNode(caseta.getNumero().toString());
			numero.appendChild(textoNumero);
			c.appendChild(numero);
			
			//AÑADO LOS ELEMENTOS MODULO
			Element modulo = documento.createElement(MODULO);
			Node textoModulo = documento.createTextNode(caseta.getModulos().toString());
			modulo.appendChild(textoModulo);
			c.appendChild(modulo);
			
			
			
			
			
		}
		TransformerFactory tfactory = TransformerFactory.newInstance();
		Transformer transformer = tfactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		DOMSource source = new DOMSource(documento);
		StreamResult result = new StreamResult(new File(path));
		transformer.transform(source, result);
		
	}catch (ParserConfigurationException | TransformerException e) {
		e.printStackTrace();
	}
	}
		
	
		
		
		
		
		
	
}
