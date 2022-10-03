package br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api.SpecificationAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api.SpecificationDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api.SpecificationListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api.SpecificationRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api.SpecificationResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.repository.SpecificationRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.domain.Specification;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class SpecificationApplicationService implements SpecificationService {

	private final SpecificationRepository specificationRepository;

	@Override
	public SpecificationResponse criaSpecification(@Valid SpecificationRequest specificationRequest) {
		log.info("[start] SpecificationApplicationService - criaSpecification ");
		Specification specification = specificationRepository.salva(new Specification(specificationRequest));
		log.info("[finish] SpecificationApplicationService - criaSpecification ");
		return SpecificationResponse.builder()
				.id(specification.getId())
				.build();
	}

	@Override
	public List<SpecificationListResponse> buscaTodasSpecification() {
		log.info("[start] SpecificationApplicationService - buscaTodasSpecification ");
		List<Specification> specification = specificationRepository.buscaTodasSpecification();
		log.info("[finish] SpecificationApplicationService - buscaTodasSpecification ");
		return SpecificationListResponse.converte(specification);
	}

	@Override
	public SpecificationDetalhadoResponse getSpecificationAtravesId(UUID id) {
		log.info("[start] SpecificationApplicationService - getSpecificationAtravesId ");
		Specification specification = specificationRepository.buscaSpecificationAtravesId(id);
		log.info("[start] SpecificationApplicationService - getSpecificationAtravesId ");
		return new SpecificationDetalhadoResponse(specification);
	}

	@Override
	public void deletaSpecificationAtravesId(UUID id) {
		log.info("[start] SpecificationApplicationService - deletaSpecificationAtravesId ");
		Specification specification = specificationRepository.buscaSpecificationAtravesId(id);
		specificationRepository.deletaSpecification(specification);
		log.info("[finish] SpecificationApplicationService - deletaSpecificationAtravesId ");
		
	}

	@Override
	public void patchAlteraSpecification(UUID id, @Valid SpecificationAlteracaoRequest specificationAlteracaoRequest) {
		log.info("[start] SpecificationApplicationService - patchAlteraSpecification ");
		Specification specification = specificationRepository.buscaSpecificationAtravesId(id);
		specification.altera(specificationAlteracaoRequest);
		specificationRepository.salva(specification);
		log.info("[finish] SpecificationApplicationService - patchAlteraSpecification ");
		
	}

}
