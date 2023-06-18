package hr.king.springbootakademija2023.mapper;

import com.amadeus.resources.Location;
import hr.king.springbootakademija2023.dto.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationLocationDtoMapper {


    public LocationDto map(Location location){

        if(location == null) {
            return null;
        }

        LocationDto locationDto = new LocationDto();
        locationDto.setName(location.getName());
        locationDto.setIataCode(location.getIataCode());
        locationDto.setDetailedName(location.getDetailedName());

        return locationDto;
    }
}
