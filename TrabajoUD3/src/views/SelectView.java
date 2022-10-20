package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectView.
 */
public class SelectView extends JFrame {

	/** The jblogout. */
	private JButton jbusers, jbsubject, jblogout;

	/**
	 * Instantiates a new select view.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SelectView() {
		super("Select view");
		inicializate(SelectView.this);

		jbusers = new JButton("Modify users");
		jbusers.setSize(290, 38);
		jbusers.setLocation(99, 69);
		jbusers.setBackground(new Color(0, 176, 220));
		jbusers.setToolTipText("Modify users");
		jbusers.setBorderPainted(true);
		jbusers.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowAdmin mainusers = new MainWindowAdmin();

			}
		});
		getContentPane().add(jbusers);

		jbsubject = new JButton("Modify subjects");
		jbsubject.setLocation(99, 139);
		jbsubject.setSize(290, 38);
		jbsubject.setBackground(new Color(0, 176, 220));
		jbsubject.setToolTipText("Modify subjects and RA's");
		jbsubject.setBorderPainted(true);
		jbsubject.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowSubject mainsubject = new MainWindowSubject();

			}
		});
		getContentPane().add(jbsubject);
		
		jblogout = new JButton("");
		jblogout.setLocation(99, 139);
		jblogout.setSize(290, 38);
		jblogout.setBackground(new Color(0, 176, 220));
		jblogout.setToolTipText("Log Out");
		jblogout.setIcon(new ImageIcon("images/logout.png"));
		jblogout.setBorderPainted(true);
		jblogout.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();

			}
		});
		getContentPane().add(jblogout);
		
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
		jf.getContentPane().setLayout(new GridLayout(3,1));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}
}
