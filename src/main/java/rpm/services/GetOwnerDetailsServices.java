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
import rpm.relations.Owner;
import rpm.relations.Tenant;


public class GetOwnerDetailsServices {


    public ArrayList getOwnerDetails() {
        ArrayList<Owner> array = new ArrayList<Owner>();
        
        
        
        try{  
        	Context initContext = new InitialContext();
        	Context envContext  = (Context)initContext.lookup("java:/comp/env");
        	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
        	Connection conn = ds.getConnection();
			
			//step3 create the statement object  
			PreparedStatement stmt=conn.prepareStatement("Select Unique First_Name, o.Last_Name,ap.Name,o.Phone_No,o.city,o.state,o.postal_code from F17_T09_OWNER  o inner join F17_T09_APT_COMPLEX ap on o.O_ID= ap.Owner_ID");
        	//PreparedStatement stmt=conn.prepareStatement("Select * from F17_T09_Employee);
        	ResultSet r=stmt.executeQuery();
			
			while(r.next())
			{
				Owner ow=new Owner();
				
				ow.setFname(r.getString(1));
				ow.setLname(r.getString(2));
				ow.setcName(r.getString(3));
				ow.setPh_no(r.getString(4));
				ow.setCity(r.getString(5));
				ow.setState(r.getString(6));
				ow.setPostal_code(r.getString(7));
				
				
				array.add(ow);
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

