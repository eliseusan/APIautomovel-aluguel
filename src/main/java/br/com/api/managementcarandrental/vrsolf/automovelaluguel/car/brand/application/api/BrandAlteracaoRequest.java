package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter

public class BrandAlteracaoRequest {
	@NotBlank
	private String name; 
}
