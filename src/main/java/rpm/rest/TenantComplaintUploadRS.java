package rpm.rest;



import java.net.URI;
import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import rpm.json.TenantComUploadJson;
import rpm.relations.Tenant;
import rpm.services.AddTenantComplaintsServices;
import rpm.services.GetTenantComplaintsServices;
import rpm.services.TenantServices;

@Path("/tenantforms")
public class TenantComplaintUploadRS {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.TEXT_PLAIN})
    public String  getTenantInJSON(TenantComUploadJson tcuj) {
    	AddTenantComplaintsServices tcu = new AddTenantComplaintsServices();
    	System.out.println("fname>>>>>"+tcuj.fname);
    	System.out.println("lname>>>>>"+tcuj.lname);
    	System.out.println("type>>>>>"+tcuj.type);
    	System.out.println("desc>>>>>"+tcuj.desc);
    	String val=tcu.addComplaints(tcuj.fname, tcuj.lname, tcuj.type, tcuj.desc);
    	System.out.println(val);
    	return val;
    }
    
	/*@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    
    public Response   getTenantInJSON(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("type") String type,
    		@FormParam("desc") String desc ) {
    	TenantComplaintsServices tcu = new TenantComplaintsServices();
    	System.out.println("fname>>>>>"+fname);
    	System.out.println("lname>>>>>"+lname);
    	System.out.println("type>>>>>"+type);
    	System.out.println("desc>>>>>"+desc);
        tcu.addComplaints(fname, lname, type, desc);
//        /return Response.created(URI.create("/messages/" + String.valueOf(UUID.randomUUID()))).build();
        		 return	Response.created(URI.create("/Tenant.html" )).build();
    }*/
}
