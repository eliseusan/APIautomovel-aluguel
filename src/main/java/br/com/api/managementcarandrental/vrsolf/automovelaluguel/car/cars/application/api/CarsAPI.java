package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandResponse;

@RestController
@RequestMapping("/v1/cars")
public interface CarsAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarResponse postCar(@Valid @RequestBody CarRequest carRequest);
}
