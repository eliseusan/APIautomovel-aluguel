package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api;

import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
import lombok.Value;

@Value
public class CategoriesDetalhadoResponse {

	private UUID id;
	private String name;
	private String description;
	
	public CategoriesDetalhadoResponse(Categories categories) {
		this.id = categories.getId();
		this.name = categories.getName();
		this.description = categories.getDescription();

	}
}
