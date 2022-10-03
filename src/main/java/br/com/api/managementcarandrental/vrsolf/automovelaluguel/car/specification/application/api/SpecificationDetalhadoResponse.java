package br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api;

import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.domain.Specification;
import lombok.Value;

@Value
public class SpecificationDetalhadoResponse {

	private UUID id;
	private String name;
	private String description;
	
	public SpecificationDetalhadoResponse(Specification specification) {
		this.id = specification.getId();
		this.name = specification.getName();
		this.description = specification.getDescription();

	}
}
