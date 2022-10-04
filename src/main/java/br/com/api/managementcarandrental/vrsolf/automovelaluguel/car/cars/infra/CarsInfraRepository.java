package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarsRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
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
        log.info("[start] CarsInfraRepository - buscaTodosCars");
        List<Cars> todosCars = carsSpringDataJPARepository.findAll();
        log.info("[finish] CarsInfraRepository - buscaTodosCars");
        return todosCars;
    }

    @Override
    public Cars buscaCarAtravesId(UUID id) {
        log.info("[start] CarsInfraRepository - buscaCarAtravesId");
        Cars car = carsSpringDataJPARepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado !")) ;
        log.info("[finish] CarsInfraRepository - buscaCarAtravesId");
        return car;
    }
}
