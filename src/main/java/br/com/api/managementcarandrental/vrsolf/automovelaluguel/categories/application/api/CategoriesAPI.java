package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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
}
