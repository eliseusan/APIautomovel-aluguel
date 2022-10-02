package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.domain.Customers;
import lombok.Value;

@Value
public class CustomersDetalhadoResponse {
	private UUID id;
	private String name;
	private LocalDate birth_date;
	private String email;
	private String driver_license;
	private String adress;
	private String phone_number;
	private LocalDateTime created_at;
	
	public CustomersDetalhadoResponse(Customers customers) {
		this.id = customers.getId();
		this.name = customers.getName();
		this.birth_date = customers.getBirth_date();
		this.email = customers.getEmail();
		this.driver_license = customers.getDriver_license();
		this.adress = customers.getAdress();
		this.phone_number = customers.getPhone_number();
		this.created_at = customers.getCreated_at();
		
	}
	

}
