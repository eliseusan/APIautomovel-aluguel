package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	@NotBlank
	private String name;
	
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	
	public Brand(BrandRequest brandRequest) {
		this.id = brandRequest.getId();
		this.name = brandRequest.getName();
		this.created_at = LocalDateTime.now();
	}

	public void altera(BrandAlteracaoRequest brandAlteracaoRequest) {
		this.name = brandAlteracaoRequest.getName();
		this.update_at = LocalDateTime.now();
	}
}
