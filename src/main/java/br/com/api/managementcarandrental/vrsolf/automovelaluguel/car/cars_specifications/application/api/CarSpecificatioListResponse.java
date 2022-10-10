package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain.CarSpecifications;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.domain.Specification;
import lombok.Value;

@Value
public class CarSpecificatioListResponse {

    private UUID id;
    private Cars car;
    private Specification specification;
    
    public static List<CarSpecificatioListResponse> converte(List<CarSpecifications> carSpecifications) {
       
        return carSpecifications.stream()
                .map(CarSpecificatioListResponse::new)
                .collect(Collectors.toList());
    }

    public CarSpecificatioListResponse(CarSpecifications carSpecifications) {
        this.id = carSpecifications.getId();
        this.car = carSpecifications.getCar();
        this.specification = carSpecifications.getSpecification();
    }

}
