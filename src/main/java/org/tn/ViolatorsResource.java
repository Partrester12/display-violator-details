package org.tn;


import org.tn.service.violatorDetailsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Class that acts as the endpoint of our backend
 *
 * Contains a single response to GET requests made to the address
 *
 * When a GET request is made, we return a JSON-file containing all necessary data on those who've violated the safe space around the bird-nest
 */
@Path("/violators")
public class ViolatorsResource {

    @Inject
    violatorDetailsService violatorService;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        return Response.ok(violatorService.getViolatorDetailsList()).build();
    }
}