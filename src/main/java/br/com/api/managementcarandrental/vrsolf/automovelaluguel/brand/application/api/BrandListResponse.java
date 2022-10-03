package br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.domain.Brand;
import lombok.Value;

@Value
public class BrandListResponse {

	private UUID id;
	private String name;
	
	public BrandListResponse(Brand brand) {
		this.id = brand.getId();
		this.name = brand.getName();
	}

	public static List<BrandListResponse> converte(List<Brand> brand) {

		return brand.stream()
				.map(BrandListResponse::new)
				.collect(Collectors.toList());
	}
}