package vistas;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class Register.
 */
@SuppressWarnings("serial")
public class Registro extends JFrame {

	/** The jlpassword 2. */
	private JLabel jlusername, jlname, jldni, jlemail, jlpassword, jlpassword2;

	/** The jtemail. */
	private JTextField jtusername, jtname, jtdni, jtemail;

	/** The jppassword 2. */
	private JPasswordField jppassword, jppassword2;

	/** The jbcancel. */
	private JButton jbconfirm, jbcancel;

	/** The icon. */
	private Icon icon;

	/** The sdni. */
	private String sdni = "[0-9]{8}[A-Za-z]";

	/** The semail. */
	private String semail = "^[A-Za-z0-9]+@[A-Za-z0-9]+.([A-Za-z0-9]+)$";

	/** The spassw. */
	private String spassw = "[A-Za-z\\d$@$#_!%*?&]{6,15}$";

	/** The fusers. */
	private File fusers = new File("files/Users");

	/**
	 * Instantiates a new register.
	 */
	public Registro() {

		super("Registrar un usuario");
		getContentPane().setBackground(new Color(102, 204, 153));
		inicializate(Registro.this);

		jlusername = new JLabel("Username:");
		jlusername.setBackground(new Color(252, 228, 163));
		jlusername.setBounds(24, 30, 94, 13);
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		jlusername.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlusername);

		jtusername = new JTextField();
		jtusername.setBounds(119, 27, 114, 19);
		jtusername.setBackground(new Color(0, 176, 220));
		jtusername.setColumns(10);
		jtusername.setToolTipText("Introduce your user");
		getContentPane().add(jtusername);

		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(24, 53, 94, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setBounds(119, 50, 114, 19);
		jtname.setBackground(new Color(0, 176, 220));
		jtname.setColumns(10);
		jtname.setToolTipText("Introduce your name");
		getContentPane().add(jtname);

		jldni = new JLabel("D.N.I. : ");
		jldni.setBackground(new Color(0, 176, 220));
		jldni.setBounds(24, 122, 94, 13);
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni);

		jtdni = new JTextField();
		jtdni.setBounds(119, 119, 114, 19);
		jtdni.setBackground(new Color(0, 176, 220));
		jtdni.setColumns(12);
		jtdni.setToolTipText("Introduce your DNI");
		getContentPane().add(jtdni);

		jlemail = new JLabel("Email: ");
		jlemail.setBackground(new Color(0, 176, 220));
		jlemail.setBounds(24, 145, 94, 13);
		jlemail.setHorizontalAlignment(SwingConstants.CENTER);
		jlemail.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlemail);

		jtemail = new JTextField();
		jtemail.setBounds(119, 142, 114, 19);
		jtemail.setBackground(new Color(0, 176, 220));
		jtemail.setColumns(13);
		jtemail.setToolTipText("Introduce your email");
		getContentPane().add(jtemail);

		jlpassword = new JLabel("Password: ");
		jlpassword.setBackground(new Color(0, 176, 220));
		jlpassword.setBounds(24, 191, 94, 13);
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(119, 188, 114, 19);
		jppassword.setBackground(new Color(0, 176, 220));
		jppassword.setColumns(10);
		jppassword.setToolTipText("Introduce your password");
		getContentPane().add(jppassword);

		jlpassword2 = new JLabel("Repeat Pass.: ");
		jlpassword2.setBackground(new Color(0, 176, 220));
		jlpassword2.setBounds(24, 214, 94, 13);
		jlpassword2.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword2.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlpassword2);

		jppassword2 = new JPasswordField();
		jppassword2.setBounds(119, 211, 114, 19);
		jppassword2.setBackground(new Color(0, 176, 220));
		jppassword2.setColumns(10);
		jppassword2.setToolTipText("Repeat your password");
		getContentPane().add(jppassword2);

		jbconfirm = new JButton("");
		jbconfirm.setIcon(new ImageIcon("images/BlackTick.png"));
		jbconfirm.setToolTipText("Confirm");
		jbconfirm.setBackground(new Color(0, 153, 0));
		jbconfirm.setBounds(150, 364, 85, 21);
		jbconfirm.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean verification = true;

				JTextField[] group = { jtusername, jtname, jtdni, jtemail, jppassword, jppassword2 };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				if (verification) {
					if (jtdni.getText().matches(sdni)) {
						if (jtemail.getText().matches(semail)) {
							if (jppassword.getText().matches(spassw)) {
								if (jppassword2.getText().equals(jppassword.getText())) {

									try {
										FileWriter fw = new FileWriter(fusers, true);
										fw.write(jtusername.getText() + ";" + jtname.getText() + ";" + jtdni.getText()
												+ ";" + jtemail.getText() + ";" + jppassword.getText() + "\n");
										fw.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									icon = new ImageIcon("images/check.png");
									JOptionPane.showMessageDialog(null, "User creation complete.", "Complete",
											JOptionPane.INFORMATION_MESSAGE, icon);
									dispose();
									Login login = new Login();

								} else {
									icon = new ImageIcon("images/warning.png");
									JOptionPane.showMessageDialog(null, "Passwords don't match", "Error",
											JOptionPane.WARNING_MESSAGE, icon);
								}

							} else {
								icon = new ImageIcon("images/warning.png");
								JOptionPane.showMessageDialog(null, "Password does not meet the required parameters",
										"Error", JOptionPane.WARNING_MESSAGE, icon);
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

		jbcancel = new JButton("");
		jbcancel.setBounds(342, 364, 85, 21);
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();

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
		jf.setSize(300, 285);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(new GridLayout(7, 2));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);
	}

}
