package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Item.Cola;
import Item.Manage;

public class Submission extends JFrame implements ActionListener{
	private form form;
	private JPanel Pane;
	private JButton Submit, Cancel;
	private Manage manage;
	public Submission() {
		manage = new Manage();
		form = new form();
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		Pane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 10));
		Submit = new JButton("Submit");
		Cancel = new JButton("Cancel");
		Submit.addActionListener(this);
		Cancel.addActionListener(this);
		
		
		Pane.add(Submit);
		Pane.add(Cancel);
		
		
		this.add(form);
		this.add(Pane);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Submit) {
			Cola Item = form.newCola(); 
			if(Item == null) {
				JOptionPane.showMessageDialog(null, "Eror to insert item please check the requirement !!");
			}else {
				manage.insert(Item);
				JOptionPane.showMessageDialog(null, "Success to add an item !!");
				form.Reset();
			}
			
		}else if(e.getSource() == Cancel) {
			new Home();
			this.dispose();
		}
		
	}

}
