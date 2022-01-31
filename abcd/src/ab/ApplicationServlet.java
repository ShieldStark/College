package ab;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String company=request.getParameter("company");
		 String circle=request.getParameter("circle");
		 String division=request.getParameter("division");
		 String subdivision=request.getParameter("subdivision");
		 String section=request.getParameter("section");		
		 String title=request.getParameter("title");
		 String name=request.getParameter("name");
		 System.out.println(name);
		 String fname=request.getParameter("faname");
		 String address=request.getParameter("add");
		 String district=request.getParameter("district");
		 String block=request.getParameter("block");
		 String panchayat=request.getParameter("panchayat");
		 String village=request.getParameter("village");
		 String tola=request.getParameter("tola");
		 String id=request.getParameter("id");
		 String rid=request.getParameter("rid");
		 InputStream inputStream = null; 
		 Part filePart = request.getPart("ifile");
		 InputStream inputStream1 = null; 
		 Part filePart1 = request.getPart("rfile");
		 if(filePart != null)
		 {
			 System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            inputStream = filePart.getInputStream();
		 }
		 if(filePart1 != null)
		 {
			 System.out.println(filePart1.getName());
	            System.out.println(filePart1.getSize());
	            System.out.println(filePart1.getContentType());
	            inputStream1 = filePart1.getInputStream();
		 }
		 int count=0;
		 try {
				Cnnt con = new Cnnt();
				java.sql.Statement st = con.getDbConnection().createStatement();
				ResultSet rs = st.executeQuery("select * from registration");
				while (rs.next()) {
					count++;
		         }
			} catch (Exception e) {
				System.out.println(e);
			}
		 System.out.println("name"+name+"\n fther name"+fname+"\n address"+address+"\n district"+district+"\n block"+block+"\n panchayat"+panchayat+"\n village"+village+"\n tola"+tola+"\n id"+id+"\n rid"+rid);
		 try{    
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				java.sql.Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","7972431685");  
				PreparedStatement ps=con.prepareStatement("INSERT INTO registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, count);
				ps.setString(2,company );
				ps.setString(3,circle );
				ps.setString(4,division );
				ps.setString(5,subdivision );
				ps.setString(6,section);
				ps.setString(7,title );
				ps.setString(8,name);
				ps.setString(9,fname);
				ps.setString(10,address);
				ps.setString(11,district);
				ps.setString(12,block);
				ps.setString(13,panchayat);
				ps.setString(14,village);
				ps.setString(15,tola);
				ps.setBlob(16,inputStream);
				ps.setString(17,id);
				ps.setBlob(18,inputStream1);
				ps.setString(19,rid);
				ps.executeUpdate();
				System.out.println("Inserted values in the table application");  
				response.sendRedirect("Thanx.jsp");
				con.close();
				}catch (Exception ex) {
	         System.out.println(ex);
	     }
	}

}
