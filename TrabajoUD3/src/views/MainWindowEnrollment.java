package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import app.SchoolEnrollment;
import app.Subject;

@SuppressWarnings("serial")
public class MainWindowEnrollment extends JFrame {

	private JTable table, tableSelected;
	private JPanel panel_1;
	private JButton jbSelect, jbDeselect, jbconfirm, jbclose;
	private JLabel jluser, jltable, jltableSelected;
	String[] nameColums = { "Name" };
	String[] nameColumsSelected = { "Name" };
	private Icon icon;
	DefaultTableModel dtm;
	DefaultTableModel dtmSelected;
	String dniAlum;
	List<String> listSubject = new ArrayList();
	List<String> listSubSelect = new ArrayList();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowEnrollment(String dni_Alum) {
		super("School Enrollment");
		getContentPane().setBackground(new Color(0, 176, 220));
		inicializate(MainWindowEnrollment.this);
		try {
			//CAMBIAR READSUBJECTS X READSUBEJECTS QUE NO ESTE MATRICULADO
			Functions f = new Functions();
			for (Subject s : f.ReadSubjects()) {
				listSubject.add(s.getName());
			}
			f.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Functions f = new Functions();
			for (SchoolEnrollment s : f.getSchoolEnrollment(dni_Alum)) {
				listSubSelect.add(f.ReadSubject(s.getId_subject()).getName());
			}
			f.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dniAlum = dni_Alum;

		jluser = new JLabel("Username: Admin");
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		jluser.setFont(new Font("Poor Richard", Font.BOLD, 18));

		jltable = new JLabel("Subjects");
		jltable.setHorizontalAlignment(SwingConstants.CENTER);
		jltable.setLocation(21, 52);
		jltable.setSize(255, 50);
		getContentPane().add(jltable);

		table = new JTable();
		table.setOpaque(true);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(32, 32, 32));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(207, 188);
		scrollPane.setLocation(48, 99);
		getContentPane().add(scrollPane, BorderLayout.EAST);

		createJTable();

		jltableSelected = new JLabel("Selected Subjects");
		jltableSelected.setHorizontalAlignment(SwingConstants.CENTER);
		jltableSelected.setLocation(319, 52);
		jltableSelected.setSize(255, 50);
		getContentPane().add(jltableSelected);

		tableSelected = new JTable();
		tableSelected.setOpaque(true);
		tableSelected.getTableHeader().setForeground(Color.WHITE);
		tableSelected.getTableHeader().setBackground(new Color(32, 32, 32));
		tableSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane2 = new JScrollPane(tableSelected);
		scrollPane2.setSize(224, 188);
		scrollPane2.setLocation(329, 99);
		getContentPane().add(scrollPane2, BorderLayout.WEST);

		createJTableSelected();
		// Termina el JTable
		JPanel jpupper = new JPanel();
		jpupper.setLocation(0, 0);
		jpupper.setSize(584, 50);
		jpupper.setBackground(new Color(8, 116, 247));

		jpupper.add(jluser);
		getContentPane().add(jpupper, BorderLayout.NORTH);

		panel_1 = new JPanel();
		panel_1.setSize(612, 74);
		panel_1.setLocation(0, 317);
		panel_1.setBackground(new Color(8, 116, 247));
		panel_1.setOpaque(true);
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jbSelect = new JButton("");
		jbSelect.setBackground(new Color(8, 116, 247));
		jbSelect.setToolTipText("Select subject");
		jbSelect.setBorderPainted(false);
		jbSelect.setIcon(new ImageIcon("images/insert.png"));
		jbSelect.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {
					listSubject.remove((String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0))));
					listSubSelect.add((String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0))));
				}
				createJTable();
				createJTableSelected();
			}
		});

		panel_1.add(jbSelect);

		jbDeselect = new JButton("");
		jbDeselect.setBackground(new Color(8, 116, 247));
		jbDeselect.setToolTipText("Deselect subject");
		jbDeselect.setBorderPainted(false);
		jbDeselect.setIcon(new ImageIcon("images/delete.png"));
		jbDeselect.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tableSelected.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {
					listSubSelect.remove((String.valueOf(dtmSelected.getValueAt(tableSelected.getSelectedRow(), 0))));
					listSubject.add((String.valueOf(dtmSelected.getValueAt(tableSelected.getSelectedRow(), 0))));
				}
				createJTable();
				createJTableSelected();
			}
		});

		panel_1.add(jbDeselect);

		jbconfirm = new JButton("");
		jbconfirm.setIcon(new ImageIcon("images/BlackTick.png"));
		jbconfirm.setToolTipText("Confirm");
		jbconfirm.setBackground(new Color(0, 153, 0));
		jbconfirm.setBounds(276, 302, 115, 37);
		jbconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Cargar la asignatura seleccionada en la tabla Matricula

			}
		});
		panel_1.add(jbconfirm);

		jbclose = new JButton("");
		jbclose.setVerticalAlignment(SwingConstants.BOTTOM);
		jbclose.setBackground(new Color(8, 116, 247));
		jbclose.setToolTipText("Back");
		jbclose.setBorderPainted(false);
		jbclose.setIcon(new ImageIcon("images/Back.png"));
		jbclose.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowAdmin main = new MainWindowAdmin();

			}
		});
		panel_1.add(jbclose);
		setVisible(true);
	}

	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(new Color(8, 116, 247));
		jf.setBounds(100, 100, 600, 400);
		jf.setMinimumSize(getSize());
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(null);
		jf.setResizable(false);
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

		for (String s : listSubject) {
			Object[] row = new Object[1];
			row[0] = s;
			dtm.addRow(row);
		}

//			listSubject = f.ReadSubjects();
//			for(Subject s : listSubject) {
//				Object[] row = new Object[1];
//				row[0] = s.getName();
//				dtm.addRow(row);
//			}
//			for (Subject s : f.ReadSubjects()) {
//				for (SchoolEnrollment se : f.getSchoolEnrollment(dniAlum)) {
//					for (Subject s2 : f.getSubjects(se.getId_subject())) {
//						if (s.getId() != s2.getId()) {
//							Object[] row = new Object[1];
//							row[0] = s.getName();
//							dtm.addRow(row);
//						}
//					}
//				}
//			}

	}

	public void createJTableSelected() {
		dtmSelected = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmSelected.setColumnIdentifiers(nameColumsSelected);
		tableSelected.setModel(dtmSelected);
		try {
			Functions f = new Functions();
			for (String s : listSubSelect) {
				Object[] row = new Object[1];
				row[0] = s;
				dtmSelected.addRow(row);
			}
//			for (SchoolEnrollment se : f.getSchoolEnrollment(dniAlum)) {
//				for (Subject s : f.getSubjects(se.getId_subject())) {
//					Object[] row = new Object[1];
//					row[0] = s.getName();
//					dtmSelected.addRow(row);
//				}
//			}
			f.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}