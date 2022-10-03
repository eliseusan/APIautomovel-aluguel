package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api;

import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class SpecificationAlteracaoRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	
}
