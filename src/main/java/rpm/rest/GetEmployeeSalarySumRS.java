package rpm.rest;



import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rpm.relations.EmployeeSalary;
import rpm.relations.Tenant;
import rpm.services.GetEmployeeSalaryServices;
import rpm.services.TenantServices;

@Path("/employeeSalary")
public class GetEmployeeSalarySumRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<EmployeeSalary> getEmployeeSalarySum() {
        GetEmployeeSalaryServices gess = new GetEmployeeSalaryServices();
        return gess.getSalarySum();
    }
}
