package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationListResponse;

@RestController
@RequestMapping("/v1/car-specifications")
public interface CarSpecificationAPI {

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    CarSpecificationDetalhadoResponse getCarSpecificationAtravesId(@PathVariable UUID id);
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<CarSpecificatioListResponse> getTodasCarSpecification();
    
}
