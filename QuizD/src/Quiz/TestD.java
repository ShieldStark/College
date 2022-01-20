package Quiz;

import java.sql.*;

public class TestD {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/QuizDB","root","8824497447Pa@"); 
		System.out.println("Connected");
		PreparedStatement st= con.prepareStatement("select email,password from temp where email=? and password=?");
		st.setString(1, "abc.abc.com");
		st.setString(2, "12345");
		ResultSet rs=st.executeQuery();
		System.out.println("Hello");
		System.out.println(rs.getString("email"));

	}

}
