package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.RA;

public class DetailsRA extends JFrame{
	private JLabel jlid, jlname, jldescription, jlweighing, jlid_subj;
	private JTextField jtid, jtname, jtdecription, jtweighing, jtid_subj;
	private JButton jbcancel;
	RA ra = new RA();

	public DetailsRA(int idSubject) {
		super("Details RA");
		inicializate(DetailsRA.this);

		try {
			Functions f = new Functions();
			ra = f.ReadRA(idSubject);
			f.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		jlid = new JLabel("id: ");
		jlid.setBackground(new Color(0, 176, 220));
		jlid.setBounds(147, 122, 84, 13);
		jlid.setHorizontalAlignment(SwingConstants.CENTER);
		jlid.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlid);

		jtid = new JTextField(String.valueOf(ra.getId()));
		jtid.setBounds(241, 119, 167, 19);
		jtid.setBackground(new Color(0, 176, 220));
		jtid.setColumns(12);
		jtid.setToolTipText("Introduce the ID");
		jtid.setEditable(false);
		getContentPane().add(jtid);

		jlname = new JLabel("Name: ");
		jlname.setBackground(new Color(0, 176, 220));
		jlname.setBounds(147, 62, 72, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlname);

		jtname = new JTextField(ra.getName());
		jtname.setBounds(242, 59, 167, 19);
		jtname.setBackground(new Color(0, 176, 220));
		jtname.setColumns(10);
		jtname.setToolTipText("Introduce the name");
		jtname.setEditable(false);
		getContentPane().add(jtname);

		jldescription = new JLabel("Description:");
		jldescription.setBackground(new Color(0, 176, 220));
		jldescription.setBounds(137, 92, 94, 13);
		jldescription.setHorizontalAlignment(SwingConstants.CENTER);
		jldescription.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jldescription);

		jtdecription = new JTextField(ra.getDescription());
		jtdecription.setBounds(242, 89, 167, 19);
		jtdecription.setBackground(new Color(0, 176, 220));
		jtdecription.setColumns(10);
		jtdecription.setToolTipText("Introduce the description");
		jtdecription.setEditable(false);
		getContentPane().add(jtdecription);

		jlweighing = new JLabel("Weighing:");
		jlweighing.setBackground(new Color(0, 176, 220));
		jlweighing.setBounds(137, 92, 94, 13);
		jlweighing.setHorizontalAlignment(SwingConstants.CENTER);
		jlweighing.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlweighing);

		jtweighing = new JTextField(String.valueOf(ra.getWeighing()));
		jtweighing.setBounds(242, 89, 167, 19);
		jtweighing.setBackground(new Color(0, 176, 220));
		jtweighing.setColumns(10);
		jtweighing.setToolTipText("Introduce your weighing");
		jtweighing.setEditable(false);
		getContentPane().add(jtweighing);

		jlid_subj = new JLabel("ID_Subject:");
		jlid_subj.setBackground(new Color(0, 176, 220));
		jlid_subj.setBounds(137, 92, 94, 13);
		jlid_subj.setHorizontalAlignment(SwingConstants.CENTER);
		jlid_subj.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		getContentPane().add(jlid_subj);

		jtid_subj = new JTextField(String.valueOf(ra.getId_subject()));
		jtid_subj.setBounds(242, 89, 167, 19);
		jtid_subj.setBackground(new Color(0, 176, 220));
		jtid_subj.setColumns(10);
		jtid_subj.setToolTipText("Introduce your id_subj");
		jtid_subj.setEditable(false);
		getContentPane().add(jtid_subj);
		
		// Boton cancel

		jbcancel = new JButton("");
		jbcancel.setBounds(48, 302, 112, 37);
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindowRA mainteach = new MainWindowRA(ra.getId());

			}
		});
		getContentPane().add(jbcancel);
		setVisible(true);
	}

	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(new Color(0, 176, 220));
		jf.getContentPane().setBackground(new Color(0, 176, 220));
		jf.setBounds(100, 100, 340, 220);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(new GridLayout(6, 2));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/School.png");
		jf.setIconImage(icon1);
	}
}

