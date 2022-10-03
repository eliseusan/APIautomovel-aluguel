package br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.application.api;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class SpecificationRequest {

	private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;

}
