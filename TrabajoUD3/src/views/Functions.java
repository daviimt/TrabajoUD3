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

import com.mysql.cj.xdevapi.Result;

import app.Student;
import app.Subject;
import app.Teacher;
import app.User;

public class Functions {

	Statement statement;
	Connection connection;
	User user;
	Student student;
	Teacher teacher;
	Subject subject;

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

	public User Read(String dni) {

		User u = new User();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {

				if (dni.equals(rs.getString("ID"))) {
					u = new User();
					u.setDni(rs.getString("ID"));
					u.setPassword(rs.getString("Password"));
					u.setRole(rs.getString("Rol"));
				}
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return u;
	}

	public Student ReadStudent(String dni) {

		Student  student = new Student();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM alumno");

			while (rs.next()) {

				if (dni.equals(rs.getString("DNI"))) {
					student.setDni(rs.getString("DNI"));
					student.setName(rs.getString("Nombre"));
					student.setLastname(rs.getString("Apellidos"));
					student.setBirth_date(rs.getString("Fecha_Nac"));
					student.setPhone(rs.getString("Telefono"));
					student.setPhoto(rs.getString("Foto"));
				}
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return student;
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
		ps.setString(4, student.getBirth_date());
		ps.setString(5, student.getPhone());
		ps.setString(6, student.getPhoto());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);
	}

	public Teacher ReadTeacher(String dni) {

		Teacher teacher = new Teacher();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM profesor");

			while (rs.next()) {

				if (dni.equals(rs.getString("DNI"))) {
					//teacher = new Teacher();
					teacher.setDni(rs.getString("DNI"));
					teacher.setName(rs.getString("Nombre"));
					teacher.setLastname(rs.getString("Apellidos"));
					teacher.setEmail(rs.getString("email"));
				}
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return teacher;
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

	public List<User> ReadUsers() {

		List<User> listUsers = new ArrayList<User>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				user = new User();
				user.setDni(rs.getString("ID"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getString("Rol"));
				listUsers.add(user);
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listUsers;
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

	public void DeleteUser(String id) {
		try {
			statement.execute("DELETE FROM usuarios WHERE ID= '" + id + "'");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public List<Subject> ReadSubjects() {

		List<Subject> listSubjects = new ArrayList<Subject>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM asignatura");

			while (rs.next()) {
				subject = new Subject();
				subject.setId(rs.getInt("Codigo"));
				subject.setName(rs.getString("Nombre"));
				subject.setHours(rs.getInt("Horas"));
				subject.setDni_teacher(rs.getString("DNI_Profesor"));
				listSubjects.add(subject);
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listSubjects;
	}

	public Subject ReadSubject(int id) {

		Subject subject = new Subject();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM asignatura");

			while (rs.next()) {

				if (id == rs.getInt("Codigo")) {
					subject = new Subject();
					subject.setId(rs.getInt("Codigo"));
					subject.setName(rs.getString("Nombre"));
					subject.setHours(rs.getInt("Horas"));
					subject.setDni_teacher(rs.getString("DNI_Profesor"));
				}
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return subject;
	}

	public void WriteSubject(int id, String name, int hours, String dni_teacher) throws SQLException {

		PreparedStatement ps;
		String sql;
		subject = new Subject();
		subject.setId(id);
		subject.setName(name);
		subject.setHours(hours);
		subject.setDni_teacher(dni_teacher);

		sql = "insert into asignatura(Codigo, Nombre, Horas, DNI_Profesor) values(?,?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, subject.getId());
		ps.setString(2, subject.getName());
		ps.setInt(3, subject.getHours());
		ps.setString(4, subject.getDni_teacher());
		ps.executeUpdate();

	}

	public Subject DeleteSubject(int id) {

		Subject s = new Subject();
		try {
			statement.execute("DELETE FROM ASIGNATURA WHERE CODIGO= '" + id + "'");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return s;
	}

	public void close() throws SQLException {
		statement.close();
		connection.close();
	}
}
