package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarsRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarsInfraRepository implements CarsRepository {

    private final CarsSpringDataJPARepository carsSpringDataJPARepository;

    @Override
    public Cars salvaCar(Cars cars) {
        log.info("[start] CarsInfraRepository - salvaCar");
        carsSpringDataJPARepository.save(cars);
        log.info("[finish] CarsInfraRepository - salvaCar");
        return cars;
     
    }

    @Override
    public List<Cars> buscaTodosCars() {
        log.info("[start] BrandInfraRepository - buscaTodosCars");
        List<Cars> todosCars = carsSpringDataJPARepository.findAll();
        log.info("[finish] BrandInfraRepository - buscaTodosCars");
        return todosCars;
    }
}
