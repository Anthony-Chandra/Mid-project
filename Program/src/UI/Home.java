package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Home extends JFrame implements ActionListener{
	private JPanel panel1, panel2;
	private JTextField nameText1, nameText2;
	private JMenuBar menuOp;
	private JButton menuInsert, menuView, menuDelete, menuUpdate;

	public Home() {
		this.setTitle("BobaCool");
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.setResizable(false);
		menuBar();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void menuBar() {
		menuOp = new JMenuBar();
		this.setJMenuBar(menuOp);
		menuInsert = new JButton("Insert");
		menuView = new JButton("View");
		menuDelete = new JButton("Delete");
		menuUpdate = new JButton("Update");
		
		menuInsert.addActionListener(this);
		menuView.addActionListener(this);
		menuDelete.addActionListener(this);
		menuUpdate.addActionListener(this);
		
		
		menuOp.add(menuInsert);
		menuOp.add(menuView);
		menuOp.add(menuUpdate);
		menuOp.add(menuDelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuInsert) {
			new Submission();
			this.dispose();
		}
		else if(e.getSource() == menuView) {
			new Info();
			this.dispose();
		}
		else if(e.getSource() == menuUpdate) {
			new Update();
			this.dispose();
		}
		else if(e.getSource() == menuDelete) {
			new Delete();
			this.dispose();
		}
		
	}


}
