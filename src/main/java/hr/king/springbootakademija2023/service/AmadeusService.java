package hr.king.springbootakademija2023.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import hr.king.springbootakademija2023.dto.FlightSearchResultDto;
import hr.king.springbootakademija2023.dto.LocationDto;
import hr.king.springbootakademija2023.mapper.FlightOfferSearchFlightSearchResultDtoMapper;
import hr.king.springbootakademija2023.model.FlightSearchEntity;
import hr.king.springbootakademija2023.repository.FlightSearchEntityRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.Param;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

@Service
public class AmadeusService {

    Logger logger = LoggerFactory.getLogger(AmadeusService.class);

    @Autowired
    private FlightOfferSearchFlightSearchResultDtoMapper flightSearchResultDtoMapper;

    @Autowired
    private Amadeus amadeus;

    @Autowired
    private FlightSearchEntityRepository flightSearchEntityRepository;


    public List<Location> searchAirports(String keyword) {

        try {

            Params param = Params
                    .with("subType", Locations.AIRPORT)
                    .and("keyword", keyword);

            return Arrays.asList(amadeus.referenceData.locations
                    .get(param));
        }
        catch (Exception e) {

            logger.error("Search airports error", e);

            return Collections.emptyList();
        }
    }

    @Transactional
    public List<FlightSearchResultDto> searchFlights(String originLocationCode,
                                        String destinationLocationCode,
                                        LocalDate departureDate,
                                        LocalDate returnDate,
                                        Integer adults) {
        try {

            FlightSearchEntity flightSearchEntity = new FlightSearchEntity();
            flightSearchEntity.setOriginLocationCode(originLocationCode);
            flightSearchEntity.setDestinationLocationCode(destinationLocationCode);
            flightSearchEntity.setDepartureDate(departureDate);
            flightSearchEntity.setAdults(adults);
            flightSearchEntity.setReturnDate(returnDate);

            flightSearchEntity.setDateCreated(LocalDate.now());
            flightSearchEntity.setUserCreated("Petar");

            flightSearchEntityRepository.save(flightSearchEntity);

            Params params = Params
                    .with("originLocationCode", originLocationCode)
                    .and("destinationLocationCode", destinationLocationCode)
                    .and("departureDate", departureDate.toString())
                    .and("adults", adults)
                    .and("nonStop", true)
                    .and("max", 5);

            if(returnDate != null){
                params.and("returnDate", returnDate.toString());
            }

            List<FlightOfferSearch> flightOfferSearchList = Arrays.asList
                    (amadeus.shopping.flightOffersSearch.get(params)
                    );


            List<FlightSearchResultDto> flightSearchResultDtoList = flightOfferSearchList.stream()
                    .map(flightOfferSearch -> flightSearchResultDtoMapper.map(flightOfferSearch))
                    .toList();

            return flightSearchResultDtoList;


        } catch (Exception e) {
            logger.error("Search flight error", e);

            return Collections.emptyList();
        }

    }
}
