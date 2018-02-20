package rpm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import rpm.relations.RaiseComplaints;
import rpm.relations.Tenant;

public class GetTenantComplaintsServices {

	String first_name=null;
	String last_name=null;
	
	public ArrayList<RaiseComplaints> getComplaints(String fname,String lname)
	{
		
	        ArrayList<RaiseComplaints> array = new ArrayList<RaiseComplaints>();
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
	        	
	        	PreparedStatement stmt=conn.prepareStatement("select * from F17_T09_RAISES_COMPLAINTS where Tenant_id=(select t_id from F17_T09_TENANT where first_name='"+first_name+"' and last_name='"+last_name+"')");	
				ResultSet r=stmt.executeQuery();
				
				while(r.next()){
					flag=1;
					RaiseComplaints rc=new RaiseComplaints();
					
					rc.setType(r.getString(3));
					rc.setStatus(r.getString(4));
					rc.setDescription(r.getString(5));
					rc.setRaised_date(r.getString(6));
					rc.setCompletion_date(r.getString(7));
					array.add(rc);
				}
	        	if(flag==0)
	        		return null;
				  	
				
				
			}
			catch(Exception e)
			{
				flag=2;
			e.printStackTrace();
				
			}
			finally
			{
				if(flag==2)
				return null;
				else
					return array;
			}
	        
	       
	    
	}
}
