package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesDetalhadoResponse;

@RestController
@RequestMapping("/v1/cars")
public interface CarsAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarResponse postCar(@Valid @RequestBody CarRequest carRequest);
    
    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    CarDetalhadoResponse buscaCarAtravesId(@PathVariable UUID id);
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaCarAtravesId(@PathVariable UUID id);
    
    @PatchMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraCar(@PathVariable UUID id,
    @Valid @RequestBody CarAlteracaoRequest carAlteracaoRequest);
}
