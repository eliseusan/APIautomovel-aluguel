package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/brand/{brand_id}/categories/{categories_id}/cars")
public interface CarsAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarsResponse postCar(@PathVariable UUID brand_id, @PathVariable UUID categories_id,
            @Valid @RequestBody CarsRequest carsRequest);

}
