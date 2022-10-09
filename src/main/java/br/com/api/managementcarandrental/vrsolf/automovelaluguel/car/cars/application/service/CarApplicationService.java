package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.repository.BrandRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.repository.CategoriesRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarApplicationService implements CarService {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private CategoriesRepository categoriesRepository;
    @Override
    public CarResponse criaCar(@Valid CarRequest carRequest) {
        log.info("[start] BrandApplicationService - criaBrand ");
        Brand brand = brandRepository.buscaBrandAtravesId(carRequest
                .getBrand()
                .getId());
        Categories categories = categoriesRepository.buscaCategoriesAtravesId(carRequest
                .getCategories()
                .getId());
        Cars car = carRepository.salva(new Cars(carRequest));
        log.info("[finish] BrandApplicationService - criaBrand ");
        return CarResponse.builder()
                .id(car.getId())
                .build();
    }
}
