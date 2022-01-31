package ab;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubDivisionServlet
 */
@WebServlet("/SubDivisionServlet")
public class SubDivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubDivisionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("subdivisionservlet Called");
		 int x=Integer.parseInt(request.getParameter("valajax"));
		 System.out.println(x);
		 try
		 {
			 ArrayList<String> arr=new ArrayList<String>();
			 ArrayList<String> arr1=new ArrayList<String>();
			 Cnnt con= new Cnnt();
			PreparedStatement st= con.getDbConnection().prepareStatement("select * from subdivision where division_id=?");
			st.setInt(1, x);
			ResultSet rs= st.executeQuery();
			
			while(rs.next())
			{
					arr.add(rs.getString("subdivision_name" ));
					arr1.add(rs.getString("subdivision_id" ));
			}
				response.getWriter().println("<select>");
				for(int i=0;i<arr.size();i++)
				{
					response.getWriter().println("<option value="+arr1.get(i)+">"+arr.get(i)+"</option>");
				}
				response.getWriter().print("</select>");
			
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
