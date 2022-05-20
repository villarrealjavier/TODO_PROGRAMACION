package basededatos.main;

import java.io.IOException;
import java.sql.SQLException;

public class MainApp {
	public static void main(String[] args) throws IOException {
		try {
			new Conector().conectarBaseDeDatos("./files/ficheroprueba.csv");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
