package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Item.Cola;

public class form extends JPanel{
	private JPanel Panel1, Panel2, Panel3;
	private JTextField name, harga, stock; 
	private Random rand;
	public form() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Panel1 = Panel();
		Panel2 = Panel();
		Panel3 = Panel();
		Panel1.add(new JLabel("Name:"));
		name = new JTextField(20);
		Panel1.add(name);
		
		Panel2.add(new JLabel("Price Item (Numeric):"));
		harga = new JTextField(10);
		Panel2.add(harga);
		
		Panel3.add(new JLabel("Stock Item (Numeric):"));
		stock = new JTextField(10);
		Panel3.add(stock);
		
		
		
		this.add(Panel1);
		this.add(Panel2);
		this.add(Panel3);
	}

	public Cola newCola() {
		rand = new Random();
		Boolean valid = true;
		int harga2 = 0;
		int stock2 = 0;		
		String name1 = name.getText();
		if(name1.trim().isEmpty()) {
			valid = false;
		}
		
		String stock1 = stock.getText();
		stock1.trim();
		if(stock1.isEmpty()) {
			valid = false;
		}

		try {
			stock2 = Integer.parseInt(stock1);
		} catch (Exception e) {
			valid = false;
		}
		String harga1 = harga.getText();
		harga1.trim();
		if(harga1.isEmpty()) {
			valid = false;
		}
		try {
			harga2 = Integer.parseInt(harga1);
		} catch (Exception e) {
			valid = false;
		}
		
		String id = "BC-";
		id += rand.nextInt(11);
		id += rand.nextInt(11);
		id += rand.nextInt(11);
		
		if (valid == false) {
			return null;
		}else {
			return new Cola(id, name1, harga2, stock2);
		}
	}
	private JPanel Panel() {
		return new JPanel(new FlowLayout(FlowLayout.LEADING, 20, 10));
	}
	public void Reset() {
		name.setText("");
		stock.setText("");
		harga.setText("");
	}
	
	public void setItem(Cola cola) {
		name.setText(cola.getName());
		harga.setText(String.valueOf(cola.getHarga()));
		stock.setText(String.valueOf(cola.getStock()));
	}
}
