package br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api;

import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.domain.Brand;
import lombok.Value;

@Value
public class BrandDetalhadoResponse {
	private UUID id;
	private String name;

	public BrandDetalhadoResponse(Brand brand) {
		this.id = brand.getId();
		this.name = brand.getName();

	}


}
