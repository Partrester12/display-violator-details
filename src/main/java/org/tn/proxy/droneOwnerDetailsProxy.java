package org.tn.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.tn.model.droneOwnerDetails;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Interface that's used as a proxy to fetch data on specific drone users
 */
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface droneOwnerDetailsProxy {
    @GET
    @Path("/{serialNumber}")
    droneOwnerDetails get(@PathParam("serialNumber") String s);
}
