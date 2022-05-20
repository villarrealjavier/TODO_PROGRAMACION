package main.java.main;

import main.java.model.Catalogo;
import main.java.model.Serie;
import main.java.model.Tema;
import main.java.model.Temporada;

public class MainApp {
	/**
	 * Cuestion: Yo pienso que para los capitulos se ha optado por una lista debido a que a parte de
	 * que tan solo debemos de almacenar el nombre del capitulo, mediante esta la podemos ordenar de manera
	 * sencilla ya que posee orden y a parte pienso que es una muy buena estructura para almacenarla.
	 * @param args
	 */

	public static void main(String[] args) {
		Temporada temp1 = new Temporada("Temporada1");
		temp1.annadirCapitulo("Aida");
		//temp1.eliminarCapitulo("Julia");
		//temp1.eliminarCapitulo("Aida");
		//temp1.valorar(5);
		//temp1.valorar(5);
		//temp1.valorar(9);
		//System.out.println(temp1.getNotaMedia());
		//temp1.annadirCapitulo("LOCO");
		//temp1.annadirCapitulo("Yuli");
		//temp1.annadirCapituloDespues("lOCURA", "LOCO");
		//System.out.println(temp1.primerCapituloQueContieneEstaPalabra("Ai"));
		Serie s1 = new Serie("Aida", 2003, Tema.COMEDIA);
		temp1.annadirCapitulo("Juli");
		temp1.annadirCapitulo("Yuli");
		s1.annadirCapituloTemporada("Temporada 1", "Juli");
		s1.annadirCapituloTemporada("Temporada 1", "Yuli");
		Catalogo c1 = new Catalogo();
		c1.annadirTemporada("Aida", "Temporada1");
		
		//s1.annadirTemporada("Temporada 1");
		//s1.annadirTemporada("Temporada 2");
		//System.out.println(s1.listadoTemporadasPorNotaMedia());
		

	}

}
