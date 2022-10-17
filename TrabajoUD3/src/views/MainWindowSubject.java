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

import app.Qualifies;
import app.RA;
import app.SchoolEnrollment;
import app.Subject;
import app.User;

public class MainWindowSubject extends JFrame {
	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbupdate, jbinsert, jbdelete, jbdetails, jbclose, jbra;
	private JLabel jluser;
	String[] nameColums = { "ID", "Name" };
	private Icon icon;
	DefaultTableModel dtm;
	User u = new User();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowSubject() {
		super("Admin menu");
		inicializate(MainWindowSubject.this);

		jluser = new JLabel("Username: Admin");
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
		jbinsert.setToolTipText("Insert subject");
		jbinsert.setBorderPainted(false);
		jbinsert.setIcon(new ImageIcon("images/insert.png"));
		jbinsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				InsertSubject insert = new InsertSubject();

			}
		});

		panel.add(jbinsert);

		jbupdate = new JButton("");
		jbupdate.setBackground(new Color(8, 116, 247));
		jbupdate.setToolTipText("Update subject");
		jbupdate.setBorderPainted(false);
		jbupdate.setIcon(new ImageIcon("images/update.png"));
		jbupdate.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {
					UpdateSubject update = new UpdateSubject(Integer.parseInt(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0))));

				}

			}
		});

		panel.add(jbupdate);

		jbdelete = new JButton("");
		jbdelete.setBackground(new Color(8, 116, 247));
		jbdelete.setToolTipText("Delete subject");
		jbdelete.setBorderPainted(false);
		jbdelete.setIcon(new ImageIcon("images/delete.png"));
		jbdelete.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {

					int option = JOptionPane.showOptionDialog(MainWindowSubject.this, "Are you sure?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (option == 0) {
						try {
							Functions f = new Functions();
							f.DeleteSubject(Integer.parseInt(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0))));
							f.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						MainWindowSubject mainAdmin = new MainWindowSubject();
					}
				}
			}
		});

		panel.add(jbdelete);

		jbdetails = new JButton("");
		jbdetails.setBackground(new Color(8, 116, 247));
		jbdetails.setToolTipText("Details");
		jbdetails.setBorderPainted(false);
		jbdetails.setIcon(new ImageIcon("images/details.png"));

		jbdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {
					if (String.valueOf(dtm.getValueAt(table.getSelectedRow(), 1)).equals("Student")) {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(null, "You can't see student data", "Error",
								JOptionPane.INFORMATION_MESSAGE, icon);
					} else {
						dispose();
						DetailsSubject details = new DetailsSubject(Integer.parseInt(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0))));
					}

				}

			}
		});

		panel.add(jbdetails);

		jbclose = new JButton("");
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
		panel.add(jbclose);
		
		jbra = new JButton("Modify RA'S");
		jbra.setBackground(new Color(8, 116, 247));
		jbra.setToolTipText("Modify RA'S");
		jbra.setBorderPainted(false);
		jbra.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "No row selected", "Error:", JOptionPane.ERROR_MESSAGE);
				} else {
					dispose();
					MainWindowRA main = new MainWindowRA(Integer.parseInt(String.valueOf(dtm.getValueAt(table.getSelectedRow(), 0))));
					
				}

			}
		});
		panel.add(jbra);

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

			for (Subject s : f.ReadSubjects()) {
				Object[] row = new Object[4];
				row[0] = s.getId();
				row[1] = s.getName();
				dtm.addRow(row);
			}

			f.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
