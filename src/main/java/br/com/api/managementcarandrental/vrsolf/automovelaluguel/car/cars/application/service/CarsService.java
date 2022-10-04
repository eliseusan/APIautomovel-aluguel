package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsResponse;

public interface CarsService {

    CarsResponse criaCar(UUID brand_id, UUID categories_id, @Valid CarsRequest carsRequest);
    List<CarsListResponse> buscaTodosCars();
    CarDetalhadoResponse buscaCarAtravesId(UUID id);
    void deletaCarAtravesId(UUID id);



}
