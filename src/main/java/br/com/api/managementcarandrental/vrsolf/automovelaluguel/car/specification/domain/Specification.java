package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.application.api.SpecificationRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Specification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id_specification", updatable = false, unique = true, nullable = false)
	private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	
	public Specification(SpecificationRequest specificationRequest) {
		this.id = specificationRequest.getId();
		this.name = specificationRequest.getName();
		this.description = specificationRequest.getDescription();
		this.created_at = LocalDateTime.now();
	}

	public void altera(SpecificationAlteracaoRequest specificationAlteracaoRequest) {
		this.name = specificationAlteracaoRequest.getName();
		this.description = specificationAlteracaoRequest.getDescription();
		this.update_at = LocalDateTime.now();
		
	}
}
