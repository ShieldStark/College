package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class querydb {
	
	private static String dbUrl="jdbc:mysql://localhost:3306/quizdb";
	private static String dbUname="root";
	private static String dbPassword="8824497447Pa@";
	private static String dbDriver="com.mysql.jdbc.Driver";
	
	
	
	public static ArrayList<dataobj> getData(int courseId) {
		ArrayList<dataobj> query=new ArrayList<dataobj>();
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="select * from question where courseId=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, courseId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				dataobj q=new dataobj();
				
				q.question(rs.getString("Question"));
				q.choice1(rs.getString("OptionA"));
				q.choice2(rs.getString("OptionB"));
				q.choice3(rs.getString("OptionC"));
				q.choice4(rs.getString("OptionD"));
				q.answer(rs.getString("Correct"));
				query.add(q);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		for(int i=0;i<query.size();i++) {
				System.out.println(query.get(i).question);
		}
		return query;
	}

}
