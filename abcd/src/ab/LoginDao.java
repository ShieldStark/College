package ab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
	public static boolean validate(LoginBean bean){  
		boolean status=false;  
		try{  
			Cnnt con= new Cnnt();  
		              
		PreparedStatement ps=con.getDbConnection().prepareStatement( "select * from login where email=? and pass=?");  
		  
		ps.setString(1,bean.getEmail());  
		ps.setString(2, bean.getPass());  
		              
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		              
		}catch(Exception e){}  
		  
		return status;  
		  
		}  

}
