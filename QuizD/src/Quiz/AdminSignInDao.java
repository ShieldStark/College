package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminSignInDao {
	private static String dbUrl="jdbc:mysql://localhost:3306/quizdb";
	private static String dbUname="root";
	private static String dbPassword="8824497447Pa@";
	private static String dbDriver="com.mysql.jdbc.Driver";
	public boolean check(String uname,String pass) {
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="select email,password from admin where email=? and password=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs=st.executeQuery();
			System.out.println("result");
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

}
