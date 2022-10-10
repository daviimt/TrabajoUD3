package views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	public Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
		}

		try {

			String url = "jdbc:mysql://localhost:3306/curso_dam";
			String username = "root";
			String password = "";

			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");

				System.out.println(String.format("%s %s", nombre, apellido));
			}

			rs.close();
			statement.close();
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}
