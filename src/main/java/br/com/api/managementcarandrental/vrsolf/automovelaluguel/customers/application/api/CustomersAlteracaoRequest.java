package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class CustomersAlteracaoRequest {

	@NotBlank
	private String name;
	@NotNull
	private LocalDate birth_date;
	@NotBlank
	private String adress;
	@NotBlank
	private String phone_number;
}
