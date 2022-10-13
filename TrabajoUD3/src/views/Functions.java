package views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import app.Student;
import app.Teacher;
import app.User;

public class Functions {

	Statement statement;
	Connection connection;
	User user;
	Student student;
	Teacher teacher;

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

	public User Read(String id) {

		User u = new User();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {

				if (id.equals(rs.getString("ID"))) {
					String code = rs.getString("ID");
					String passw = rs.getString("Password");
					String role = rs.getString("Rol");
					u.setDni(code);
					u.setPassword(passw);
					u.setRole(role);
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

//	public User ReadStudent(User u) {
//
//		Student  s = new Student();
//		try {
//
//			ResultSet rs = statement.executeQuery("SELECT * FROM alumno");
//
//			while (rs.next()) {
//
//				if (u.getId() == rs.getInt("ID")) {
//					student = new Student();
//					student.setId(u.getId());
//					student.setDni(dni);
//					student.setName(name);
//					student.setLastname(lastname);
//					student.setBirth_date(birth_date);
//					student.setPhone(phone);
//					student.setPhoto(photo);
//
//					ps.setInt(1, student.getId());
//					ps.setString(2, student.getDni());
//					ps.setString(3, student.getName());
//					ps.setString(4, student.getLastname());
//					ps.setDate(5, student.getBirth_date());
//					ps.setString(6, student.getPhone());
//					ps.setString(7, student.getPhoto());
//				}
//			}
//
//			rs.close();
//			statement.close();
//			connection.close();
//
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		}
//		return u;
//	}

	public List<Teacher> ReadTeacher() {

		List<Teacher> listTeacher = new ArrayList<Teacher>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM profesor");

			while (rs.next()) {
				teacher = new Teacher();
				teacher.setDni(rs.getString("DNI"));
				teacher.setName(rs.getString("Nombre"));
				teacher.setLastname(rs.getString("Apellidos"));
				teacher.setEmail(rs.getString("email"));
				listTeacher.add(teacher);
			}

			rs.close();
			statement.close();
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listTeacher;
	}

	public void WriteUser(String dni, String password, String role) throws SQLException {

		PreparedStatement ps;
		String sql;
		user = new User();
		user.setDni(dni);
		user.setPassword(password);
		user.setRole(role);

		sql = "insert into usuarios(ID, Password, Rol) values(?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, user.getDni());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRole());
		ps.executeUpdate();

	}

	public void WriteStudent(String dni, String name, String lastname, String birth_date, String phone, String photo)
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

		sql = "insert into alumno(DNI, Nombre, Apellidos, Fecha_Nac, Telefono, Foto) values(?,?,?,?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, student.getDni());
		ps.setString(2, student.getName());
		ps.setString(3, student.getLastname());
		System.out.println(student.getBirth_date());
		ps.setString(4, student.getBirth_date());
		ps.setString(5, student.getPhone());
		ps.setString(6, student.getPhoto());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}

	public void WriteTeacher(String dni, String name, String lastname, String email) throws SQLException {

		PreparedStatement ps;
		String sql;
		teacher = new Teacher();
		teacher.setDni(dni);
		teacher.setName(name);
		teacher.setLastname(lastname);
		teacher.setEmail(email);

		sql = "insert into profesor(DNI, Nombre, Apellidos, Email) values(?,?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, teacher.getDni());
		ps.setString(2, teacher.getName());
		ps.setString(3, teacher.getLastname());
		ps.setString(4, teacher.getEmail());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}

}
