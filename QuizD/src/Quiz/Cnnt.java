package Quiz;
import java.sql.*;
public class Cnnt {
	private static String dbUrl="jdbc:mysql://localhost:3306/quizdb";
	private static String dbUname="root";
	private static String dbPassword="8824497447Pa@";
	private static String dbDriver="com.mysql.jdbc.Driver";
	public static void main(String args[]){
		try {
		Class.forName(dbDriver);  
		Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword); 
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
}
