package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
import app.Teacher;
import app.User;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class MainWindowEnrollment extends JFrame {

	private JTable table, tableSelected;
	private JPanel panel_1;
	private JButton jbclose;
	private JLabel jluser, jltable, jltableSelected;
	String[] nameColums = { "ID", "Name" };
	String[] nameColumsSelected = { "ID", "Name" };
	private Icon icon;
	DefaultTableModel dtm;
	DefaultTableModel dtmSelected;
	String dniAlum;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowEnrollment(String dni_Alum) {
		super("Modify qualifies");
		getContentPane().setBackground(new Color(0, 176, 220));
		inicializate(MainWindowEnrollment.this);

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

		jltableSelected = new JLabel("Selected Subjects");
		jltableSelected.setHorizontalAlignment(SwingConstants.CENTER);
		jltableSelected.setLocation(319, 52);
		jltableSelected.setSize(255, 50);
		getContentPane().add(jltableSelected);

		JPanel jpupper = new JPanel();
		jpupper.setLocation(0, 0);
		jpupper.setSize(584, 50);
		jpupper.setBackground(new Color(8, 116, 247));

		jpupper.add(jluser);
		getContentPane().add(jpupper, BorderLayout.NORTH);

		// JTable Prueba (con defaulttablemade)

		table = new JTable();
		table.setOpaque(true);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(32, 32, 32));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				System.out.println(evt);
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(255, 208);
		scrollPane.setLocation(21, 99);
		getContentPane().add(scrollPane, BorderLayout.EAST);

		createJTable();

		tableSelected = new JTable();
		tableSelected.setOpaque(true);
		tableSelected.getTableHeader().setForeground(Color.WHITE);
		tableSelected.getTableHeader().setBackground(new Color(32, 32, 32));
		tableSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSelected.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					int i = tableSelected.rowAtPoint(evt.getPoint());
					Functions f = new Functions();
					f.DeleteSchoolEnrollment(
							Integer.parseInt(String.valueOf(dtmSelected.getValueAt(i, 0))), dniAlum);
					dispose();
					MainWindowEnrollment main=new MainWindowEnrollment(dniAlum);
					f.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JScrollPane scrollPane2 = new JScrollPane(tableSelected);
		scrollPane2.setSize(255, 208);
		scrollPane2.setLocation(319, 99);
		getContentPane().add(scrollPane2, BorderLayout.WEST);

		createJTableSelected();
		// Termina el JTable

		panel_1 = new JPanel();
		panel_1.setSize(584, 43);
		panel_1.setLocation(0, 318);
		panel_1.setBackground(new Color(8, 116, 247));
		panel_1.setOpaque(true);
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		jbclose = new JButton("");
		panel_1.add(jbclose);
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
			for (SchoolEnrollment se : f.getSchoolEnrollment(dniAlum)) {

				for (Subject s : f.getSubjects(se.getId_subject())) {

					Object[] row = new Object[4];
					row[0] = s.getId();
					row[1] = s.getName();
					dtmSelected.addRow(row);
				}
			}

			f.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

			for (Subject s : f.ReadSubjects()) {
				for (SchoolEnrollment se : f.getSchoolEnrollment(dniAlum)) {

					for (Subject s2 : f.getSubjects(se.getId_subject())) {

						if (s.getId() != s2.getId()) {

							Object[] row = new Object[4];
							row[0] = s.getId();
							row[1] = s.getName();
							dtm.addRow(row);
						}
					}
				}
			}

			f.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}