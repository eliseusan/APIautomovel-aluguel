package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class BrandRequest {
	
	private UUID id;
	@NotBlank
	private String name;

}
