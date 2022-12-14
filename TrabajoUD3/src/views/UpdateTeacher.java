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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Teacher;
import app.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateTeacher.
 */
public class UpdateTeacher extends JFrame {

	/** The jlemail. */
	private JLabel jlname, jllastname, jlemail;
	
	/** The jtrole. */
	private JTextField jtdni, jtname, jtlastname, jtemail, jtrole = new JTextField("Teacher");;
	
	/** The jppassword 2. */
	private JPasswordField jppassword, jppassword2;
	
	/** The jbcancel. */
	private JButton jbconfirm, jbcancel;
	
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
	 * Instantiates a new update teacher.
	 *
	 * @param idTeacher the id teacher
	 */
	public UpdateTeacher(String idTeacher) {
		// creamos el frame insertar
		super("Update Teacher");
		inicializate(UpdateTeacher.this);
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
		jtdni = new JTextField(teacher.getDni());

		jppassword = new JPasswordField(user.getPassword());

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
		jtname.setToolTipText("Modify the tachers name");
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
		jtlastname.setToolTipText("Modify the tachers last name");
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
		jtemail.setToolTipText("Modify the tachers email");
		getContentPane().add(jtemail);

		// Boton next
		jbconfirm = new JButton("");
		jbconfirm.setIcon(new ImageIcon("images/BlackTick.png"));
		jbconfirm.setToolTipText("Confirm");
		jbconfirm.setBackground(new Color(0, 153, 0));
		jbconfirm.setBounds(276, 302, 115, 37);
		jbconfirm.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean verification = true;

				JTextField[] group = { jtname, jtlastname, jtemail };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				if (verification) {
					if (jtdni.getText().matches(sdni)) {
						if (jtemail.getText().matches(semail)) {
							try {
								
								Functions f = new Functions();
								f.DeleteUser(idTeacher);
								f.WriteUser(jtdni.getText(), jppassword.getText(), jtrole.getText());
								f.WriteTeacher(jtdni.getText(), jtname.getText(), jtlastname.getText(),
										jtemail.getText());
								f.close();
								
								dispose();
								MainWindowAdmin mainAdmin = new MainWindowAdmin();

							} catch (SQLException e1) {
								Icon icon = new ImageIcon("images/warning.png");
								JOptionPane.showMessageDialog(null, "Duplicated ID", "Error",
										JOptionPane.WARNING_MESSAGE, icon);
							}

						} else {
							icon = new ImageIcon("images/warning.png");
							JOptionPane.showMessageDialog(null, "Email does not meet the required parameters", "Error",
									JOptionPane.INFORMATION_MESSAGE, icon);
						}
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(null, "DNI does not meet the required parameters", "Error",
								JOptionPane.INFORMATION_MESSAGE, icon);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to create the user.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}

			}
		});
		getContentPane().add(jbconfirm);

		// Boton cancel

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
		jf.getContentPane().setLayout(new GridLayout(4, 2));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}
}
