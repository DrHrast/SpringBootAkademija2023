package hr.king.springbootakademija2023.mapper;

import hr.king.springbootakademija2023.dto.FlightSearchResultDto;
import hr.king.springbootakademija2023.model.FlightSearchResultEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightSearchResultEntityFlightSearchResultDtoMapper {

    public FlightSearchResultDto map(FlightSearchResultEntity flightSearchResultEntity) {
        FlightSearchResultDto flightSearchResultDto = new FlightSearchResultDto();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(flightSearchResultEntity, flightSearchResultDto);

        return flightSearchResultDto;
    }
}
