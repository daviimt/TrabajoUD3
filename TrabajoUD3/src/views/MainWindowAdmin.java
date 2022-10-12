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

import app.Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class MainWindowAdmin extends JFrame {

	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbupdate, jbinsert, jbdelete, jbdetails, jbclose;
	private JLabel jluser;
	String[] nameColums = { "ID", "Name", "LastName", "Email" };
	private Icon icon;
	Student s = new Student();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowAdmin(String s) {
		super("Admin menu");
		inicializate(MainWindowAdmin.this);

		jluser = new JLabel("Username: " + s);
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

		jbinsert = new JButton("");
		jbinsert.setBackground(new Color(8, 116, 247));
		jbinsert.setToolTipText("Insert teacher");
		jbinsert.setBorderPainted(false);
		jbinsert.setIcon(new ImageIcon("images/insert.png"));
		jbinsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertTeacher insert = new InsertTeacher(s);

			}
		});

		panel.add(jbinsert);

		jbupdate = new JButton("");
		jbupdate.setBackground(new Color(8, 116, 247));
		jbupdate.setToolTipText("Update teacher");
		jbupdate.setBorderPainted(false);
		jbupdate.setIcon(new ImageIcon("images/update.png"));
		jbupdate.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateTeacher update = new UpdateTeacher(s);

			}
		});

		panel.add(jbupdate);

		jbdelete = new JButton("");
		jbdelete.setBackground(new Color(8, 116, 247));
		jbdelete.setToolTipText("Delete teacher");
		jbdelete.setBorderPainted(false);
		jbdelete.setIcon(new ImageIcon("images/delete.png"));
		jbdelete.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showOptionDialog(MainWindowAdmin.this, "Are you sure?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

			}
		});

		panel.add(jbdelete);

		jbdetails = new JButton("");
		jbdetails.setBackground(new Color(8, 116, 247));
		jbdetails.setToolTipText("Details");
		jbdetails.setBorderPainted(false);
		jbdetails.setIcon(new ImageIcon("images/details.png"));
		/*jbdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DetailsTeacher details = new DetailsTeacher();

			}
		});*/

		panel.add(jbdetails);

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
		DefaultTableModel dtmCrypto = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmCrypto.setColumnIdentifiers(nameColums);
		table.setModel(dtmCrypto);

	}

}