package hr.king.springbootakademija2023.mapper;

import hr.king.springbootakademija2023.dto.FlightSearchResultDto;
import hr.king.springbootakademija2023.model.FlightSearchResultEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightSearchResultDtoFlightSearchResultEntityMapper {


    public FlightSearchResultEntity map(FlightSearchResultDto flightSearchResultDto){
        if(flightSearchResultDto == null){
            return null;
        }

        FlightSearchResultEntity flightSearchResultEntity = new FlightSearchResultEntity();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(flightSearchResultDto, flightSearchResultEntity);

        return flightSearchResultEntity;
    }
}
