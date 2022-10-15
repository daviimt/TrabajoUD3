package views;

import java.awt.Color;
import java.awt.Font;
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

import com.toedter.calendar.JDateChooser;

import app.Subject;
import app.Teacher;
import app.User;

public class UpdateSubject extends JFrame {

	private JLabel jlname, jlhours, jldni_teacher;
	private JTextField jtid, jtname, jthours, jtdni_teacher;
	private JButton jbconfirm, jbcancel;
	private Icon icon;
	static Image imagen;
	ImageIcon img2;
	private String sid = "[0-9]+";
	private String sdni_teacher = "[0-9]{8}[A-Z]";
	private String shours = "[0-9]+";

	public UpdateSubject(int idSubject) {
		super("Update Subject");
		inicializate(UpdateSubject.this);
		Subject subject = new Subject();

		try {
			Functions f = new Functions();
			subject = f.ReadSubject(idSubject);
			f.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		jtid = new JTextField(String.valueOf(subject.getId()));

		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(147, 62, 72, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);

		jtname = new JTextField(subject.getName());
		jtname.setBounds(242, 59, 167, 19);
		jtname.setBackground(new Color(0, 176, 220));
		jtname.setColumns(10);
		jtname.setToolTipText("Modify the name");
		getContentPane().add(jtname);

		jlhours = new JLabel("Hours:");
		jlhours.setBackground(new Color(0, 176, 220));
		jlhours.setBounds(137, 92, 94, 13);
		jlhours.setHorizontalAlignment(SwingConstants.CENTER);
		jlhours.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlhours);

		jthours = new JTextField(String.valueOf(subject.getHours()));
		jthours.setBounds(242, 89, 167, 19);
		jthours.setBackground(new Color(0, 176, 220));
		jthours.setColumns(10);
		jthours.setToolTipText("Modify the hours");
		getContentPane().add(jthours);

		jldni_teacher = new JLabel("Teacher's DNI: ");
		jldni_teacher.setBackground(new Color(0, 176, 220));
		jldni_teacher.setBounds(147, 62, 72, 13);
		jldni_teacher.setHorizontalAlignment(SwingConstants.CENTER);
		jldni_teacher.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni_teacher);

		jtdni_teacher = new JTextField(subject.getDni_teacher());
		jtdni_teacher.setBounds(242, 59, 167, 19);
		jtdni_teacher.setBackground(new Color(0, 176, 220));
		jtdni_teacher.setColumns(10);
		jtdni_teacher.setToolTipText("Modify the teacher's DNI");
		getContentPane().add(jtdni_teacher);

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

				JTextField[] group = { jtid, jtname, jthours, jtdni_teacher };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				Functions f = new Functions();
				if (verification) {
					if (jtid.getText().matches(sid)) {
						if (jthours.getText().matches(shours)) {
							if (jtdni_teacher.getText().matches(sdni_teacher)) {
								try {
									if (f.ReadTeacher(jtdni_teacher.getText()).getDni() != null) {
										//if (f.ReadSubject(Integer.parseInt(jtid.getText())).getName().equals(jtname.getText())) {
											
											f.DeleteSubject(idSubject);
											f.WriteSubject(Integer.parseInt(jtid.getText()), jtname.getText(),
													Integer.parseInt(jthours.getText()), jtdni_teacher.getText());
											f.close();

											dispose();
											MainWindowSubject mainSubject = new MainWindowSubject("admin");
										/*} else {
											icon = new ImageIcon("images/warning.png");
											JOptionPane.showMessageDialog(null, "Subject's name exist", "Error",
													JOptionPane.INFORMATION_MESSAGE, icon);
										}*/
									} else {
										icon = new ImageIcon("images/warning.png");
										JOptionPane.showMessageDialog(null, "Teacher's DNI does not exist", "Error",
												JOptionPane.INFORMATION_MESSAGE, icon);
									}

								} catch (SQLException e1) {
									Icon icon = new ImageIcon("images/warning.png");
									JOptionPane.showMessageDialog(null, "Duplicated ID", "Error",
											JOptionPane.WARNING_MESSAGE, icon);
								}
							} else {
								icon = new ImageIcon("images/warning.png");
								JOptionPane.showMessageDialog(null,
										"Teacher's DNI does not meet the required parameters", "Error",
										JOptionPane.INFORMATION_MESSAGE, icon);
							}
						} else {
							icon = new ImageIcon("images/warning.png");
							JOptionPane.showMessageDialog(null, "Hours does not meet the required parameters", "Error",
									JOptionPane.INFORMATION_MESSAGE, icon);
						}
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(null, "ID does not meet the required parameters", "Error",
								JOptionPane.INFORMATION_MESSAGE, icon);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to create the subject.", "Error",
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
				MainWindowAdmin mainteach = new MainWindowAdmin("admin");

			}
		});
		getContentPane().add(jbcancel);
		setVisible(true);
	}

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
