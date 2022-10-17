package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
@SuppressWarnings("serial")
public class Login extends JFrame {

	/** The jltitle. */
	private JLabel jlid, jlpassword, jltitle;

	/** The jbaccess. */
	private JButton jbregister, jbaccess;

	/** The jtusername. */
	private JTextField jtid;

	/** The jppassword. */
	private JPasswordField jppassword;

	/** The icon. */
	private Icon icon;

	/** The jpanel 4. */
	private JPanel jpanel1, jpanel2, jpanel3, jpanel4;

	/** The fusers. */
	private File fusers = new File("files/Users");

	private String sid = "[0-9]{8}[A-Z]";

	/**
	 * Instantiates a new login.
	 */
	public Login() {
		super("Login");
		getContentPane().setBackground(new Color(0, 176, 220));
		inicializate(Login.this);

		jtid = new JTextField();
		jtid.setBounds(133, 68, 96, 19);
		jtid.setBackground(Color.WHITE);
		jtid.setColumns(10);
		jtid.setToolTipText("Introduce your id");
		getContentPane().add(jtid);

		jltitle = new JLabel("School");
		jltitle.setBounds(87, 21, 96, 36);
		jltitle.setVerticalAlignment(SwingConstants.BOTTOM);
		jltitle.setHorizontalAlignment(SwingConstants.CENTER);
		jltitle.setForeground(new Color(0, 70, 101));
		jltitle.setIcon(new ImageIcon("images/School.png"));
		jltitle.setFont(new Font("Microsoft Himalaya", Font.BOLD, 25));
		getContentPane().add(jltitle);

		jlid = new JLabel("User ID:");
		jlid.setBounds(53, 69, 70, 21);
		jlid.setHorizontalAlignment(SwingConstants.CENTER);
		jlid.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlid);

		jlpassword = new JLabel("Password:");
		jlpassword.setBounds(53, 100, 70, 21);
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(133, 98, 96, 21);
		jppassword.setBackground(Color.WHITE);
		jppassword.setColumns(10);
		jppassword.setToolTipText("Introduce your password");
		jppassword.addActionListener(new Handler());
		getContentPane().add(jppassword);

		jbregister = new JButton();
		jbregister.setBounds(38, 144, 85, 36);
		jbregister.setBackground(new Color(0, 176, 220));
		jbregister.setToolTipText("Register");
		jbregister.setBorderPainted(false);
		jbregister.setIcon(new ImageIcon("images/register.png"));
		jbregister.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				dispose();
			}
		});
		getContentPane().add(jbregister);

		jbaccess = new JButton();
		jbaccess.setBounds(153, 144, 85, 36);
		jbaccess.setBackground(new Color(0, 176, 220));
		jbaccess.setToolTipText("Login");
		jbaccess.setBorderPainted(false);
		jbaccess.setIcon(new ImageIcon("images/login.png"));
		jbaccess.addActionListener(new Handler());
		getContentPane().add(jbaccess);

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
		jf.setSize(300, 230);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(null);
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}

	/**
	 * The Class Handler.
	 */
	private class Handler implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@SuppressWarnings({ "deprecation", "unused" })
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean existUser = false;
			boolean passwordCorrect = false;
			try {
				Functions f = new Functions();
				if (jtid.getText().isBlank() == false) {
					if (jtid.getText().equals("admin") && jppassword.getText().equals("admin")) {
						MainWindowAdmin mainAdmin = new MainWindowAdmin(jtid.getText());
						dispose();
					} else {
						if (jtid.getText().matches(sid)) {

							User us = f.Read(jtid.getText());
							if (us.getDni().equals(jtid.getText())) {
								existUser = true;
								if (us.getPassword().equals(jppassword.getText())) {
									passwordCorrect = true;
								}

								if (passwordCorrect == true) {
									if (us.getRole().equals("Student")) {
										MainWindowStudent mainStudent = new MainWindowStudent(jtid.getText());

									} else if (us.getRole().equals("Teacher")) {
										MainWindowTeacher mainTeacher = new MainWindowTeacher(jtid.getText());
									}
									dispose();
								} else {
									icon = new ImageIcon("images/warning.png");
									JOptionPane.showMessageDialog(null, "Incorrect password", "Error",
											JOptionPane.WARNING_MESSAGE, icon);
								}

							} else {
								icon = new ImageIcon("images/warning.png");
								JOptionPane.showMessageDialog(null, "The user doesn't exists", "Error",
										JOptionPane.WARNING_MESSAGE, icon);
							}
						} else {
							icon = new ImageIcon("images/warning.png");
							JOptionPane.showMessageDialog(null, "DNI not valid", "Error", JOptionPane.WARNING_MESSAGE,
									icon);
						}
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "User name is empty", "Error", JOptionPane.WARNING_MESSAGE,
							icon);
				}
				f.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}