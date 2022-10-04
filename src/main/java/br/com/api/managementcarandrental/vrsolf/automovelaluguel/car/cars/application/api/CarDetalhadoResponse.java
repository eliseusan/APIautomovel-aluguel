package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import lombok.Value;

@Value
public class CarDetalhadoResponse {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal daily_rate;
    private Double avaliable;
    private String license_plate;
    private String color;
    private UUID brand_id ;
    private UUID categories_id ;

    public CarDetalhadoResponse(Cars cars) {
        this.id = cars.getId();
        this.name = cars.getName();
        this.description = cars.getDescription();
        this.daily_rate = cars.getDaily_rate();
        this.avaliable = cars.getAvaliable();
        this.license_plate = cars.getLicense_plate();
        this.brand_id = cars.getBrand_id();
        this.categories_id = cars.getCategories_id();
        this.color = cars.getColor();
    }
}
