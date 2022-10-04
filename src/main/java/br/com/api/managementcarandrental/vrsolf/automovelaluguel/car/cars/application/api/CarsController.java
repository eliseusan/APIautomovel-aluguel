package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.service.CarsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CarsController implements CarsAPI {

    private final CarsService carsService;

    @Override
    public CarsResponse postCar(UUID brand_id, UUID categories_id, @Valid CarsRequest carsRequest) {
        log.info("[start] CarsController - postCar");
        log.info("[idBrand] {}", brand_id);
        log.info("[idCategories] {}", categories_id);
        CarsResponse car = carsService.criaCar(brand_id,categories_id,carsRequest);
        log.info("[finish] CarsController - postCar");
        return car;
        
    }

    @Override
    public List<CarsListResponse> getCarComId() {
        log.info("[start] CarsController - getCarComId");
        List<CarsListResponse> cars = carsService.buscaTodosCars();
        log.info("[finish] CarsController - getCarComId");
        return cars;
    }

    @Override
    public CarDetalhadoResponse getCarAtravesId(UUID id) {
        log.info("[start] CarsController - getCarComId");
        log.info("[idBrand] {}", id);
        CarDetalhadoResponse carDetalhado = carsService.buscaCarAtravesId(id);
        log.info("[start] CarsController - getCarComId");
        return carDetalhado;
    }

    
}
