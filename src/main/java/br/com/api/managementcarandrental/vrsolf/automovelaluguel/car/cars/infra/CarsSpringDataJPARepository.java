package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;

public interface CarsSpringDataJPARepository extends JpaRepository<Cars, UUID> {

}
