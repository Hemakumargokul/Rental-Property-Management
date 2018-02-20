package rpm.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import rpm.relations.Tenant;

public class TenantServices {


	    public ArrayList getTenants() {
	        ArrayList<Tenant> array = new ArrayList<Tenant>();
	        
	        
	        
	        try{  
	        	Context initContext = new InitialContext();
	        	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	        	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	        	Connection conn = ds.getConnection();
				
				//step3 create the statement object  
				PreparedStatement stmt=conn.prepareStatement("select * from F17_T09_TENANT");
				ResultSet r=stmt.executeQuery();
				
				while(r.next())
				{
					Tenant tenant=new Tenant();
					tenant.setT_id(r.getLong(1));
					tenant.setSsn(r.getLong(2));
					tenant.setEmail(r.getString(3));
					tenant.setFirst_name(r.getString(4));
					tenant.setLast_name(r.getString(5));
					tenant.setOccupation(r.getString(6));
					tenant.setPhone_no(r.getString(7));
					tenant.settBranchID(r.getString(8));
					
					array.add(tenant);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				return array;
			}
	        
	               
	    }
	}

