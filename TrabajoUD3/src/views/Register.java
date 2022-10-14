package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class Register extends JFrame {

	private JLabel jldni, jlname, jllastname, jldate, jlphone, jlpassword, jlpassword2, jlImage;
	private JTextField jtdni, jtname, jtlastname, jtdate, jtphone, jtphoto, jtrole = new JTextField("Student");
	private JPasswordField jppassword, jppassword2;
	private JButton jbconfirm, jbcancel, jbphoto;
	private Icon icon;
	static Image imagen;
	ImageIcon img2;
	private String sdni = "[0-9]{8}[A-Z]";
	private String sphone = "[0-9]{9}";
	private String spassw = "[A-Za-z\\d$@$#_!%*?&]{6,15}$";
	private JDateChooser dateChooser;
	private String date_birth;

	public Register() {

		super("Register an user");
		getContentPane().setBackground(new Color(102, 204, 153));
		inicializate(Register.this);

		jldni = new JLabel("D.N.I. : ");
		jldni.setBackground(new Color(0, 176, 220));
		jldni.setBounds(147, 122, 84, 13);
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni);

		jtdni = new JTextField();
		jtdni.setBounds(241, 119, 167, 19);
		jtdni.setBackground(Color.WHITE);
		jtdni.setColumns(12);
		jtdni.setToolTipText("Introduce your DNI");
		getContentPane().add(jtdni);

		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(147, 62, 72, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setBounds(242, 59, 167, 19);
		jtname.setBackground(Color.WHITE);
		jtname.setColumns(10);
		jtname.setToolTipText("Introduce your name");
		getContentPane().add(jtname);

		jllastname = new JLabel("Last name:");
		jllastname.setBackground(new Color(0, 176, 220));
		jllastname.setBounds(137, 92, 94, 13);
		jllastname.setHorizontalAlignment(SwingConstants.CENTER);
		jllastname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jllastname);

		jtlastname = new JTextField();
		jtlastname.setBounds(242, 89, 167, 19);
		jtlastname.setBackground(Color.WHITE);
		jtlastname.setColumns(10);
		jtlastname.setToolTipText("Introduce your last name");
		getContentPane().add(jtlastname);

		jldate = new JLabel("Date: ");
		jldate.setBackground(new Color(0, 176, 220));
		jldate.setBounds(137, 145, 94, 20);
		jldate.setHorizontalAlignment(SwingConstants.CENTER);
		jldate.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldate);

		dateChooser = new JDateChooser();
		dateChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		dateChooser.setDateFormatString("yyyy/dd/MM");
		dateChooser.setBounds(241, 149, 167, 20);
		getContentPane().add(dateChooser);

		jtdate = new JTextField(String.valueOf(dateChooser.getDate()));

		jlphone = new JLabel("Phone: ");
		jlphone.setBackground(new Color(0, 176, 220));
		jlphone.setBounds(137, 179, 94, 13);
		jlphone.setHorizontalAlignment(SwingConstants.CENTER);
		jlphone.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlphone);

		jtphone = new JTextField();
		jtphone.setBounds(241, 176, 167, 19);
		jtphone.setBackground(Color.WHITE);
		jtphone.setColumns(13);
		jtphone.setToolTipText("Introduce your phone");
		getContentPane().add(jtphone);

		jlImage = new JLabel("IMAGE");
		jlImage.setBounds(21, 36, 116, 139);
		jlImage.setBorder(BorderFactory.createLineBorder(Color.black));
		jlImage.setVerticalAlignment(SwingConstants.CENTER);
		jlImage.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jlImage);

		jbphoto = new JButton("Select Image:");
		jbphoto.setToolTipText("Select a image");
		jbphoto.setBackground(new Color(238, 238, 238));
		jbphoto.setBorderPainted(true);
		jbphoto.setBounds(21, 193, 116, 29);
		getContentPane().add(jbphoto);

		jtphoto = new JTextField();

		// Button select image event handler
		InsertImg insertImg = new InsertImg();
		jbphoto.addActionListener(insertImg);

		jlpassword = new JLabel("Password: ");
		jlpassword.setBackground(new Color(0, 176, 220));
		jlpassword.setBounds(137, 209, 94, 13);
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(241, 206, 167, 19);
		jppassword.setBackground(Color.WHITE);
		jppassword.setColumns(10);
		jppassword.setToolTipText("Introduce your password");
		getContentPane().add(jppassword);

		jlpassword2 = new JLabel("Repeat Pass.: ");
		jlpassword2.setBackground(new Color(0, 176, 220));
		jlpassword2.setBounds(137, 239, 94, 13);
		jlpassword2.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword2.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlpassword2);

		jppassword2 = new JPasswordField();
		jppassword2.setBounds(241, 236, 167, 19);
		jppassword2.setBackground(Color.WHITE);
		jppassword2.setColumns(10);
		jppassword2.setToolTipText("Confirm your password");
		getContentPane().add(jppassword2);

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

				JTextField[] group = { jtdni, jtname, jtlastname, jtdate, jtphone, jtphoto, jppassword, jppassword2 };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				if (verification) {
					if (jtdni.getText().matches(sdni)) {
						if (jtphone.getText().matches(sphone)) {
							if (jppassword.getText().matches(spassw)) {
								if (jppassword2.getText().equals(jppassword.getText())) {

									try {
										SimpleDateFormat sdf = new SimpleDateFormat(dateChooser.getDateFormatString());
										date_birth = dateChooser.getDateFormatString();
										date_birth = sdf.format(dateChooser.getDate());

										Functions f = new Functions();
										f.WriteUser(jtdni.getText(), jppassword.getText(), jtrole.getText());
										f.WriteStudent(jtdni.getText(), jtname.getText(), jtlastname.getText(),
												date_birth, jtphone.getText(), jtphoto.getText());
										dispose();
										f.close();
										Login log = new Login();

									} catch (SQLException e1) {
										Icon icon = new ImageIcon("images/warning.png");
										JOptionPane.showMessageDialog(null, "Duplicated ID", "Error",
												JOptionPane.WARNING_MESSAGE, icon);
									}

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
							JOptionPane.showMessageDialog(null, "Phone does not meet the required parameters", "Error",
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
		jbcancel.setBounds(48, 302, 112, 37);
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

	// Insert Image Method
	public class InsertImg implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			File photo = new File("images/alumn/" + jtdni.getText());

			if (!jtdni.getText().isBlank()) {

				if (!photo.exists()) {

					AbstractButton btn = (AbstractButton) e.getSource();
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int sel = fileChooser.showSaveDialog(null);
					FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
					fileChooser.setFileFilter(soloImg);
					// Obtiene el archivo seleccionado y establece las rutas de origen y destino
					String ficheroNombre = jtdni.getText();
					File imagenes = new File("images/alumn/" + ficheroNombre);
					Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();
					Path destination = imagenes.toPath();
					if (fileChooser.APPROVE_OPTION == sel) {
						Image imagen = new ImageIcon(fileChooser.getSelectedFile().toString()).getImage();
						ImageIcon img2 = new ImageIcon(imagen.getScaledInstance(167, 232, Image.SCALE_SMOOTH));
						jlImage.setIcon(img2);
						jtphoto.setText("images/alumn/" + ficheroNombre);
						try {
							Files.copy(sourcer, destination);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "The photo exist", "Error", JOptionPane.WARNING_MESSAGE, icon);
				}
			}else {
				icon = new ImageIcon("images/warning.png");
				JOptionPane.showMessageDialog(null, "The dni can´t be empty", "Error", JOptionPane.WARNING_MESSAGE, icon);
			}
		}
	}

	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(new Color(0, 176, 220));
		jf.getContentPane().setBackground(new Color(0, 176, 220));
		jf.setSize(475, 400);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(null);
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}
}
