package hr.king.springbootakademija2023.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pretrage_letova")
public class FlightSearchEntity extends BasicEntity{

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sifra_polazista")
    private String originLocationCode;
    @Column(name = "sifra_odredista")
    private String destinationLocationCode;
    @Column(name = "datum_odlazka")
    private LocalDate departureDate;
    @Column(name = "datum_povratka")
    private LocalDate returnDate;
    @Column(name = "broj_odraslih")
    private Integer adults;

    @OneToMany(mappedBy = "flightSearchEntity")
    private List<FlightSearchResultEntity> flightSearchResultEntities;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public List<FlightSearchResultEntity> getFlightSearchResultEntities() {
        return flightSearchResultEntities;
    }

    public void setFlightSearchResultEntities(List<FlightSearchResultEntity> flightSearchResultEntities) {
        this.flightSearchResultEntities = flightSearchResultEntities;
    }
}
