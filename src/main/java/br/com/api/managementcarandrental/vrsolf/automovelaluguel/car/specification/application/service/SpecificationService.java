package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationResponse;

public interface SpecificationService {

	SpecificationResponse criaSpecification(@Valid SpecificationRequest specificationRequest);

	List<SpecificationListResponse> buscaTodasSpecification();

	SpecificationDetalhadoResponse getSpecificationAtravesId(UUID id);

	void deletaSpecificationAtravesId(UUID id);

	void patchAlteraSpecification(UUID id, @Valid SpecificationAlteracaoRequest specificationAlteracaoRequest);


}
