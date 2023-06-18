package hr.king.springbootakademija2023.mapper;

import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.shopping.FlightOffersSearch;
import hr.king.springbootakademija2023.dto.FlightSearchResultDto;
import org.springframework.stereotype.Component;

@Component
public class FlightOfferSearchFlightSearchResultDtoMapper {

    public FlightSearchResultDto map(FlightOfferSearch flightOffersSearch) {

        if(flightOffersSearch == null) {
            return null;
        }

        FlightSearchResultDto flightSearchResultDto = new FlightSearchResultDto();

        FlightOfferSearch.Itinerary outboundItinerary = flightOffersSearch.getItineraries()[0];
        FlightOfferSearch.Itinerary inboundItinerary = flightOffersSearch.getItineraries()[1];

        FlightOfferSearch.SearchSegment firstOutboundSegment = outboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment lastOutboundSegment = outboundItinerary
                .getSegments()[outboundItinerary.getSegments().length - 1];
        FlightOfferSearch.SearchSegment firstInboundSegment = inboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment lastInboundSegment = inboundItinerary
                .getSegments()[inboundItinerary.getSegments().length - 1];


        flightSearchResultDto.setOutboundDepartureAirport(firstOutboundSegment.getDeparture().getIataCode());
        flightSearchResultDto.setOutboundArrivalAirport(lastOutboundSegment.getArrival().getIataCode());
        flightSearchResultDto.setOutboundDepartureDate(firstOutboundSegment.getDeparture().getAt());
        flightSearchResultDto.setOutboundArrivalDate(lastOutboundSegment.getArrival().getAt());

        flightSearchResultDto.setInboundDepartureAirport(firstInboundSegment.getDeparture().getIataCode());
        flightSearchResultDto.setInboundArrivalAirport(lastInboundSegment.getArrival().getIataCode());
        flightSearchResultDto.setInboundDepartureDate(firstInboundSegment.getDeparture().getAt());
        flightSearchResultDto.setInboundArrivalDate(lastInboundSegment.getArrival().getAt());

        flightSearchResultDto.setCarrier(firstOutboundSegment.getCarrierCode());
        flightSearchResultDto.setPrice(flightOffersSearch.getPrice().getTotal());

        return flightSearchResultDto;
    }
}
