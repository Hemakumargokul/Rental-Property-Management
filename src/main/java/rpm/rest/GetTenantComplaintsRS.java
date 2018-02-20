package rpm.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rpm.json.TenantComUploadJson;
import rpm.relations.RaiseComplaints;
import rpm.relations.Tenant;
import rpm.services.GetTenantComplaintsServices;
import rpm.services.TenantServices;

@Path("/getcomplaints")
public class GetTenantComplaintsRS {
	
	TenantComUploadJson tcu=null;
		 	
			@GET
			@Consumes(MediaType.APPLICATION_JSON)
		    @Produces(MediaType.APPLICATION_JSON)
			@Path("/{fname}/{lname}")
		 public ArrayList<RaiseComplaints> postDefaultUserInJSON(@PathParam("fname") String fname,@PathParam("lname") String lname) {
	        GetTenantComplaintsServices gtcrs = new GetTenantComplaintsServices();
	        System.out.println(fname); 	
	        return gtcrs.getComplaints(fname,lname);
		 	}
		 	/* @GET
			 @Produces({MediaType.APPLICATION_JSON})
			 	 public ArrayList<RaiseComplaints> getDefaultUserInJSON() {
				        GetTenantComplaintsServices gtcrs = new GetTenantComplaintsServices();
				        return gtcrs.getComplaints(tcu.fname, tcu.lname);	    }	
		 	*/
		 	
}
