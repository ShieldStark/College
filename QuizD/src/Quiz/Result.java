package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Result {
	private static String dbUrl="jdbc:mysql://localhost:3306/quizdb";
	private static String dbUname="root";
	private static String dbPassword="8824497447Pa@";
	private static String dbDriver="com.mysql.jdbc.Driver";
	public int getempId(int courseId) {
		int empId=0;
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="select empId from course where courseId=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, courseId);
			ResultSet rs=st.executeQuery();
			System.out.println("result");
			empId=Integer.parseInt(rs.getString("empId"));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return empId;
	}
	public int getstudentId(String email) {
		int studentId=0;
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="select studentId from student where email=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs=st.executeQuery();
			System.out.println("result");
			studentId=Integer.parseInt(rs.getString("empId"));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return studentId;
	}
	public int getstudentId(int courseId,int empId, int studentId, int correct, int total, float percent) {
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="insert into result values(?,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,courseId);
			st.setInt(2, empId);
			st.setInt(3, studentId);
			st.setInt(4, correct);
			st.setInt(5, total);
			st.setFloat(6, percent);
			ResultSet rs=st.executeQuery();
			System.out.println("result");
			studentId=Integer.parseInt(rs.getString("empId"));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return studentId;
	}

}
