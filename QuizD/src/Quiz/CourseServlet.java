package Quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String dbUrl="jdbc:mysql://localhost:3306/quizdb";
		String dbUname="root";
		String dbPassword="8824497447Pa@";
		String dbDriver="com.mysql.jdbc.Driver";
		String courseName= request.getParameter("cname");
		int courseId= Integer.parseInt(request.getParameter("cid"));
		int EmpId= Integer.parseInt(request.getParameter("adm"));
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String s="select * from course where courseid=?";
			PreparedStatement st=con.prepareStatement(s);
			st.setInt(1, courseId);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				response.sendRedirect("CreateQuiz.jsp?courseId="+courseId);
			}
			else {
			String sql="insert into course values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, courseName);
			ps.setInt(2, courseId);
			ps.setInt(3, EmpId);
			ps.executeUpdate();
			System.out.println("Inserted in Course");
			response.sendRedirect("CreateQuiz.jsp?courseId="+courseId);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
