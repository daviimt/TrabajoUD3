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

import app.Subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.FlowLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class MainWindowTeacher.
 */
@SuppressWarnings("serial")
public class MainWindowTeacher extends JFrame {

	/** The table. */
	private JTable table;
	
	/** The panel 1. */
	private JPanel panel, panel_1;
	
	/** The jbclose. */
	private JButton jbupdate, jbclose;
	
	/** The jluser. */
	private JLabel jluser;
	
	/** The name colums. */
	String[] nameColums = { "Subject", "Student", "RA", "Mark" };
	
	/** The icon. */
	private Icon icon;
	
	/** The id teacher. */
	String idTeacher;
	
	/** The dtm. */
	DefaultTableModel dtm;

	/**
	 * Instantiates a new main window teacher.
	 *
	 * @param id the id
	 */
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
				String mark = JOptionPane.showInputDialog(MainWindowTeacher.this, "Enter the mark for this student",
						"Mark", JOptionPane.WARNING_MESSAGE);
				float markf = Float.parseFloat(mark);
				
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {

					try {
						Functions f = new Functions();
						f.updateMark(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 1)),
								Integer.parseInt(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 2))), markf);
						f.close();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					MainWindowTeacher main = new MainWindowTeacher(id);
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

	/**
	 * Inicializate.
	 *
	 * @param jf the jf
	 */
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

	/**
	 * Creates the J table.
	 */
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

			for (Subject s : f.getSubjectsTeacher(idTeacher)) {
				for (Object[] q : f.viewTeacherFinalGrade(s.getId())) {
					Object[] row = new Object[4];
					row[0] = q[0];
					row[1] = q[1];
					row[2] = q[2];
					row[3] = q[3];
					dtm.addRow(row);
				}
			}

			f.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}