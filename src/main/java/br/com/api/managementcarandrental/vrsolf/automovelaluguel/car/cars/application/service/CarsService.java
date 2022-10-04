package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import java.util.UUID;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsResponse;

public interface CarsService {

    CarsResponse criaCar(UUID brand_id, UUID categories_id, @Valid CarsRequest carsRequest);



}
