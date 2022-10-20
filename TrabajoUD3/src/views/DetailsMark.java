package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import app.Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.FlowLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class DetailsMark.
 */
@SuppressWarnings("serial")
public class DetailsMark extends JFrame {

	/** The table. */
	private JTable table;

	/** The panel 1. */
	private JPanel panel, panel_1;

	/** The jbclose. */
	private JButton jbclose;

	/** The jluser. */
	private JLabel jluser;

	/** The f. */
	private File f = new File("files/Cryptos");

	/** The name colums. */
	String[] nameColums = { "RA", "Mark" };

	/** The icon. */
	private Icon icon;

	/** The s. */
	Student s = new Student();

	/** The id subj. */
	int id_subj;

	/** The dni student. */
	String dni_student;

	/**
	 * Instantiates a new details mark.
	 *
	 * @param dni the dni
	 * @param id  the id
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DetailsMark(String dni, int id) {
		super("Mark details");
		inicializate(DetailsMark.this);
		id_subj = id;
		dni_student = dni;
		Functions f = new Functions();
		s = f.ReadStudent(dni);

		jluser = new JLabel("Username: " + s.getDni());
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

		jbclose = new JButton("");
		jbclose.setBackground(new Color(8, 116, 247));
		jbclose.setToolTipText("Log Out");
		jbclose.setBorderPainted(false);
		jbclose.setIcon(new ImageIcon("images/Back.png"));
		jbclose.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowStudent main = new MainWindowStudent(dni);

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
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(nameColums);
		table.setModel(dtm);

		try {
			Functions f = new Functions();

			for (Object[] q : f.viewStudentsRA(dni_student, id_subj)) {

				Object[] row = new Object[2];
				row[0] = q[0];
				row[1] = q[2];
				dtm.addRow(row);

			}

			f.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}