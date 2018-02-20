package rpm.rest;



import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rpm.relations.EmployeeSalary;
import rpm.relations.LeaseExpiry;
import rpm.relations.Owner;
import rpm.services.GetEmployeeSalaryServices;
import rpm.services.GetLeaseExpiryServices;
import rpm.services.GetOwnerDetailsServices;
import rpm.services.TenantServices;

@Path("/owner")
public class GetOwnerDetailsRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Owner> getOwnerDetails() {
    	GetOwnerDetailsServices gs  = new GetOwnerDetailsServices();
        return gs.getOwnerDetails();
    }
}
