package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.repository.SpecificationRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.domain.Specification;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SpecificationInfraRepository implements SpecificationRepository {
	private final SpecificationSpringDataJPARepository specificationSpringDataJPARepository;
	
	@Override
	public Specification salva(Specification specification) {
		
		log.info("[start] SpecificationInfraRepository - salva");
		try {
			specificationSpringDataJPARepository.save(specification);
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
		}
		log.info("[finish] SpecificationInfraRepository - salva");
		return specification;

	}

	@Override
	public List<Specification> buscaTodasSpecification() {
		log.info("[start] SpecificationInfraRepository - buscaTodasSpecification");
		List<Specification> todasSpecification = specificationSpringDataJPARepository.findAll();
		log.info("[finish] SpecificationInfraRepository - buscaTodasSpecification");
		return todasSpecification;
	}

	@Override
	public Specification buscaSpecificationAtravesId(UUID id) {
		log.info("[start] SpecificationInfraRepository - buscaSpecificationAtravesId");
		Specification specification = specificationSpringDataJPARepository.findById(id)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado !")) ;
		log.info("[finish] SpecificationInfraRepository - buscaSpecificationAtravesId");
		return specification;
	}

	@Override
	public void deletaSpecification(Specification specification) {
		log.info("[start] SpecificationInfraRepository - deletaSpecification");
		specificationSpringDataJPARepository.delete(specification);
		log.info("[finish] SpecificationInfraRepository - deletaSpecification");
	}

}
