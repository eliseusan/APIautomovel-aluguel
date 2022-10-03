package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class CategoriesRequest {

	private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;

}
