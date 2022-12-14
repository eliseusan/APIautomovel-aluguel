package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id_categories", updatable = false, unique = true, nullable = false)
	private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	
	public Categories(CategoriesRequest categoriesRequest) {
		this.id = categoriesRequest.getId();
		this.name = categoriesRequest.getName();
		this.description = categoriesRequest.getDescription();
		this.created_at = LocalDateTime.now();
	}

	public void altera(CategoriesAlteracaoRequest categoriesAlteracaoRequest) {
		this.name = categoriesAlteracaoRequest.getName();
		this.description = categoriesAlteracaoRequest.getDescription();
		this.update_at = LocalDateTime.now();
		
	}
}
