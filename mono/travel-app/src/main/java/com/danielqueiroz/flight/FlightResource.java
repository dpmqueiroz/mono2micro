package com.danielqueiroz.flight;

import com.danielqueiroz.hotel.Hotel;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("flight")
public class FlightResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> flights(){
        return Flight.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findById(@QueryParam("id") long id){
        return Flight.findById(id);
    }

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId){

        return Flight.findByTravelOrderId(travelOrderId);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Flight newFlight(Flight flight){
        flight.id = null;
        flight.persist();
        return flight;
    }
}
