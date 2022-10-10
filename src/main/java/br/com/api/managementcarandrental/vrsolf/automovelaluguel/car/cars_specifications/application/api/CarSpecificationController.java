package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.application.service.CarSpecificationService;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CarSpecificationController implements CarSpecificationAPI {

    private final CarSpecificationService carSpecificationService;

    @Override
    public CarSpecificationDetalhadoResponse getCarSpecificationAtravesId(UUID id) {
        log.info("[start] CarSpecificationController - getCarSpecificationAtravesId");
        log.info("[idCarSpecification] {}", id);
        CarSpecificationDetalhadoResponse carSpecificationDetalhado = carSpecificationService.buscaCarSpecificationAtravesId(id);
        log.info("[finish] CarSpecificationController - getCarSpecificationAtravesId");
        return carSpecificationDetalhado;
    }

    @Override
    public List<CarSpecificatioListResponse> getTodasCarSpecification() {
        log.info("[start] CarSpecificationController - getTodasCarSpecification");
        List<CarSpecificatioListResponse> carSpecification = carSpecificationService.getTodasCarSpecification();
        log.info("[finish] CarSpecificationController - getTodasCarSpecification");
        return carSpecification;
    }

   
}
