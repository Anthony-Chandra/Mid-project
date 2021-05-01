package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Item.Manage;

public class Info extends JFrame implements ActionListener{
	private Manage manage;
	private form form;
	private JScrollPane scroll;
	public JTable table;
	private JButton deleteBtn, cancel, update, back;
	public Vector<String> Header;
	public DefaultTableModel modell;
	private JPanel panel;
	
	public Info() {
		manage = new Manage();
//		form = new form();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		
		newTable();
//		this.add(form);
		
		Button();
		
		
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	private void newTable() {
		Header = new Vector<String>();
		Header.add("ID");
		Header.add("Name");
		Header.add("Price");
		Header.add("Stock");
		
		modell = new DefaultTableModel(manage.view(), Header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(modell);
		
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}
	private void Button() {
		back = new JButton("Back");
		
		back.addActionListener(this);
		
		panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		panel.add(back);
//		panel.add(Box.createHorizontalStrut(200));
		
		this.add(panel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			new Home();
			this.dispose();
		}
		
	}

}
