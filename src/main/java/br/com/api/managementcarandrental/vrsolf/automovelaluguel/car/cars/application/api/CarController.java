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
        log.info("[idBrand] {}", id);
        CarDetalhadoResponse carDetalhado = carService.buscaCarAtravesId(id);
        log.info("[start] CarController - buscaCarAtravesId");
        return carDetalhado;
    }

}
