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

import app.Qualifies;
import app.RA;
import app.SchoolEnrollment;
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
	Qualifies qualifie;
	RA ra;
	SchoolEnrollment schoolEnrollment;
	
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
	
	public List<SchoolEnrollment> getSchoolEnrollment(String dni_alum) {

		List<SchoolEnrollment> listSchoolEnrollment=new ArrayList<SchoolEnrollment>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM MATRICULA WHERE DNI_ALUMNO= '" + dni_alum+ "'");

			while (rs.next()) {
				schoolEnrollment = new SchoolEnrollment();
				schoolEnrollment.setDni_student(rs.getString("DNI_Alumno"));
				schoolEnrollment.setId_subject(rs.getInt("Cod_Asig"));
				listSchoolEnrollment.add(schoolEnrollment);
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listSchoolEnrollment;
	}
	
	public List<SchoolEnrollment> getSchoolEnrollmentTeacher(int id_subj) {

		List<SchoolEnrollment> listSchoolEnrollment=new ArrayList<SchoolEnrollment>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM MATRICULA WHERE COD_ASIG= '" + id_subj+ "'");

			while (rs.next()) {
				schoolEnrollment = new SchoolEnrollment();
				schoolEnrollment.setDni_student(rs.getString("DNI_Alumno"));
				schoolEnrollment.setId_subject(rs.getInt("Cod_Asig"));
				listSchoolEnrollment.add(schoolEnrollment);
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listSchoolEnrollment;
	}
	
	public void DeleteSchoolEnrollment(int id_asig, String dni_alum) {

		Subject s = new Subject();
		try {
			statement.execute("DELETE FROM MATRICULA WHERE DNI_ALUMNO= '" + dni_alum + "' AND COD_ASIG= '"+id_asig+"'");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	//lectura mainwindows student
	public List<Subject> getSubjects(int cod_asig) {

		List<Subject> listSubjects = new ArrayList<Subject>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM asignatura WHERE Codigo= '"+cod_asig+"'");

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
	
	public List<Subject> getSubjectsTeacher(String id_teacher) {

		List<Subject> listSubjects = new ArrayList<Subject>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM asignatura WHERE DNI_Profesor= '"+id_teacher+"'");

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
	
	public List<RA> getRAs(int id_asig) {

		List<RA> listRA=new ArrayList<RA>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM RA WHERE ID_ASIG= '" + id_asig+ "'");

			while (rs.next()) {
				ra = new RA();
				ra.setId(rs.getInt("ID"));
				ra.setName(rs.getString("Nombre"));
				ra.setDescription(rs.getString("Descripcion"));
				ra.setWeighing(rs.getInt("Ponderacion"));
				ra.setId_subject(rs.getInt("ID_Asig"));;
				listRA.add(ra);
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listRA;
	}
	
	public RA ReadRA(int id) {

		RA ra = new RA();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM RA");

			while (rs.next()) {

				if (id == rs.getInt("ID")) {
					ra.setId(rs.getInt("ID"));
					ra.setName(rs.getString("Nombre"));
					ra.setDescription(rs.getString("Descripcion"));
					ra.setWeighing(rs.getInt("Ponderacion"));
					ra.setId_subject(rs.getInt("ID_Asig"));
				}
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return ra;
	}
	
	public void WriteRA(int id, String name, String description, int weighing,int id_sub) throws SQLException {

		PreparedStatement ps;
		String sql;
		ra = new RA();
		ra.setId(id);
		ra.setName(name);
		ra.setDescription(description);
		ra.setWeighing(weighing);
		ra.setId_subject(id_sub);

		sql = "insert into RA(ID, Nombre, Descripcion, Ponderacion, ID_Asig) values(?,?,?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, ra.getId());
		ps.setString(2, ra.getName());
		ps.setString(3, ra.getDescription());
		ps.setInt(4, ra.getWeighing());
		ps.setInt(5, ra.getId_subject());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}
	
	public void DeleteRA(int id) {
		try {
			statement.execute("DELETE FROM RA WHERE ID= '" + id + "'");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
	
	public List<Qualifies> getQualifies(String dni,int id_ra) {

		List<Qualifies> listQualifies=new ArrayList<Qualifies>();
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM CALIFICA WHERE DNI_ALUMNO= '" + dni + "'"+" AND ID_RA= '"+id_ra+"'");

			while (rs.next()) {
				qualifie = new Qualifies();
				qualifie.setDni_student(rs.getString("DNI_Alumno"));
				qualifie.setId_RA(rs.getInt("ID_RA"));
				qualifie.setMark(rs.getInt("Nota"));
				listQualifies.add(qualifie);
			}

			rs.close();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listQualifies;
	}
	
	public void writeMark(String dni_alum, int id_sub,float mark) throws SQLException {

		PreparedStatement ps;
		String sql;
		qualifie = new Qualifies();
		qualifie.setDni_student(dni_alum);
		qualifie.setId_RA(id_sub);
		qualifie.setMark(mark);

		sql = "insert into CALIFICA (DNI_Alumno, ID_RA, Nota) values(?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, qualifie.getDni_student());
		ps.setInt(2, qualifie.getId_RA());
		ps.setFloat(3, qualifie.getMark());
		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}
	
	public void updateMark(String dni_alum, int id_ra,float mark) throws SQLException {

		PreparedStatement ps;

		ps = connection.prepareStatement("UPDATE califica SET Nota= "+mark+ " WHERE DNI_Alumno= '"+dni_alum+"' AND ID_RA= '"+id_ra+"'");

		ps.executeUpdate();

		Icon icon = new ImageIcon("images/check.png");
		JOptionPane.showMessageDialog(null, "Data inserted", "Completed", JOptionPane.INFORMATION_MESSAGE, icon);

	}
	
	public List<Object[]> viewStudents(String dni) {
		List<Object[]> listSubjects = new ArrayList<Object[]>();
		try {
			String insertquery = "SELECT r.ID_Asig,a.Nombre, SUM(c.nota*(r.ponderacion/100)) 'Nota' FROM califica c, matricula m, ra r,asignatura a WHERE '"
					+ dni
					+ "' = m.DNI_Alumno AND m.DNI_Alumno =c.DNI_Alumno AND r.ID=c.ID_RA AND r.ID_Asig=m.Cod_Asig AND a.Codigo =r.ID_Asig GROUP BY r.ID_Asig;";
			ResultSet result = statement.executeQuery(insertquery);
			while (result.next()) {
				Object[] data = { result.getString("ID_Asig"), result.getString("Nombre"), result.getString("Nota") };
				listSubjects.add(data);
			}
		} catch (SQLException ex) {
			System.out.println("Problem To Show Data");
		}
		return listSubjects;
	}

	public List<Object[]> viewStudentsRA(String dni, int codAsig) {
		List<Object[]> listSubjectsRA = new ArrayList<Object[]>();

		try {

			String insertquery = "SELECT c.ID_RA, r.Nombre, c.Nota, r.Ponderacion FROM califica c, matricula m, ra r WHERE '"
					+ dni + "' = m.DNI_Alumno AND m.DNI_Alumno =c.DNI_Alumno AND r.ID=c.ID_RA AND r.ID_Asig='" + codAsig
					+ "' GROUP BY r.id;";

			ResultSet result = statement.executeQuery(insertquery);

			while (result.next()) {

				Object[] data = { result.getString("ID_RA"), result.getString("Nombre"), result.getString("Nota"),
						result.getString("Ponderacion") };
				listSubjectsRA.add(data);
				
			}
		} catch (SQLException ex) {
			System.out.println("Problem To Show Data");
		}

		return listSubjectsRA;
	}


	public void close() throws SQLException {
		statement.close();
		connection.close();
	}
}
