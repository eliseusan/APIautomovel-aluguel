package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarResponse;

public interface CarService {

    CarResponse criaCar(@Valid CarRequest carRequest);
}
