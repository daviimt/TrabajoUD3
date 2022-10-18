package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;

import app.Qualifies;
import app.RA;
import app.SchoolEnrollment;
import app.Student;
import app.Subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class MainWindowTeacher extends JFrame {

	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbupdate, jbclose;
	private JLabel jluser;
	String[] nameColums = { "Subject", "Student", "RA", "Mark" };
	private Icon icon;
	String idTeacher;
	DefaultTableModel dtm;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowTeacher(String id) {
		super("Teacher menu");
		inicializate(MainWindowTeacher.this);
		idTeacher = id;
		jluser = new JLabel("Username: " + id);
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		jluser.setFont(new Font("Poor Richard", Font.BOLD, 18));

		JPanel jpupper = new JPanel();
		jpupper.setBackground(new Color(8, 116, 247));

		jpupper.add(jluser);
		add(jpupper, BorderLayout.NORTH);

		// JTable Prueba (con defaulttablemade)

		table = new JTable();
		table.setBackground(new Color(0, 176, 220));
		table.setOpaque(true);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(32, 32, 32));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(0, 176, 220));
		scrollPane.getViewport().setBackground(new Color(0, 176, 220));
		add(scrollPane, BorderLayout.CENTER);

		createJTable();
		// Termina el JTable

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(8, 116, 247));
		panel_1.setOpaque(true);
		add(panel_1, BorderLayout.SOUTH);

		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel = new JPanel();
		panel.setBackground(new Color(8, 116, 247));
		panel_1.add(panel);

		jbupdate = new JButton("");
		jbupdate.setBackground(new Color(8, 116, 247));
		jbupdate.setToolTipText("Insert a mark");
		jbupdate.setBorderPainted(false);
		jbupdate.setIcon(new ImageIcon("images/update.png"));
		jbupdate.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("images/warning.png");
				String mark = JOptionPane.showInputDialog(MainWindowTeacher.this, "Enter the mark fot this student",
						"Mark", JOptionPane.WARNING_MESSAGE);
				float markf=Float.parseFloat(mark);
				
				try {
					Functions f=new Functions();
					f.writeMark(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 1)),Integer.parseInt(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 2))), markf);
					f.close();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
					e1.printStackTrace();
				}
			}
		});

		panel.add(jbupdate);

		jbclose = new JButton("");
		jbclose.setBackground(new Color(8, 116, 247));
		jbclose.setToolTipText("Log Out");
		jbclose.setBorderPainted(false);
		jbclose.setIcon(new ImageIcon("images/logout.png"));
		jbclose.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();

			}
		});
		panel.add(jbclose);

		setVisible(true);
	}

	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(new Color(0, 176, 220));
		jf.setBounds(100, 100, 600, 400);
		jf.setMinimumSize(getSize());
		jf.setLocationRelativeTo(null);
		jf.setLayout(new BorderLayout());
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}

	public void createJTable() {
		dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(nameColums);
		table.setModel(dtm);

		try {
			Functions f = new Functions();
			// falta crear las funciones pasandole los datos que salen un metodo get subjetque te devuelva los subject que tiene el profesor y otra matricula que te devuelva las matriculas con el dni de los almunos que estan matriculados en esa subject
			for (Subject s:f.getSubjectsTeacher(idTeacher)) {
				for(RA ra:f.getRAs(s.getId())) {
					for(SchoolEnrollment se : f.getSchoolEnrollmentTeacher(s.getId())) {
						for(Qualifies q:f.getQualifies(se.getDni_student(),ra.getId())) {
							
							Object[] row = new Object[4];
							row[0] = s.getName();
							row[1] = se.getDni_student();
							row[2] = q.getId_RA();
							row[3] = q.getMark();
							dtm.addRow(row);
							
						}
					}
				}
				
				
			}

			f.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}