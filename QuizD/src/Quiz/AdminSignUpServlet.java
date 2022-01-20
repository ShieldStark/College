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
 * Servlet implementation class AdminSignUpServlet
 */
@WebServlet("/AdminSignUpServlet")
public class AdminSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignUpServlet() {
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
		String fname= request.getParameter("fname");
		String lname=request.getParameter("lname");
		int empid= Integer.parseInt(request.getParameter("empid"));
		String email= request.getParameter("email");
		int mobile= Integer.parseInt(request.getParameter("mobile"));
		String password=request.getParameter("pass");
		String gender=request.getParameter("gender");
		System.out.println(fname+" "+lname+" "+empid+" "+email+" "+mobile+" "+password+" "+gender);
		
		try {
			Class.forName(dbDriver);  
			Connection con =DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			String sql="insert into admin values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email );
			ps.setString(2, password);
			ps.setString(3, email );
			ps.setInt(4, mobile );
			ps.setString(5, fname);
			ps.setString(6, lname);
			ps.setInt(7, empid);
			ps.setString(8, gender);
			ps.executeUpdate();
			System.out.println("Inserted in Admin");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		response.sendRedirect("AdminAdded.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
