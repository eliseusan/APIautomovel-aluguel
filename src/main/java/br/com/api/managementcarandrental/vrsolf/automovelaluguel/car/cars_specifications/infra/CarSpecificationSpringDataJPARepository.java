package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.repository.CarSpecificationRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain.CarSpecifications;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarSpecificationSpringDataJPARepository implements CarSpecificationRepository {

    private final CarSpecificationsSpringDataJPARepository carSpecificationsSpringDataJPARepository;

    @Override
    public CarSpecifications buscaCarSpecificationAtravesId(UUID id) {
        log.info("[start] CarSpecificationSpringDataJPARepository - buscaCarSpecificationAtravesId");
        CarSpecifications carSpecifications = carSpecificationsSpringDataJPARepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "CarSpecification não encontrado !"));
        log.info("[finish] CarSpecificationSpringDataJPARepository - buscaCarSpecificationAtravesId");
        return carSpecifications;
    }

    @Override
    public List<CarSpecifications> buscaTodasCarSpecification() {
        log.info("[start] CarSpecificationSpringDataJPARepository - buscaTodasCarSpecification");
        List<CarSpecifications> todosCarSpecifications = carSpecificationsSpringDataJPARepository.findAll();
        log.info("[finish] CarSpecificationSpringDataJPARepository - buscaTodasCarSpecification");
        return todosCarSpecifications;
    }

}
