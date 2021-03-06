package Quiz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminSigIn
 */
@WebServlet("/AdminSigIn")
public class AdminSigIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSigIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hello");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		System.out.println("Username: "+uname+" password:"+pass);
		AdminSignInDao dao=new AdminSignInDao();
		if(dao.check(uname, pass)) {
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("AdminWelcome.jsp");
		}
		else {
			System.out.println("login Denied");
			request.setAttribute("error", "Invalid user id or password");
			response.sendRedirect("AdminLogin.jsp?error=Invalid user id or password");
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
