package br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.domain.Specification;
import lombok.Value;
@Value
public class SpecificationListResponse {

	private UUID id;
	private String name;
	private String description;
	
	public SpecificationListResponse(Specification specification) {
		this.id = specification.getId();
		this.name = specification.getName();
		this.description = specification.getDescription();
	}
	
	public static List<SpecificationListResponse> converte(List<Specification> specification) {

		return specification.stream()
				.map(SpecificationListResponse::new)
				.collect(Collectors.toList());
	}
	
	
}
