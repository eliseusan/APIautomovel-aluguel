package br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	@NotBlank
	private String name;
	private LocalDateTime created_at;
	private LocalDateTime update_at;
}
