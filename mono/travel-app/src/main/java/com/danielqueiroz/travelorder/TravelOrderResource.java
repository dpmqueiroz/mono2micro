package com.danielqueiroz.travelorder;

import com.danielqueiroz.flight.Flight;
import com.danielqueiroz.flight.FlightResource;
import com.danielqueiroz.hotel.Hotel;
import com.danielqueiroz.hotel.HotelResource;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("travelorder")
public class TravelOrderResource {

    @Inject
    FlightResource flightResource;

    @Inject
    HotelResource hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders(){

        return TravelOrder.<TravelOrder>listAll().stream()
                .map(
                        order -> TravelOrderDTO.of(
                                order,
                                flightResource.findByTravelOrderId(order.id),
                                hotelResource.findByTravelOrderId(order.id)
                        )
                ).collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    public TravelOrder findById(@QueryParam("id") long id){
        return TravelOrder.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder(TravelOrderDTO orderDTO){

        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.id = null;
        flight.fromAirport = orderDTO.getFromAirport();
        flight.toAirport = orderDTO.getToAirport();
        flight.travelOrderId = order.id;
        flightResource.newFlight(flight);


        Hotel hotel = new Hotel();
        hotel.id = null;
        hotel.nights = orderDTO.getNights();
        hotel.travelOrderId = order.id;
        hotelResource.newHotel(hotel);

        return order;
    }
}
