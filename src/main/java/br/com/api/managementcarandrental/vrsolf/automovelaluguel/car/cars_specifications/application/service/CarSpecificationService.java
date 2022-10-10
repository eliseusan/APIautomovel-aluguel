package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.service;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api.CarSpecificatioListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api.CarSpecificationDetalhadoResponse;

public interface CarSpecificationService {

    CarSpecificationDetalhadoResponse buscaCarSpecificationAtravesId(UUID id);

    List<CarSpecificatioListResponse> getTodasCarSpecification();

}
