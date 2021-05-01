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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Item.Cola;
import Item.Manage;
import model.Pet;

public class Update extends JFrame implements ActionListener, MouseListener{
	private Manage manage;
	private form form;
	private Vector<String> Header;
	private DefaultTableModel modell;
	private JTable table;
	private JScrollPane scroll;
	private JButton back, discard, update;
	private JPanel panel;
	public Update() {
		manage = new Manage();
		form = new form();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		
		newTable();
		this.add(form);		
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
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}
	private void Button() {
		back = new JButton("Back");
		discard = new JButton("Discard");
		update = new JButton("Update");
		
		
		back.addActionListener(this);
		discard.addActionListener(this);
		update.addActionListener(this);
		panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		panel.add(back);
		panel.add(Box.createHorizontalStrut(200));
		panel.add(discard);
		panel.add(update);
		this.add(panel);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int row = table.rowAtPoint(e.getPoint());
		
		if(row >= 0 && row < table.getRowCount()) {
			table.setRowSelectionInterval(row, row);
			form.setItem(getData());
		}else {
			table.clearSelection();
		}
		
		
	}
	private Cola getData() {
		int r = table.getSelectedRow();
		
		String id = table.getValueAt(r, 0).toString();
		String name = table.getValueAt(r, 1).toString();
		int price = Integer.parseInt(table.getValueAt(r, 2).toString());
		int stock = Integer.parseInt(table.getValueAt(r, 3).toString());
		
		Cola cola = new Cola(id, name, price, stock);
		return cola;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			new Home();
			this.dispose();
		}else if(e.getSource() == update){
			Cola cola = form.newCola();
			int row = table.getSelectedRow();
			String id = table.getValueAt(row, 0).toString();
			cola.setId(id);
			manage.update(cola);
			JOptionPane.showMessageDialog(null, "Succes to update");
			modell.setDataVector(manage.view(), Header);
		}else if(e.getSource() == discard) {
			int row = table.getSelectedRow();
			form.setItem(getData());
		}
		
	}

}
