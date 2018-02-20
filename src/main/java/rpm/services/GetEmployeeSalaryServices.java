package rpm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import rpm.relations.EmployeeSalary;
import rpm.relations.Tenant;


public class GetEmployeeSalaryServices {


    public ArrayList getSalarySum() {
        ArrayList<EmployeeSalary> array = new ArrayList<EmployeeSalary>();
        
        
        
        try{  
        	Context initContext = new InitialContext();
        	Context envContext  = (Context)initContext.lookup("java:/comp/env");
        	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
        	Connection conn = ds.getConnection();
			
			//step3 create the statement object  
			PreparedStatement stmt=conn.prepareStatement("Select Decode(Grouping(EBranchID),1, 'ALL', EBranchID) \"BranchID\", Decode(Grouping(Designation),1, 'ALL', Designation) \"Designation\" ,SUM(Salary)  from F17_T09_Employee  group by rollup(EBranchID, Designation) order by EBranchID ");
        	//PreparedStatement stmt=conn.prepareStatement("Select * from F17_T09_Employee);
        	ResultSet r=stmt.executeQuery();
			
			while(r.next())
			{
				EmployeeSalary es=new EmployeeSalary();
				
				
				es.setBranchID(r.getString(1));
				es.setDesignation(r.getString(2));
				es.setSalary(r.getString(3));
				
				array.add(es);
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

