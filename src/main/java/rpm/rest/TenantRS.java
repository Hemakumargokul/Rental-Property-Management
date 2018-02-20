package rpm.rest;



import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rpm.relations.Tenant;
import rpm.services.TenantServices;

@Path("/tenants")
public class TenantRS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Tenant> getDefaultUserInJSON() {
        TenantServices tenantService = new TenantServices();
        return tenantService.getTenants();
    }
}
