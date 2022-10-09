package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository.CarRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
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

}
