package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import Item.Manage;

public class Delete implements ActionListener{
	private Info info;
	private Manage manage;
	private JPopupMenu popUp;
	private JButton Delete;
	
	public Delete() {
		manage = new Manage();
		info = new Info();
		popUp = new JPopupMenu();
		Delete = new JButton("Delete");
		Delete.addActionListener(this);
		popUp.add(Delete);
		info.table.setComponentPopupMenu(popUp);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Delete) {
			int row = info.table.getSelectedRow();
			String ID = info.table.getValueAt(row, 0).toString();
			
			manage.delete(ID);
			
			JOptionPane.showMessageDialog(null, "Success to Delete");
		
			info.modell.setDataVector(manage.view(), info.Header);
		}else {
			
		}
		
	}

}
