package rpm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import rpm.relations.Tenant;

public class AddTenantComplaintsServices {
	String first_name=null;
	String last_name=null;
	
	public String addComplaints(String fname,String lname,String type,String desc)
	{
 
	ArrayList<Tenant> array = new ArrayList<Tenant>();
     int flag=0;
     
     
     try{  
     	Context initContext = new InitialContext();
     	Context envContext  = (Context)initContext.lookup("java:/comp/env");
     	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
     	Connection conn = ds.getConnection();
     	
     	//pre process the name to camel case 
     	first_name=	fname.toUpperCase().charAt(0)+fname.toLowerCase().substring(1, fname.length());
     	last_name= 	lname.toUpperCase().charAt(0)+lname.toLowerCase().substring(1, lname.length());
			
     	//get the employee SSN who is maintenance staff
     	
     	PreparedStatement stmt=conn.prepareStatement("select SSN from (select tBranchID from F17_T09_TENANT where first_name='"+first_name+"' and last_name='"+last_name+"') l, F17_T09_Employee where l.tBranchID=EBranchID and designation='Maintenance staff'");
			ResultSet r=stmt.executeQuery();
			
			while(r.next()){
				
				flag=1;
				String s="insert into F17_T09_RAISES_COMPLAINTS values((select t_id from F17_T09_TENANT where first_name='"+first_name+"' and last_name='"+last_name+"'),"+r.getLong(1)+",'"+ type+"','Pending','"+desc+"',trunc(sysdate),null)";	
				//step3 create the statement object  
				stmt=conn.prepareStatement(s);
	        	stmt.executeUpdate();
	        	
			}
			System.out.println(flag);
     	
			
			
		}
		catch(Exception e)
		{
			flag=2;
		e.printStackTrace();
			
		}
		finally
		{
			if(flag==2 || flag==0)
			return "201";
			else 
				return "200";
		}
}
}
