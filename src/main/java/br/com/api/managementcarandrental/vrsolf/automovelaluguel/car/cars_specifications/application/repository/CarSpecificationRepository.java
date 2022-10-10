package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain.CarSpecifications;

public interface CarSpecificationRepository {

    CarSpecifications buscaCarSpecificationAtravesId(UUID id);

    List<CarSpecifications> buscaTodasCarSpecification();

}
