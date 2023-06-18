package hr.king.springbootakademija2023.repository;

import hr.king.springbootakademija2023.model.FlightSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FlightSearchEntityRepository extends JpaRepository<FlightSearchEntity, Integer> {

    FlightSearchEntity
    findOneByOriginLocationCodeAndDestinationLocationCodeAndDepartureDateAndReturnDateAndAdults
            (
                    String originLocationCode,
                    String destinationLocationCode,
                    LocalDate departureDate,
                    LocalDate returnDate,
                    Integer adults
            );
}
