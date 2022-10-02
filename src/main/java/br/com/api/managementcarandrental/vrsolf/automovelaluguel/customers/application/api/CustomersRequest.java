package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class CustomersRequest {
	
	@NotBlank
	private String name;
	@NotNull
	private LocalDate birth_date;
	@Email
	private String email;
	@NotBlank
	private String driver_license;
	@NotBlank
	private String adress;
	@NotBlank
	private String phone_number;
	
}
