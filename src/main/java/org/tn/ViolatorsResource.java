package org.tn;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.tn.model.Report;
import org.tn.model.violatorDetails;
import org.tn.model.droneOwnerDetails;
import org.tn.proxy.droneOwnerDetailsProxy;
import org.tn.proxy.reportProxy;
import org.tn.service.violatorDetailsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Path("/violators")
public class ViolatorsResource {

    @RestClient
    reportProxy rProxy;

    @RestClient
    droneOwnerDetailsProxy droneProxy;

    @Inject
    violatorDetailsService violatorService;

    /**
     * Main function of the backend.
     *
     * When a GET-request is made, we first use a proxy to get the XML-file containing information on the drones near the nest.
     * Then we check the drones that have been found to be too close to the nest, we use another proxy to get the JSON-file containing additional information on the owner of the drone
     * Then we create appropriate objects based on the information and utilize a HashMap to link the serial number to the information we've gotten.
     *
     */
    @Operation(summary = "", description = "")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Report drones = rProxy.get();
        XMLGregorianCalendar snapshot = drones.getCapture().getSnapshotTimestamp();
        //Using a HashMap so that we don't need to iterate over and over again when checking if a given serial number is already in use
        HashMap<String, violatorDetails> search = violatorService.getSerialnumberViolatorMap();


        //Iterate through all the drones that have been captured by the device
        for(Report.Capture.Drone x:drones.getCapture().getDrone()){
            float i = x.getPositionX();
            float j = x.getPositionY();
            //Calculate distance in a two-dimensional space using the Euclidean norm
            double distanceFromNest = Math.sqrt(Math.pow(i-250000, 2)+Math.pow(j-250000, 2));

            // Check if the drone has flown too close to the nest
            if(distanceFromNest<100000){
                //If the drone has been seen before, update the relevant data
                if(search.containsKey(x.getSerialNumber())){
                    (search.get(x.getSerialNumber())).setLastSeen(snapshot);
                    //Update closest confirmed distance to the nest if necessary
                    if(distanceFromNest < search.get(x.getSerialNumber()).getClosestDistance()){
                        search.get(x.getSerialNumber()).setClosestDistance(distanceFromNest);
                    }
                    //If the drone is not currently on the list of violators, create an entry containing the relevant data
                } else {
                    //Try-catch block comes in handy in the rare case where no information about the drone owner can be received from the device
                    try {
                        droneOwnerDetails owner = droneProxy.get(x.getSerialNumber());
                        violatorDetails violator = new violatorDetails(distanceFromNest, snapshot, owner.getFirstName()+" "+owner.getLastName(), owner.getEmail(), owner.getPhoneNumber());
                        search.put(x.getSerialNumber(), violator);
                    } catch(NotFoundException nfe){
                        violatorDetails violator = new violatorDetails(distanceFromNest, snapshot);
                        search.put(x.getSerialNumber(), violator);
                    }
                }
            }
        }

        //Pruning entries from the list of violators if it's been over 10 minutes since they've been seen
        //Also creating a list based on the violators that we will later return as JSON in response to the GET-request made to teh backend
        List<violatorDetails> sortByTime = new ArrayList<>(search.values());
        sortByTime.sort((o1, o2) -> o1.getLastSeen().compare(o2.getLastSeen()));
        while(search.size()>0){
            //Switching formats from XMLGregorian to Gregorian to ZDT to Instant in order to be able to deduce if it's been 10 or more minutes between time last seen and current time of device capture
            if(ChronoUnit.MINUTES.between(sortByTime.get(0).getLastSeen().toGregorianCalendar().toZonedDateTime().toInstant(), snapshot.toGregorianCalendar().toZonedDateTime().toInstant())>9){
                search.values().remove(sortByTime.get(0));
                sortByTime.remove(0);
            } else {
                break;
            }
        }

        //Update HashMap before responding to teh GET-request
        violatorService.setSerialnumberViolatorMap(search);


        return Response.ok(sortByTime).build();
    }
}