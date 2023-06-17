package hr.king.springbootakademija2023.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.Location;
import hr.king.springbootakademija2023.dto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

@Service
public class AmadeusService {

    @Autowired
    private Amadeus amadeus;


    public List<Location> getLocation(String keyword) throws ResponseException {

        LocationDto locationDto = new LocationDto();

        return Arrays.asList(amadeus.referenceData.locations
                .get(Params.with("subType", Locations.AIRPORT).and("keyword", keyword)));
    }
}
