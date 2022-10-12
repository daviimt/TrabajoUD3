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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.FlowLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
@SuppressWarnings("serial")
public class MainWindowStudent extends JFrame {

	/** The table. */
	private JTable table;

	/** The jPanels. */
	private JPanel panel, panel_1;

	/** The jButtons. */
	private JButton jbupdate, jbclose;

	/** The jluser. */
	private JLabel jluser;

	/** The f. */
	private File f = new File("files/Cryptos");

	/** The name colums. */
	String[] nameColums = { "Subject", "RA", "Mark" };

	/** The list C. */
	//static List<Crypto> listC;

	/** The list order. */
	//static List<Crypto> listOrder;

	/** The icon. */
	private Icon icon;

	/**
	 * Instantiates a new main window.
	 *
	 * @param name the name
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowStudent(String name) {
		super("Menu");
		inicializate(MainWindowStudent.this);

		jluser = new JLabel("Username: " + name);
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		jluser.setFont(new Font("Poor Richard", Font.BOLD, 18));

		JPanel jpupper = new JPanel();
		jpupper.setBackground(new Color(243, 189, 109));
		
		jpupper.add(jluser);
		add(jpupper, BorderLayout.NORTH);

		// JTable Prueba (con defaulttablemade)

		table = new JTable();
		table.setBackground(new Color(182, 147, 164));
		table.setOpaque(true);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(32, 32, 32));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(252, 228, 163));
		scrollPane.getViewport().setBackground(new Color(252, 228, 163));
		add(scrollPane, BorderLayout.CENTER);


		createJTable();
		// Termina el JTable

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(196, 172, 148));
		panel_1.setOpaque(true);
		add(panel_1, BorderLayout.SOUTH);

		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel = new JPanel();
		panel.setBackground(new Color(196, 172, 148));
		panel_1.add(panel);

	
		jbupdate = new JButton("Update data");
		jbupdate.setBackground(new Color(196, 172, 148));
		jbupdate.setToolTipText("Update your data");
		jbupdate.setBorderPainted(false);
		jbupdate.setIcon(new ImageIcon("images/update.png"));

		panel.add(jbupdate);

		jbclose = new JButton("Back");
		jbclose.setBackground(new Color(196, 172, 148));
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
		jf.setBackground(new Color(146, 104, 124));
		jf.setBounds(100, 100, 600, 400);
		jf.setMinimumSize(getSize());
		jf.setLocationRelativeTo(null);
		jf.setLayout(new BorderLayout(0, 0));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);
	}

	/**
	 * Creates the J table.
	 */
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