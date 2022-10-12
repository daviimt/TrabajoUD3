package views;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import javax.swing.AbstractButton;
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
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import app.Student;

@SuppressWarnings("serial")
public class UpdateStudent extends JFrame {

	private JLabel jldni, jlname, jllastname, jldate, jlphone, jlphoto, jlbphoto;
	private JTextField jtdni, jtname, jtlastname, jtdate, jtphone, jtphoto, jtrole = new JTextField("Student");
	private JButton jbconfirm, jbcancel, jbphoto;
	private Icon icon;
	static Image imagen;
	ImageIcon img2;
	private String sdni = "[0-9]{8}[A-Z]";
	private String sphone = "[0-9]{9}";
	private String spassw = "[A-Za-z\\d$@$#_!%*?&]{6,15}$";
	private File fusers = new File("files/Users");
	private JDateChooser dateChooser;

	public UpdateStudent(Student s) {

		super("Update your data");
		getContentPane().setBackground(new Color(102, 204, 153));
		inicializate(UpdateStudent.this);

		jldni = new JLabel("D.N.I. : ");
		jldni.setBackground(new Color(0, 176, 220));
		jldni.setBounds(24, 122, 94, 13);
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni);

		jtdni = new JTextField(s.getDni());
		jtdni.setBounds(119, 119, 114, 19);
		jtdni.setBackground(new Color(0, 176, 220));
		jtdni.setColumns(12);
		jtdni.setToolTipText("Update your DNI");
		getContentPane().add(jtdni);

		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(24, 53, 94, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);

		jtname = new JTextField(s.getName());
		jtname.setBounds(119, 50, 114, 19);
		jtname.setBackground(new Color(0, 176, 220));
		jtname.setColumns(10);
		jtname.setToolTipText("Update your name");
		getContentPane().add(jtname);

		jllastname = new JLabel("Last name:");
		jllastname.setBackground(new Color(0, 176, 220));
		jllastname.setBounds(24, 30, 94, 13);
		jllastname.setHorizontalAlignment(SwingConstants.CENTER);
		jllastname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jllastname);

		jtlastname = new JTextField(s.getLastname());
		jtlastname.setBounds(119, 27, 114, 19);
		jtlastname.setBackground(new Color(0, 176, 220));
		jtlastname.setColumns(10);
		jtlastname.setToolTipText("Update your last name");
		getContentPane().add(jtlastname);

		jldate = new JLabel("Date: ");
		jldate.setBackground(new Color(0, 176, 220));
		jldate.setBounds(24, 145, 94, 13);
		jldate.setHorizontalAlignment(SwingConstants.CENTER);
		jldate.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldate);

		dateChooser = new JDateChooser(s.getBirth_date());
		dateChooser.setBackground(Color.CYAN);
		dateChooser.getCalendarButton().setBackground(new Color(0, 176, 220));
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setToolTipText("Update your birth date");
		editor.setEditable(false);
		getContentPane().add(dateChooser);

		jtdate = new JTextField(String.valueOf(dateChooser.getDate()));

		jlphone = new JLabel("Phone: ");
		jlphone.setBackground(new Color(0, 176, 220));
		jlphone.setBounds(24, 145, 94, 13);
		jlphone.setHorizontalAlignment(SwingConstants.CENTER);
		jlphone.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlphone);

		jtphone = new JTextField(s.getPhone());
		jtphone.setBounds(119, 142, 114, 19);
		jtphone.setBackground(new Color(0, 176, 220));
		jtphone.setColumns(13);
		jtphone.setToolTipText("Update your phone");
		getContentPane().add(jtphone);

		jlphoto = new JLabel("Photo: ");
		jlphoto.setBackground(new Color(0, 176, 220));
		jlphoto.setBounds(24, 145, 94, 13);
		jlphoto.setHorizontalAlignment(SwingConstants.CENTER);
		jlphoto.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlphoto);

//		imagen = new ImageIcon("images/"+jtdni.getText()).getImage();
//		img2=new ImageIcon(imagen.getScaledInstance(167, 232, Image.SCALE_SMOOTH));
//		
//		jlbphoto.setIcon(img2);
//		jlbphoto.setBounds(207, 210, 133, 120);
//		getContentPane().add(jlbphoto);

		jtphoto = new JTextField(s.getPhoto());
		jtphoto.setBounds(119, 142, 114, 19);
		jtphoto.setBackground(new Color(0, 176, 220));
		jtphoto.setColumns(13);
		jtphoto.setToolTipText("Update your phone");
		getContentPane().add(jtphoto);

//		jbphoto = new JButton("Imagen");
//		jbphoto.setToolTipText("Buscar archivo");
//		jbphoto.setBackground(new Color(238,238,238));
//		jbphoto.setBorderPainted(true);
//		jbphoto.setBounds(116, 222, 51, 46);
//		getContentPane().add(jbphoto);
//		InsertImg insertImg = new InsertImg();
//		jbphoto.addActionListener(insertImg);

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

				JTextField[] group = { jtdni, jtname, jtlastname, jtdate, jtphone, jtphoto };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				if (verification) {
					if (jtdni.getText().matches(sdni)) {
						if (jtphone.getText().matches(sphone)) {
							try {

								Functions f = new Functions();
								f.WriteStudent(f.generateID(), jtdni.getText(), jtname.getText(), jtlastname.getText(),
										java.sql.Date.valueOf(jtdate.getText()), jtphone.getText(), jtphoto.getText());
								dispose();
								Login log = new Login();

							} catch (SQLException e1) {
								Icon icon = new ImageIcon("images/warning.png");
								JOptionPane.showMessageDialog(null, "Duplicated ID", "Error",
										JOptionPane.WARNING_MESSAGE, icon);

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

	public class InsertImg implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton bt = (AbstractButton) e.getSource();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			fileChooser.setFileFilter(soloImg);

			fileChooser.showSaveDialog(null);

			String ficheroNombre = fileChooser.getSelectedFile().getName();

			Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();

			jtphoto.setText("images/" + ficheroNombre);

			File imagenes = new File(jtphoto.getText());
			bt.setText("Insertar Imagen");
			Path destination = imagenes.toPath();
			try {
				Files.copy(sourcer, destination);
			} catch (IOException e1) {
				// e1.printStackTrace();
			}
		}
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
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}

}
