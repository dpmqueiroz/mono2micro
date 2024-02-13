package com.danielqueiroz.travelorder.health;

import com.danielqueiroz.travelorder.flightservice.FlightService;
import com.danielqueiroz.travelorder.hotelservice.HotelService;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Inject
    @RestClient
    FlightService flightService;

    @Inject
    @RestClient
    HotelService hotelService;

    @Override
    public HealthCheckResponse call() {
        if( flightService.findById(1) != null && (hotelService.findById(1L) != null )){
            return HealthCheckResponse.up("Estou pronto");
        }
        return HealthCheckResponse.down("Não Estou pronto");
    }
}
