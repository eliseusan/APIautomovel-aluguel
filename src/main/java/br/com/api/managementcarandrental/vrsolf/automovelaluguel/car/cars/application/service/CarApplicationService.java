package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarApplicationService implements CarService {

    private final CarRepository carRepository;
//    private final BrandRepository brandRepository;
//    private CategoriesRepository categoriesRepository;
    @Override
    public CarResponse criaCar(@Valid CarRequest carRequest) {
        log.info("[start] BrandApplicationService - criaBrand ");
        Cars car = carRepository.salva(new Cars(carRequest));
        log.info("[finish] BrandApplicationService - criaBrand ");
        return CarResponse.builder()
                .id(car.getId())
                .build();
    }
    @Override
    public CarDetalhadoResponse buscaCarAtravesId(UUID id) {
        log.info("[start] BrandApplicationService - buscaCarAtravesId ");
        Cars car = carRepository.buscaCarAtravesId(id);
        log.info("[finish] BrandApplicationService - buscaCarAtravesId ");
        return new CarDetalhadoResponse(car);
    }
    @Override
    public void deletaCarAtravesId(UUID id) {
        log.info("[start] BrandApplicationService - deletaCarAtravesId ");
        Cars car = carRepository.buscaCarAtravesId(id);
        carRepository.deletaCarAtravesId(car);
        log.info("[finish] BrandApplicationService - deletaCarAtravesId ");
        
    }
}
