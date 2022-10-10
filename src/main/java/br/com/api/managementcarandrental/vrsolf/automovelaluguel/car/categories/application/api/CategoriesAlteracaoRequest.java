package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api;

import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class CategoriesAlteracaoRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	
}
