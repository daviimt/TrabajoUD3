package views;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import app.Student;
import app.User;

public class UpdateStudent extends JFrame {

	private JLabel  jldni,jlname, jllastname, jldate, jlphone, jlImage, jlpassword;
	private JTextField jtdni, jtname, jtlastname,jtdate, jtphone, jtphoto, jtrole = new JTextField("Student");
	private JPasswordField jppassword;
	private JButton jbconfirm, jbcancel,jbphoto;
	private Icon icon;
	private Image imagen;
	ImageIcon img2;
	private String sdni = "[0-9]{8}[A-Z]";
	private String sphone= "[0-9]{9}";
	private JDateChooser dateChooser;
	private String date_birth;
	private User u ;
	private Student student;
	String dateB;

	public UpdateStudent(Student s) {

		super("Update your data");
		getContentPane().setBackground(new Color(102, 204, 153));
		inicializate(UpdateStudent.this);
		student = s;
		try {
			Functions f = new Functions();
			u = f.Read(s.getDni());
			f.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		jldni = new JLabel("D.N.I. : ");
		jldni.setBackground(new Color(0, 176, 220));
		jldni.setBounds(147, 122, 84, 13);
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldni);
		
		jtdni = new JTextField(s.getDni());
		jtdni.setBounds(241, 119, 167, 19);
		jtdni.setBackground(Color.WHITE);
		jtdni.setColumns(12);
		jtdni.setToolTipText("Modify your DNI");
		getContentPane().add(jtdni);

		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(147, 62, 72, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);
		
		jtname = new JTextField(s.getName());
		jtname.setBounds(242, 59, 167, 19);
		jtname.setBackground(Color.WHITE);
		jtname.setColumns(10);
		jtname.setToolTipText("Modify your name");
		getContentPane().add(jtname);
		
		jllastname = new JLabel("Last name:");
		jllastname.setBackground(new Color(0, 176, 220));
		jllastname.setBounds(137, 92, 94, 13);
		jllastname.setHorizontalAlignment(SwingConstants.CENTER);
		jllastname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jllastname);

		jtlastname = new JTextField(s.getLastname());
		jtlastname.setBounds(242, 89, 167, 19);
		jtlastname.setBackground(Color.WHITE);
		jtlastname.setColumns(10);
		jtlastname.setToolTipText("Modify your last name");
		getContentPane().add(jtlastname);

		jldate = new JLabel("Date: ");
		jldate.setBackground(new Color(0, 176, 220));
		jldate.setBounds(137, 145, 94, 20);
		jldate.setHorizontalAlignment(SwingConstants.CENTER);
		jldate.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldate);
		

		dateChooser = new JDateChooser();
		dateChooser.setLocation(241, 146);
		dateChooser.setSize(167, 19);
		dateChooser.setBackground(Color.CYAN);
		dateChooser.setDateFormatString("yyyy/dd/MM");
		dateChooser.getCalendarButton().setBackground(new Color(0, 176, 220));
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setText(s.getBirth_date());
		editor.setToolTipText("Modify your birth date");
		editor.setEditable(false);
		getContentPane().add(dateChooser);
		
		
		jtdate = new JTextField(String.valueOf(dateChooser.getDate()));

		jlphone = new JLabel("Phone: ");
		jlphone.setBackground(new Color(0, 176, 220));
		jlphone.setBounds(137, 179, 94, 13);
		jlphone.setHorizontalAlignment(SwingConstants.CENTER);
		jlphone.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlphone);

		jtphone = new JTextField(s.getPhone());
		jtphone.setBounds(241, 176, 167, 19);
		jtphone.setBackground(Color.WHITE);
		jtphone.setColumns(13);
		jtphone.setToolTipText("Modify your phone");
		getContentPane().add(jtphone);
		
		imagen = new ImageIcon(s.getPhoto()).getImage();
		ImageIcon img2 = new ImageIcon(imagen.getScaledInstance(167, 232, Image.SCALE_SMOOTH));
		jlImage = new JLabel();
		jlImage.setIcon(img2);
		jlImage.setBounds(21, 36, 116, 139);
		getContentPane().add(jlImage);
		
		jtphoto = new JTextField(s.getPhoto());

		jbphoto = new JButton("Select Image:");
		jbphoto.setToolTipText("Select a image");
		jbphoto.setBackground(new Color(238, 238, 238));
		jbphoto.setBorderPainted(true);
		jbphoto.setBounds(21, 193, 116, 29);
		getContentPane().add(jbphoto);

		// Button select image event handler
		ActImage insertImg = new ActImage();
		jbphoto.addActionListener(insertImg);
		
		jlpassword = new JLabel("Password: ");
		jlpassword.setBackground(new Color(0, 176, 220));
		jlpassword.setBounds(137, 209, 94, 13);
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		//getContentPane().add(jlpassword);

		jppassword = new JPasswordField(u.getPassword());
		jppassword.setBounds(241, 206, 167, 19);
		jppassword.setBackground(Color.WHITE);
		jppassword.setColumns(10);
		jppassword.setToolTipText("Modify your password");
		//getContentPane().add(jppassword);
		
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

				JTextField[] group = {jtdni, jtname, jtlastname, jtdate, jtphone, jtphoto };

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
								
								SimpleDateFormat sdf = new SimpleDateFormat(dateChooser.getDateFormatString());
								dateB = dateChooser.getDateFormatString();
								dateB = sdf.format(dateChooser.getDate());
								
								Functions f=new Functions();
								f.DeleteUser(u.getDni());
								f.WriteUser(jtdni.getText(), jppassword.getText(),jtrole.getText());
								f.WriteStudent(jtdni.getText(),jtname.getText(), jtlastname.getText(), dateB,jtphone.getText(),jtphoto.getText());
								f.close();
								dispose();
								MainWindowStudent main = new MainWindowStudent(jtdni.getText());
							 }catch(SQLException e1){
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
		jbcancel.setBounds(48, 302, 112, 37);
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowStudent main = new MainWindowStudent(jtdni.getText());

			}
		});
		getContentPane().add(jbcancel);

		setVisible(true);
	}
	
	// MÉTODO INSERTAR IMÁGENES
	public class ActImage implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton btn = (AbstractButton) e.getSource();
			//Componente JFileChooser (Explorador archivos)
			JFileChooser fileChooser = new JFileChooser();
			int sel = fileChooser.showSaveDialog(null);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			fileChooser.setFileFilter(soloImg);
			//Obtiene el archivo seleccionado y establece las rutas de origen y destino
			String ficheroNombre = jtdni.getText()+".png";
			File imagenes = new File("images/alumn/" + ficheroNombre);
			Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();
			Path destination = imagenes.toPath();
			//Si selecciona un archivo borra la imagen anterior y establece la nueva
			
			if (fileChooser.APPROVE_OPTION == sel) {
				File imgOld = new File(student.getPhoto());
				imgOld.delete();
				
				File imgNew = new File(fileChooser.getSelectedFile().toString());
				
				imagen = new ImageIcon(imgNew.toString()).getImage();
				ImageIcon img2 = new ImageIcon(imagen.getScaledInstance(167, 232, Image.SCALE_SMOOTH));
				jlImage.setIcon(img2);
				jtphoto.setText(imagenes.toString());
				try {
					Files.copy(sourcer, destination);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(fileChooser.CANCEL_OPTION == sel){}
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
