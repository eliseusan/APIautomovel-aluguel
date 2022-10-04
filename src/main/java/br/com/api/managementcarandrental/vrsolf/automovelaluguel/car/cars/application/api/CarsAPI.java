package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.util.List;
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

@RestController
@RequestMapping("/v1/cars")
public interface CarsAPI {

    @PostMapping
    @RequestMapping("/brand/{brand_id}/categories/{categories_id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    CarsResponse postCar(@PathVariable UUID brand_id, @PathVariable UUID categories_id,
            @Valid @RequestBody CarsRequest carsRequest);
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<CarsListResponse> getCarComId();

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    CarDetalhadoResponse getCarAtravesId(@PathVariable UUID id);
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaCarAtravesId(@PathVariable UUID id);
    
    @PatchMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraCar(@PathVariable UUID id,
    @Valid @RequestBody CarAlteracaoRequest carAlteracaoRequest);
  
}
