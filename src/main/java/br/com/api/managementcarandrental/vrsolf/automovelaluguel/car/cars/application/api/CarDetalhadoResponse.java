package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
import lombok.Value;

@Value
public class CarDetalhadoResponse {

    
    private String name;
    private String description;
    private Double daily_rate;
    private String avaliable;
    private String license_plate;
    private Brand brand;
    private Categories categories;
    private String color;

    public CarDetalhadoResponse(Cars cars) {
        this.name = cars.getName();
        this.description = cars.getDescription();
        this.daily_rate = cars.getDaily_rate();
        this.avaliable = cars.getAvaliable();
        this.license_plate = cars.getLicense_plate();
        this.brand = cars.getBrand();
        this.categories = cars.getCategories();
        this.color = cars.getColor();
    }
}
