package rpm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import rpm.relations.EmployeeSalary;
import rpm.relations.LeaseExpiry;
import rpm.relations.Tenant;


public class GetLeaseExpiryServices {


    public ArrayList getLeaseExpiry() {
        ArrayList<LeaseExpiry> array = new ArrayList<LeaseExpiry>();
        
        
        
        try{  
        	Context initContext = new InitialContext();
        	Context envContext  = (Context)initContext.lookup("java:/comp/env");
        	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
        	Connection conn = ds.getConnection();
			
			//step3 create the statement object  
			PreparedStatement stmt=conn.prepareStatement("Select First_Name, Last_NAME,SSN,trim(l.start_date),trim(l.end_date) from F17_T09_TENANT ,(select Tenant_ID,start_date,end_date from F17_T09_Leases_Details where ((end_date - sysdate) <= 30) and ((end_date - sysdate) >= 1))  l where T_ID=l.Tenant_ID");
        	//PreparedStatement stmt=conn.prepareStatement("Select * from F17_T09_Employee);
        	ResultSet r=stmt.executeQuery();
			
			while(r.next())
			{
				LeaseExpiry ls=new LeaseExpiry();
				
				
				ls.setFname(r.getString(1));
				ls.setLname(r.getString(2));
				ls.setSSN(r.getString(3));
				ls.setStart_date(r.getString(4));
				ls.setEnd_date(r.getString(5));
				array.add(ls);
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

