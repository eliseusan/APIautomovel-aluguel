package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandAlteracaoRequest;
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

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaCategoriesAtravesId(@PathVariable UUID id);

	@PatchMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraCategories(@PathVariable UUID id,
	@Valid @RequestBody CategoriesAlteracaoRequest categoriesAlteracaoRequest);
}
