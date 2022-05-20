package basededatos.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class Conector {
	
	public static void conectarBaseDeDatos(String path) throws SQLException, IOException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "rootpass");
		File file = new File(path);
		
		PrintWriter filtroEscritura=new PrintWriter(file);


	Statement st = connection.createStatement();
	ResultSet resultSet = st.executeQuery("select * from alumno");
	if (!file.exists()) {
		file.createNewFile();
	}
	while(resultSet.next()) {
		filtroEscritura.println(resultSet.getString(1)+"," + resultSet.getString(2)+"," + resultSet.getString(3)+"\n");
		
		
	}
	filtroEscritura.close();
}
	
}