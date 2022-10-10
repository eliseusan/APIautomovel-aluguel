package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain.CarSpecifications;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.domain.Specification;
import lombok.Value;

@Value
public class CarSpecificationDetalhadoResponse {
    private UUID id;
    private Cars car;
    private Specification specification;
    
    public CarSpecificationDetalhadoResponse(CarSpecifications carSpecification) {
        this.id = carSpecification.getId() ;
        this.car = carSpecification.getCar();
        this.specification = carSpecification.getSpecification();
    }

}
