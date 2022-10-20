package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Teacher;
import app.User;

// TODO: Auto-generated Javadoc
/**
 * The Class DetailsTeacher.
 */
public class DetailsTeacher extends JFrame {

	/** The jlemail. */
	private JLabel jldni,jlname, jllastname, jlemail;
	
	/** The jtrole. */
	private JTextField jtdni, jtname, jtlastname, jtemail, jtrole = new JTextField("Teacher");;
	
	/** The jppassword 2. */
	private JPasswordField jppassword, jppassword2;
	
	/** The jbcancel. */
	private JButton jbcancel;
	
	/** The icon. */
	private Icon icon;
	
	/** The imagen. */
	static Image imagen;
	
	/** The img 2. */
	ImageIcon img2;
	
	/** The sdni. */
	private String sdni = "[0-9]{8}[A-Z]";
	
	/** The semail. */
	private String semail = "^[A-Za-z0-9]+@[A-Za-z0-9]+.([A-Za-z0-9]+)$";
	
	/** The sphone. */
	private String sphone = "[0-9]{9}";
	
	/** The spassw. */
	private String spassw = "[A-Za-z\\d$@$#_!%*?&]{6,15}$";

	/**
	 * Instantiates a new details teacher.
	 *
	 * @param idTeacher the id teacher
	 */
	public DetailsTeacher(String idTeacher) {
		// creamos el frame insertar
		super("Details Teacher");
		inicializate(DetailsTeacher.this);
		Teacher teacher=new Teacher();
		User user=new User();
		
		try {
			Functions f = new Functions();
			teacher = f.ReadTeacher(idTeacher);
			user = f.Read(idTeacher);
			f.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		jppassword = new JPasswordField(user.getPassword());
		jldni = new JLabel("D.N.I. : ");
		jldni.setBackground(new Color(0, 176, 220));
		jldni.setBounds(147, 122, 84, 13);
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni);
		
		jtdni = new JTextField(teacher.getDni());
		jtdni.setBounds(241, 119, 167, 19);
		jtdni.setBackground(new Color(0, 176, 220));
		jtdni.setColumns(12);
		jtdni.setToolTipText("Teachers DNI");
		jtdni.setEditable(false);
		getContentPane().add(jtdni);
		
		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(147, 62, 72, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);

		jtname = new JTextField(teacher.getName());
		jtname.setBounds(242, 59, 167, 19);
		jtname.setBackground(new Color(0, 176, 220));
		jtname.setColumns(10);
		jtname.setToolTipText("Teachers name");
		jtname.setEditable(false);
		getContentPane().add(jtname);

		jllastname = new JLabel("Last name:");
		jllastname.setBackground(new Color(0, 176, 220));
		jllastname.setBounds(137, 92, 94, 13);
		jllastname.setHorizontalAlignment(SwingConstants.CENTER);
		jllastname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jllastname);

		jtlastname = new JTextField(teacher.getLastname());
		jtlastname.setBounds(242, 89, 167, 19);
		jtlastname.setBackground(new Color(0, 176, 220));
		jtlastname.setColumns(10);
		jtlastname.setToolTipText("Teachers last name");
		jtlastname.setEditable(false);
		getContentPane().add(jtlastname);

		jlemail = new JLabel("Email:");
		jlemail.setBackground(new Color(0, 176, 220));
		jlemail.setBounds(137, 92, 94, 13);
		jlemail.setHorizontalAlignment(SwingConstants.CENTER);
		jlemail.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlemail);

		jtemail = new JTextField(teacher.getEmail());
		jtemail.setBounds(242, 89, 167, 19);
		jtemail.setBackground(new Color(0, 176, 220));
		jtemail.setColumns(10);
		jtemail.setToolTipText("Teachers email");
		jtemail.setEditable(false);
		getContentPane().add(jtemail);

		jbcancel = new JButton("");
		jbcancel.setBounds(48, 302, 112, 37);
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowAdmin mainteach = new MainWindowAdmin();
			}
		});
		
		getContentPane().add(jbcancel);
		setVisible(true);
	}

	/**
	 * Inicializate.
	 *
	 * @param jf the jf
	 */
	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(new Color(0, 176, 220));
		jf.getContentPane().setBackground(new Color(0, 176, 220));
		jf.setBounds(100, 100, 340, 220);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(new GridLayout(5, 2));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}
}
