package Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DataBase.ConnectSql;

public class Manage {
	private Connection connect;
	private Vector<Vector<String>> itm;
	public Manage() {
		
	}
	public void insert(Cola Item) {
		connect = ConnectSql.connectDatabase();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			String query = String.format("insert into item values ('%s', '%s', %d, %d)", Item.getId(), Item.getName(), Item.getHarga(), Item.getStock());
			stmt.execute(query);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	public Vector<Vector<String>> view(){
		Vector<Vector<String>> itm = new Vector<Vector<String>>();
		connect = ConnectSql.connectDatabase();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			String query = "SELECT * FROM item";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getString(4));
				
				itm.add(data);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itm;
	}
	public void update(Cola Item) {
		connect = ConnectSql.connectDatabase();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			String query = String.format("update item set Name = '%s', Harga = %d, Stock = %d where ID = '%s'", Item.getName(), Item.getHarga(), Item.getStock(), Item.getId());
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete(String id) {
		connect = ConnectSql.connectDatabase();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			String query = "delete from item where id = '"+id+"'";
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 }