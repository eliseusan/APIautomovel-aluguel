package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarResponse;

public interface CarService {

    CarResponse criaCar(@Valid CarRequest carRequest);

    CarDetalhadoResponse buscaCarAtravesId(UUID id);

    void deletaCarAtravesId(UUID id);

    void patchAlteraCar(UUID id, @Valid CarAlteracaoRequest carAlteracaoRequest);

    List<CarListResponse> buscaTodosCars();
}
