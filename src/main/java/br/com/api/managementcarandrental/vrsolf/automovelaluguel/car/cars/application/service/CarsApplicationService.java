package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.service.BrandService;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarsRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarsApplicationService implements CarsService {
    private final BrandService brandService;
    private final CategoriesService categoriesService;
    private final CarsRepository carsRepository;

    @Override
    public CarsResponse criaCar(UUID brand_id, UUID categories_id, @Valid CarsRequest carsRequest) {
        log.info("[inicia] CarsApplicationService - criaCar");
        brandService.buscaBrandAtravesId(brand_id);
        categoriesService.getCategoriesAtravesId(categories_id);
        Cars car = carsRepository.salvaCar(new Cars(brand_id, categories_id, carsRequest));
        log.info("[finaliza] CarsApplicationService - criaCar");
        return new CarsResponse(car.getId()) ;
    }

    @Override
    public List<CarsListResponse> buscaTodosCars() {
        log.info("[start] CarsApplicationService - buscaTodosCars ");
        List<Cars> cars = carsRepository.buscaTodosCars();
        log.info("[finish] CarsApplicationService - buscaTodosCars ");
        return CarsListResponse.converte(cars);
       
    }

    @Override
    public CarDetalhadoResponse buscaCarAtravesId(UUID id) {
        log.info("[start] BrandApplicationService - buscaCarAtravesId ");
        Cars car = carsRepository.buscaCarAtravesId(id);
        log.info("[finish] BrandApplicationService - buscaCarAtravesId ");
        return new CarDetalhadoResponse(car);
    }
    
  
}
