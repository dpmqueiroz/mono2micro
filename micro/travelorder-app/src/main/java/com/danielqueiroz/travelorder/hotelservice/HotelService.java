package com.danielqueiroz.travelorder.hotelservice;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8082/hotel")
public interface HotelService {

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findById(@QueryParam("id") Long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel newHotel(Hotel hotel);

}
