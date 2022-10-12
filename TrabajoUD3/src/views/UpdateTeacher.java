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

public class UpdateTeacher extends JFrame {

	private JLabel  jldni,jlname, jllastname,jlemail,jlpassword,jlpassword2;
	private JTextField jtdni, jtname, jtlastname, jtemail, jtrole = new JTextField("Student");;
	private JPasswordField jppassword, jppassword2;
	private JButton jbconfirm, jbcancel;
	private Icon icon;
	static Image imagen;
	ImageIcon img2;
	private String sdni = "[0-9]{8}[A-Z]";
	private String semail = "^[A-Za-z0-9]+@[A-Za-z0-9]+.([A-Za-z0-9]+)$";
	private String sphone= "[0-9]{9}";
	private String spassw = "[A-Za-z\\d$@$#_!%*?&]{6,15}$";

	public UpdateTeacher(String s) {
		// creamos el frame insertar
		super("Update Teacher");
		inicializate(UpdateTeacher.this);
		
		jldni = new JLabel("D.N.I. : ");
		jldni.setBackground(new Color(0, 176, 220));
		jldni.setBounds(147, 122, 84, 13);
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni);
		
		jtdni = new JTextField();
		jtdni.setBounds(241, 119, 167, 19);
		jtdni.setBackground(new Color(0, 176, 220));
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
		jtname.setBackground(new Color(0, 176, 220));
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
		jtlastname.setBackground(new Color(0, 176, 220));
		jtlastname.setColumns(10);
		jtlastname.setToolTipText("Introduce your last name");
		getContentPane().add(jtlastname);

		jlemail = new JLabel("Email:");
		jlemail.setBackground(new Color(0, 176, 220));
		jlemail.setBounds(137, 92, 94, 13);
		jlemail.setHorizontalAlignment(SwingConstants.CENTER);
		jlemail.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlemail);

		jtemail = new JTextField();
		jtemail.setBounds(242, 89, 167, 19);
		jtemail.setBackground(new Color(0, 176, 220));
		jtemail.setColumns(10);
		jtemail.setToolTipText("Introduce your email");
		getContentPane().add(jtemail);

		jlpassword = new JLabel("Password: ");
		jlpassword.setBackground(new Color(0, 176, 220));
		jlpassword.setBounds(137, 209, 94, 13);
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(241, 206, 167, 19);
		jppassword.setBackground(new Color(0, 176, 220));
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
		jppassword2.setBackground(new Color(0, 176, 220));
		jppassword2.setColumns(10);
		jppassword2.setToolTipText("Confirm your password");
		getContentPane().add(jppassword2);
		
		// Boton next
		jbconfirm = new JButton("");
		jbconfirm.setIcon(new ImageIcon("images/BlackTick.png"));
		jbconfirm.setToolTipText("Confirm");
		jbconfirm.setBackground(new Color(0, 153, 0));
		jbconfirm.setBounds(276, 302, 115, 37);
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
				MainWindowAdmin mainteach = new MainWindowAdmin(s);

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
		jf.getContentPane().setLayout(new GridLayout(7, 2));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}
}
