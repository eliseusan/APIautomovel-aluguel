package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/v1/categories")

public interface CategoriesAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CategoriesResponse postCategories(@Valid @RequestBody CategoriesRequest categoriesRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<CategoriesListResponse> getTodasCategories();

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	CategoriesDetalhadoResponse getCategoriesAtravesId(@PathVariable UUID id);
/*
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaBrandAtravesId(@PathVariable UUID id);

	@PatchMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraBrand(@PathVariable UUID id,
	@Valid @RequestBody BrandAlteracaoRequest brandAlteracaoRequest);*/
}
