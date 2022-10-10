package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
@SuppressWarnings("serial")
public class Login extends JFrame {

	/** The jltitle. */
	private JLabel jlusername, jlpassword, jltitle;

	/** The jbaccess. */
	private JButton jbregister, jbaccess;

	/** The jtusername. */
	private JTextField jtusername;

	/** The jppassword. */
	private JPasswordField jppassword;

	/** The icon. */
	private Icon icon;

	/** The jpanel 4. */
	private JPanel jpanel1, jpanel2, jpanel3, jpanel4;

	/** The fusers. */
	private File fusers = new File("files/Users");

	/**
	 * Instantiates a new login.
	 */
	public Login() {
		super("Login");
		inicializate(Login.this);

		Connect conn=new Connect();
		
		jpanel1 = new JPanel();
		jpanel1.setBackground(new Color(0, 176, 220));
		jpanel2 = new JPanel();
		jpanel2.setBackground(new Color(0, 176, 220));
		jpanel3 = new JPanel();
		jpanel3.setBackground(new Color(0, 176, 220));
		jpanel4 = new JPanel();
		jpanel4.setBackground(new Color(0, 176, 220));

		jltitle = new JLabel("School");
		jltitle.setBounds(25, 32, 70, 21);
		jltitle.setVerticalAlignment(SwingConstants.BOTTOM);
		jltitle.setHorizontalAlignment(SwingConstants.CENTER);
		jltitle.setForeground(new Color(0, 70, 101));
		jltitle.setIcon(new ImageIcon("images/CoinMarket.png"));
		jltitle.setFont(new Font("Microsoft Himalaya", Font.BOLD, 25));
		jpanel1.add(jltitle);

		jlusername = new JLabel("Username:");
		jlusername.setBounds(25, 32, 70, 21);
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		jlusername.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jpanel2.add(jlusername);

		jtusername = new JTextField();
		jtusername.setBounds(118, 29, 96, 19);
		jtusername.setBackground(new Color(0, 176, 220));
		jtusername.setColumns(10);
		jtusername.setToolTipText("Introduce your user");
		jpanel2.add(jtusername);

		jlpassword = new JLabel("Password:");
		jlpassword.setBounds(25, 58, 70, 21);
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jpanel3.add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(118, 52, 96, 21);
		jppassword.setBackground(new Color(0, 176, 220));
		jppassword.setColumns(10);
		jppassword.setToolTipText("Introduce your password");
		jppassword.addActionListener(new Handler());
		jpanel3.add(jppassword);

		jbregister = new JButton("re");
		jbregister.setBounds(22, 93, 85, 21);
		jbregister.setBackground(new Color(0, 176, 220));
		jbregister.setToolTipText("Register");
		jbregister.setBorderPainted(false);
		jbregister.setIcon(new ImageIcon("images/register.png"));
		jbregister.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				dispose();
			}
		});
		jpanel4.add(jbregister);

		jbaccess = new JButton("ac");
		jbaccess.setBounds(128, 93, 85, 21);
		jbaccess.setBackground(new Color(0, 176, 220));
		jbaccess.setToolTipText("Login");
		jbaccess.setBorderPainted(false);
		jbaccess.setIcon(new ImageIcon("images/login.png"));
		jbaccess.addActionListener(new Handler());
		jpanel4.add(jbaccess);

		add(jpanel1);
		add(jpanel2);
		add(jpanel3);
		add(jpanel4);
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
		jf.setSize(300, 230);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setLayout(new GridLayout(4, 1));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);
	}

	/**
	 * The Class Handler.
	 */
	private class Handler implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@SuppressWarnings({ "deprecation", "unused" })
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean existUser = false;
			boolean passwordCorrect = false;

			if (jtusername.getText().isBlank() == false) {
				if (fusers.exists() == true) {
					try {
						BufferedReader br = new BufferedReader(new FileReader(fusers));
						String linea = br.readLine();
						while (linea != null) {

							String[] usuario = linea.split(";");
							if (usuario[0].equals(jtusername.getText())) {
								existUser = true;
								if (usuario[4].equals(jppassword.getText())) {
									passwordCorrect = true;
								}
							}

							linea = br.readLine();
						}
						br.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if(jtusername.getText().equals("admin")) {
						
					}else {
						
					}
						
					
					if (existUser == true) {
						if (passwordCorrect == true) {
							//MainWindow main = new MainWindow(jtusername.getText());
							dispose();
						} else {
							icon = new ImageIcon("images/warning.png");
							JOptionPane.showMessageDialog(null, "Incorrect password", "Error",
									JOptionPane.WARNING_MESSAGE, icon);
						}
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(null, "User doesn't exist", "Error", JOptionPane.WARNING_MESSAGE,
								icon);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Don't exist any users", "Error", JOptionPane.WARNING_MESSAGE,
							icon);
				}
			} else {
				icon = new ImageIcon("images/warning.png");
				JOptionPane.showMessageDialog(null, "User name is empty", "Error", JOptionPane.WARNING_MESSAGE, icon);
			}
		}

	}
}