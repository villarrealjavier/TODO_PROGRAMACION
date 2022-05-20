package actividad.writer;

public class MainApp {

	public static void main(String[] args) {
		FicheroWriter wr = new FicheroWriter();
		wr.escribirEnFicheroPorLineas("./archivo/prueba.txt");
		
	}

}
