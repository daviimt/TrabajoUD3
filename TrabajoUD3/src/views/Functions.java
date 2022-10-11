package views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import app.Student;
import app.User;

public class Functions {

	Statement statement;
	Connection connection;
	User user;
	Student student;

	public Functions() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/curso_dam";
			String username = "root";
			String password = "";

			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();

		} catch (Exception ex) {
			System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
		}
	}

	public User Read(int id) {

		User u = new User();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {

				if (id == rs.getInt("Codigo")) {
					int cod = rs.getInt("Codigo");
					String contra = rs.getString("Password");
					String rol = rs.getString("Rol");
					u.setId(cod);
					u.setPassword(contra);
					u.setRole(rol);
				}
			}

			rs.close();
			statement.close();
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return u;
	}

	public void WriteUser(int id, String password, String role) throws SQLException {

		PreparedStatement ps;
		String sql;
		user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setRole(role);

		sql = "insert into usuarios(Codigo, Password, Rol) values(?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRole());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}

	public void WriteStudent(String dni, String name, String lastname, Date birth_date, String phone, String photo)
			throws SQLException {

		PreparedStatement ps;
		String sql;
		student = new Student();
		student.setDni(dni);
		student.setName(name);
		student.setLastname(lastname);
		student.setBirth_date(birth_date);
		student.setPhone(phone);
		student.setPhoto(photo);

		sql = "insert into alumnos(Dni, Nombre, Apellido, Fecha_Nac, Telefono,Foto) values(?,?,?,?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, student.getDni());
		ps.setString(2, student.getName());
		ps.setString(3, student.getLastname());
		ps.setDate(4, student.getBirth_date());
		ps.setString(5, student.getPhone());
		ps.setString(6, student.getPhoto());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}

}
