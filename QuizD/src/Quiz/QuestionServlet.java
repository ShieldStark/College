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
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
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
		
		int courseId= Integer.parseInt(request.getParameter("cid"));
		String question=request.getParameter("Question");
		String optionA=request.getParameter("OA");
		String optionB=request.getParameter("OB");
		String optionC=request.getParameter("OC");
		String optionD=request.getParameter("OD");
		String correct=request.getParameter("correct");
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="insert into question values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, question);
			ps.setString(2, optionA);
			ps.setString(3, optionB);
			ps.setString(4, optionC);
			ps.setString(5, optionD);
			ps.setString(6, correct);
			ps.setInt(7, courseId);
			ps.executeUpdate();
			System.out.println("Inserted in courseId");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		response.sendRedirect("CreateQuiz.jsp?courseId="+courseId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
