package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.domain.Specification;

public interface SpecificationRepository {

	Specification salva(Specification specification);

	List<Specification> buscaTodasSpecification();

	Specification buscaSpecificationAtravesId(UUID id);

	void deletaSpecification(Specification specification);

}
