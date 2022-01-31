package ab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Signindao 
{
	String sql="select email,password from login where email=? and password=?";
	public boolean check(String uname,String pass)
	{
		try 
		{
		Cnnt con= new Cnnt(); 
		 PreparedStatement st=con.getDbConnection().prepareStatement(sql);
		 st.setString(1, uname);
		 st.setString(2, pass);
		 ResultSet rs=st.executeQuery();
		 System.out.println("result");
		 if(rs.next())
		 {
			 return true;
		 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}


}
