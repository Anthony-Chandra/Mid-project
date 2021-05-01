package Start;

import java.sql.Connection;

import UI.Home;
public class Main {

	public static Connection connect;
	
	public static void main(String[] args) {
		new Home();
		
//		ConnectDatabase connect = new ConnectDatabase();
		
		

//		connect = ConnectSql.connectDatabase();
//		try {
//			Statement stmt = connect.createStatement();
//			String query = "insert into item values ('Sr100', 'Meat', 10, 10)";
//			stmt.execute(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}
	
}
