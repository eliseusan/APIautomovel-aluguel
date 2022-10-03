package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CategoriesController implements CategoriesAPI {

	@Override
	public CategoriesResponse postCategories(@Valid CategoriesRequest categoriesRequest) {
		log.info("[start] CategoriesController - postCategories");
		log.info("[finish] CategoriesController - postCategories");
		return null;
	}

}
