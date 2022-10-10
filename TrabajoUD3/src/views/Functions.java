package views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import app.User;

public class Functions {

	Statement statement;
	Connection connection;
	User user;
	public Functions() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/curso_dam";
			String username = "root";
			String password = "";

			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception ex) {
			System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
		}
	}

	public void Read() {
		try {

			statement = connection.createStatement();
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

	public void Write(int id, String password, String role) {
		
	        PreparedStatement ps;
	        String sql;
	        user=new User();
	        user.setId(id);
	        user.setPassword(password);
	        user.setRole(role);
	        try{
	            sql = "insert into usuarios(Codigo, Password, Rol) values(?,?,?)";
	            ps = connection.prepareStatement(sql);
	            ps.setInt(1, user.getId());
	            ps.setString(2, user.getPassword());
	            ps.setString(3, user.getRole());
	            ps.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Data inserted");
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Connection error: " + e.getMessage());
	        }
	    
	}
}
