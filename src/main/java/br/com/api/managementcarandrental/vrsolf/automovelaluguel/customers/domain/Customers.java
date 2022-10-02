package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	@NotBlank
	private String name;
	@NotNull
	private LocalDate birth_date;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	@Column(unique = true)
	private String driver_license;
	@NotBlank
	private String adress;
	@NotBlank
	private String phone_number;

	private LocalDateTime created_at;
	private LocalDateTime update_at;

	public Customers(CustomersRequest customersRequest) {
		this.name = customersRequest.getName();
		this.birth_date = customersRequest.getBirth_date();
		this.email = customersRequest.getEmail();
		this.driver_license = customersRequest.getDriver_license();
		this.adress = customersRequest.getAdress();
		this.phone_number = customersRequest.getPhone_number();
		this.created_at = LocalDateTime.now();
	}

	public void altera(CustomersAlteracaoRequest customersAlteracaoRequest) {
		this.name = customersAlteracaoRequest.getName();
		this.birth_date = customersAlteracaoRequest.getBirth_date();
		this.adress = customersAlteracaoRequest.getAdress();
		this.phone_number = customersAlteracaoRequest.getPhone_number();
		this.update_at = LocalDateTime.now();

	}

}
