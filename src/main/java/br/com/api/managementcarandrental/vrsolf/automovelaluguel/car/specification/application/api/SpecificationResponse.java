package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SpecificationResponse {

	private UUID id;
	
}
