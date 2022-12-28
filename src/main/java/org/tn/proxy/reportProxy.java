package org.tn.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.tn.model.Report;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_XML)
@RegisterRestClient
public interface reportProxy {
    @GET
    Report get();
}
