package ab;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cnnt 
{
	public Connection getDbConnection() 
		{
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","8824497447");  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return conn;
	}

}
