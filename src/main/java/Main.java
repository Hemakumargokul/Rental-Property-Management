
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import rpm.services.TenantServices;

public class Main {
	public static void main(String[] args)
	{
		
		
		TenantServices t=new TenantServices();
		t.getTenants();
		System.out.println(t.getTenants());
	}
}
