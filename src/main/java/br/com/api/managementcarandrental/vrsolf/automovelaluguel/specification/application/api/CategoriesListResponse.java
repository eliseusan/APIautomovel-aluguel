package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;
import lombok.Value;
@Value
public class CategoriesListResponse {

	private UUID id;
	private String name;
	private String description;
	
	public CategoriesListResponse(Categories categories) {
		this.id = categories.getId();
		this.name = categories.getName();
		this.description = categories.getDescription();
	}
	
	public static List<CategoriesListResponse> converte(List<Categories> categories) {

		return categories.stream()
				.map(CategoriesListResponse::new)
				.collect(Collectors.toList());
	}
	
	
}
