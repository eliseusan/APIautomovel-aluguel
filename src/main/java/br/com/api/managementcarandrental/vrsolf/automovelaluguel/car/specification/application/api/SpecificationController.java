package br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SpecificationController implements SpecificationAPI {

	private final SpecificationService specificationService;

	@Override
	public SpecificationResponse postSpecification(@Valid SpecificationRequest specificationRequest) {
		log.info("[start] SpecificationController - postSpecification");
		SpecificationResponse specificationResponse = specificationService.criaSpecification(specificationRequest);
		log.info("[finish] SpecificationController - postSpecification");
		return specificationResponse;
	}

	@Override
	public List<SpecificationListResponse> getTodasSpecification() {
		log.info("[start] SpecificationController - getTodasSpecification");
		List<SpecificationListResponse> specification = specificationService.buscaTodasSpecification();
		log.info("[finish] SpecificationController - getTodasSpecification");
		return specification;
	}

	@Override
	public SpecificationDetalhadoResponse getSpecificationAtravesId(UUID id) {
		log.info("[start] SpecificationController - getSpecificationAtravesId");
		log.info("[idBrand] {}", id);
		SpecificationDetalhadoResponse specificationDetalhado = specificationService.getSpecificationAtravesId(id);
		log.info("[finish] SpecificationController - getSpecificationAtravesId");
		return specificationDetalhado;
	}

	@Override
	public void deletaSpecificationAtravesId(UUID id) {
		log.info("[start] SpecificationController - deletaSpecificationAtravesId");
		log.info("[idBrand] {}", id);
		specificationService.deletaSpecificationAtravesId(id);
		log.info("[finish] SpecificationController - deletaSpecificationAtravesId");
	}

	@Override
	public void patchAlteraSpecification(UUID id, @Valid SpecificationAlteracaoRequest specificationAlteracaoRequest) {
		log.info("[start] SpecificationController - patchAlteraSpecification");
		log.info("[idBrand] {}", id);
		specificationService.patchAlteraSpecification(id, specificationAlteracaoRequest);
		log.info("[finish] SpecificationController - patchAlteraSpecification");
		
	}

}
