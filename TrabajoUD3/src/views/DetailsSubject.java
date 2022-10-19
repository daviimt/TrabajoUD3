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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Subject;

public class DetailsSubject extends JFrame{
	private JLabel jlname, jlhours, jldni_teacher;
	private JTextField jtid, jtname, jthours, jtdni_teacher;
	private JButton jbBack;


	public DetailsSubject(int idSubject) {
		super("Details Subject");
		inicializate(DetailsSubject.this);
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
		jtname.setToolTipText("Subjects name");
		jtname.setEditable(false);
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
		jthours.setToolTipText("Number of hours");
		jthours.setEditable(false);
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
		jtdni_teacher.setToolTipText("DNI of the teacher");
		jtdni_teacher.setEditable(false);
		getContentPane().add(jtdni_teacher);

		// Boton cancel

		jbBack = new JButton("");
		jbBack.setBounds(48, 302, 112, 37);
		jbBack.setBackground(new Color(153, 0, 0));
		jbBack.setToolTipText("Back");
		jbBack.setIcon(new ImageIcon("images/Cross.png"));
		jbBack.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowSubject main = new MainWindowSubject();

			}
		});
		getContentPane().add(jbBack);
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
