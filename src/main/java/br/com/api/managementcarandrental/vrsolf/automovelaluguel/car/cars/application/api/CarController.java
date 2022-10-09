package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service.CarService;
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

}
