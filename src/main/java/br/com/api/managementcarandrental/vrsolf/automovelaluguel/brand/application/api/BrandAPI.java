package br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api;

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

@RestController
@RequestMapping("/v1/brands")
public interface BrandAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	BrandResponse postBrand(@Valid @RequestBody BrandRequest brandRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<BrandListResponse> getTodosBrand();

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	BrandDetalhadoResponse getBrandAtravesId(@PathVariable UUID id);

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaBrandAtravesId(@PathVariable UUID id);

	@PatchMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraBrand(@PathVariable UUID id,
	@Valid @RequestBody BrandAlteracaoRequest brandAlteracaoRequest);
	
}
