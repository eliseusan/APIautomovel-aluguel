package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain.CarSpecifications;

public interface CarSpecificationsSpringDataJPARepository extends JpaRepository<CarSpecifications, UUID>{

}
