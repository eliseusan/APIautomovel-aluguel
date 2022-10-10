package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api.CarSpecificatioListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api.CarSpecificationDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.repository.CarSpecificationRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain.CarSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarSpecificationApplicatiionService implements CarSpecificationService {

    private final CarSpecificationRepository carSpecificationRepository;

    @Override
    public CarSpecificationDetalhadoResponse buscaCarSpecificationAtravesId(UUID id) {
        log.info("[start] CarSpecificationApplicatiionService - buscaBrandAtravesId ");
        CarSpecifications carSpecification = carSpecificationRepository.buscaCarSpecificationAtravesId(id);
        log.info("[finish] CarSpecificationApplicatiionService - buscaBrandAtravesId ");
        return new CarSpecificationDetalhadoResponse(carSpecification);
    }

    @Override
    public List<CarSpecificatioListResponse> getTodasCarSpecification() {
        log.info("[start] CarSpecificationApplicatiionService - getTodasCarSpecification ");
        List<CarSpecifications> carSpecifications = carSpecificationRepository.buscaTodasCarSpecification();
        log.info("[finish] CarSpecificationApplicatiionService - getTodasCarSpecification ");
        return CarSpecificatioListResponse.converte(carSpecifications);
    }

}
