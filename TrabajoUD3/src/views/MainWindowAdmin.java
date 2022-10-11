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

import Entities.Crypto;
import java.awt.Font;
import java.awt.FlowLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
@SuppressWarnings("serial")
public class MainWindowAdmin extends JFrame {

	/** The table. */
	private JTable table;

	/** The jPanels. */
	private JPanel panel, panel_1;

	/** The jButtons. */
	private JButton jbdetails, jbinsert, jbupdate, jbclose, jbstatistics, jbdelete;

	/** The jluser. */
	private JLabel jluser;

	/** The jcbfilter. */
	private JComboBox<Object> jcbfilter;

	/** The is. */
	private ObjectInputStream is;

	/** The os. */
	private ObjectOutputStream os;

	/** The f. */
	private File f = new File("files/Cryptos");

	/** The name colums. */
	String[] nameColums = { "Name", "Value", "Market Cap", "Creator" };

	/** The list C. */
	static List<Crypto> listC;

	/** The list order. */
	static List<Crypto> listOrder;

	/** The icon. */
	private Icon icon;

	/**
	 * Instantiates a new main window.
	 *
	 * @param name the name
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainWindowAdmin(String name) {
		super("Menu");
		inicializate(MainWindowAdmin.this);

		listOrder = new ArrayList<>();
		listC = new ArrayList<>();
		try {
			is = new ObjectInputStream(new FileInputStream(f));
			Crypto c = (Crypto) is.readObject();
			while (c != null) {
				listC.add(c);
				c = (Crypto) is.readObject();
			}
			is.close();
		} catch (Exception e) {
		}

		jluser = new JLabel("Username: " + name);
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		jluser.setFont(new Font("Poor Richard", Font.BOLD, 18));

		String[] filters = { "Default", "Name A-Z", "Name Z-A", "Value >", "Value <", "MarketCap >", "MarketCap <",
				"Creator A-Z", "Creator Z-A" };

		JPanel jpupper = new JPanel();
		jpupper.setBackground(new Color(243, 189, 109));
		jcbfilter = new JComboBox(filters);
		jcbfilter.setBackground(new Color(196, 172, 148));
		jcbfilter.setToolTipText("Filters");
		jcbfilter.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                            @Override
                            protected JButton createDecreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            protected JButton createIncreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            public Dimension getPreferredSize(JComponent c) {
                                return new Dimension(10, super.getPreferredSize(c).height);
                            }

                            private JButton createZeroButton() {
                                return new JButton() {
                                    @Override
                                    public Dimension getMinimumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getPreferredSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getMaximumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }
                                };
                            }
                        });
                        return scroller;
                    }
                };
            }
        });
		jcbfilter.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evento) {
				if (jcbfilter.getSelectedItem().equals("Default")) {
					listOrder = listC;
					createJTable();

				} else if (jcbfilter.getSelectedItem().equals("Name A-Z")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getName))
							.collect(Collectors.toList());
					createJTable();

				} else if (jcbfilter.getSelectedItem().equals("Name Z-A")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getName).reversed())
							.collect(Collectors.toList());
					createJTable();
				} else if (jcbfilter.getSelectedItem().equals("Value >")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getValue).reversed())
							.collect(Collectors.toList());
					createJTable();

				} else if (jcbfilter.getSelectedItem().equals("Value <")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getValue))
							.collect(Collectors.toList());
					createJTable();

				} else if (jcbfilter.getSelectedItem().equals("MarketCap >")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getMarketCap).reversed())
							.collect(Collectors.toList());
					createJTable();

				} else if (jcbfilter.getSelectedItem().equals("MarketCap <")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getMarketCap))
							.collect(Collectors.toList());
					createJTable();

				} else if (jcbfilter.getSelectedItem().equals("Creator A-Z")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getCreator))
							.collect(Collectors.toList());
					createJTable();
				} else if (jcbfilter.getSelectedItem().equals("Creator Z-A")) {
					listOrder = listC.stream().sorted(Comparator.comparing(Crypto::getCreator).reversed())
							.collect(Collectors.toList());
					createJTable();
				}
			}
		});
		
		jpupper.add(jluser);
		jpupper.add(jcbfilter);
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

		listOrder = listC;
		createJTable();
		// Termina el JTable

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(196, 172, 148));
		panel_1.setOpaque(true);
		add(panel_1, BorderLayout.SOUTH);

		jbstatistics = new JButton("");
		jbstatistics.setBackground(new Color(196, 172, 148));
		jbstatistics.setToolTipText("Statistics");
		jbstatistics.setBorderPainted(false);
		jbstatistics.setIcon(new ImageIcon("images/statistics.png"));
		jbstatistics.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stadistics statistics = new Stadistics(name);

			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(jbstatistics);

		panel = new JPanel();
		panel.setBackground(new Color(196, 172, 148));
		panel_1.add(panel);

		jbinsert = new JButton("");
		jbinsert.setBackground(new Color(196, 172, 148));
		jbinsert.setToolTipText("Insert");
		jbinsert.setBorderPainted(false);
		jbinsert.setIcon(new ImageIcon("images/Insert.png"));
		jbinsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Insert statistics = new Insert(name);
				dispose();

			}
		});
		panel.add(jbinsert);

		jbdetails = new JButton("");
		jbdetails.setIcon(new ImageIcon("images/details.png"));
		jbdetails.setToolTipText("Details");
		jbdetails.setBackground(new Color(196, 172, 148));
		jbdetails.setBorderPainted(false);
		jbdetails.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() < 0) {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "You have to select a crypto", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				} else {
					Crypto c = getListC().get(table.getSelectedRow());
					dispose();
					Details.cryp = c;
					Details details = new Details(name);
				}

			}
		});
		panel.add(jbdetails);

		jbupdate = new JButton("");
		jbupdate.setBackground(new Color(196, 172, 148));
		jbupdate.setToolTipText("Update");
		jbupdate.setBorderPainted(false);
		jbupdate.setIcon(new ImageIcon("images/update.png"));
		jbupdate.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() >= 0) {
					Crypto c = getListC().get(table.getSelectedRow());
					if (c.getCreator().equals(name) || name.equals("admin")) {

						dispose();
						Update.cryp = c;
						Update update = new Update(name, table.getSelectedRow());
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(MainWindow.this, "You aren't creator", "Error",
								JOptionPane.WARNING_MESSAGE, icon);
					}

				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "You have to select a crypto", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}
			}
		});
		panel.add(jbupdate);

		jbdelete = new JButton("");
		jbdelete.setBackground(new Color(196, 172, 148));
		jbdelete.setToolTipText("Delete");
		jbdelete.setBorderPainted(false);
		jbdelete.setIcon(new ImageIcon("images/delete.png"));
		jbdelete.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("images/warning.png");
				int contCrypto = (int) getListC().stream().count();

				if (table.getSelectedRow() >= 0) {
					Crypto cryp = getListC().get(table.getSelectedRow());
					if (cryp.getCreator().equals(name) || name.equals("admin")) {
						int option = JOptionPane.showOptionDialog(MainWindow.this, "Are you sure?", "Confirm",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
						if (option == 0) {
							if (contCrypto != 1) {
								getListC().remove(table.getSelectedRow());
								int cont = 0;
								for (Crypto c : getListC()) {
									Crypto crypto = new Crypto(c.getName(), c.getValue(), c.getMarketCap(),
											c.getSupply(), c.getDescription(), c.getIcon(), c.getCreator(),
											c.getMonth());
									try {
										if (cont == 0) {
											os = new ObjectOutputStream(new FileOutputStream(f));
										} else {
											os = new AddObjectOutputStream(new FileOutputStream(f, true));
										}
										os.writeObject(crypto);
										os.close();
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									cont++;
								}
								dispose();
								MainWindowTeacher main = new MainWindowTeacher(name);
							} else {
								f.delete();
								dispose();
								MainWindowTeacher main = new MainWindowTeacher(name);
							}

						} else {
							dispose();
							MainWindowTeacher main = new MainWindowTeacher(name);
						}
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(MainWindowTeacher.this, "You dont be creator", "Error",
								JOptionPane.WARNING_MESSAGE, icon);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(MainWindowTeacher.this, "You haven't to select a crypto", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}

			}
		});
		panel.add(jbdelete);

		jbclose = new JButton("");
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

		for (Crypto c : listOrder) {
			Object[] row = new Object[4];
			row[0] = c.getName();
			row[1] = c.getValue();
			row[2] = c.getMarketCap();
			row[3] = c.getCreator();
			dtmCrypto.addRow(row);
		}
		table.setModel(dtmCrypto);
	}

	/**
	 * Gets the list C.
	 *
	 * @return the list C
	 */
	public static List<Crypto> getListC() {
		return listC;
	}

	/**
	 * Sets the list C.
	 *
	 * @param listC the new list C
	 */
	public static void setListC(List<Crypto> listC) {
		MainWindowTeacher.listC = listC;
	}
s
}