package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarInfraRepository implements CarRepository {

    private final CarSpringDataJPARepository carSpringDataJPARepository;

    @Override
    public Cars salva(Cars cars) {
        log.info("[start] CarInfraRepository - salva");
        try {
            carSpringDataJPARepository.save(cars);
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
        }
        log.info("[finish] CarInfraRepository - salva");
        return cars;
    }

    @Override
    public Cars buscaCarAtravesId(UUID id) {
        log.info("[start] CarInfraRepository - salva");
        Cars car = carSpringDataJPARepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Carro não encontrado !")) ;
        log.info("[finish] CarInfraRepository - salva");
        return car;
    }

    @Override
    public void deletaCarAtravesId(Cars car) {
        log.info("[start] CarInfraRepository - salva");
        carSpringDataJPARepository.delete(car);
        log.info("[finish] CarInfraRepository - salva");
        
    }

    @Override
    public List<Cars> buscaTodasCars() {
        log.info("[start] CarInfraRepository - salva");
        List<Cars> todasCars = carSpringDataJPARepository.findAll();
        log.info("[finish] CarInfraRepository - salva");
        return todasCars;
    }

}
