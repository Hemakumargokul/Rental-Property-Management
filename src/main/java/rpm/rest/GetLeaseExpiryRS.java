package rpm.rest;



import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rpm.relations.EmployeeSalary;
import rpm.relations.LeaseExpiry;
import rpm.relations.Tenant;
import rpm.services.GetEmployeeSalaryServices;
import rpm.services.GetLeaseExpiryServices;
import rpm.services.TenantServices;

@Path("/leaseExpiry")
public class GetLeaseExpiryRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<LeaseExpiry> getLeaseExpiry() {
        GetLeaseExpiryServices gles = new GetLeaseExpiryServices();
        return gles.getLeaseExpiry();
    }
}
