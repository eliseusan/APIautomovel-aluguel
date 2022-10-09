package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service.CarService;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesDetalhadoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CarController implements CarsAPI {

    private final CarService carService;

    @Override
    public CarResponse postCar(@Valid CarRequest carRequest) {
        log.info("[start] CarController - postCar");
        CarResponse carCriado = carService.criaCar(carRequest);
        log.info("[finish] CarController - postCar");
        return carCriado;
    }

    @Override
    public CarDetalhadoResponse buscaCarAtravesId(UUID id) {
        log.info("[start] CarController - buscaCarAtravesId");
        log.info("[idCar] {}", id);
        CarDetalhadoResponse carDetalhado = carService.buscaCarAtravesId(id);
        log.info("[finish] CarController - buscaCarAtravesId");
        return carDetalhado;
    }

    @Override
    public void deletaCarAtravesId(UUID id) {
        log.info("[start] CarController - deletaCarAtravesId");
        log.info("[idBrand] {}", id);
        carService.deletaCarAtravesId(id);
        log.info("[finish] CarController - deletaCarAtravesId");
    }

    @Override
    public void patchAlteraCar(UUID id, @Valid CarAlteracaoRequest carAlteracaoRequest) {
        log.info("[start] CarController - patchAlteraCar");
        log.info("[idBrand] {}", id);
        carService.patchAlteraCar(id, carAlteracaoRequest);
        log.info("[start] CarController - patchAlteraCar");
        
    }

}
