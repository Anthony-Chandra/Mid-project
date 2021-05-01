package DataBase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSql {

	public ConnectSql() {
		
	}
	public static Connection connectDatabase() {
			Connection connecting = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				
				connecting = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projekfinal?useLegacyDatetimeCode=false&serverTimezone=UTC", "root",
					"");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			return connecting;
		}
		
	}