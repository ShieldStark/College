package Quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseDelete
 */
@WebServlet("/CourseDelete")
public class CourseDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDelete() {
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
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			int courseId=Integer.parseInt(request.getParameter("cid"));
			String sql="delete course, question from course inner join question on course.courseid=question.courseid where course.courseid=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, courseId);
			ps.executeUpdate();
			System.out.println("Deleted in course");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		response.sendRedirect("delete.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
