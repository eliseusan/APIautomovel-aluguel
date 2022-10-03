package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CategoriesController implements CategoriesAPI {

	private final CategoriesService categoriesService;

	@Override
	public CategoriesResponse postCategories(@Valid CategoriesRequest categoriesRequest) {
		log.info("[start] CategoriesController - postCategories");
		CategoriesResponse categoriesResponse = categoriesService.criaCategories(categoriesRequest);
		log.info("[finish] CategoriesController - postCategories");
		return categoriesResponse;
	}

	@Override
	public List<CategoriesListResponse> getTodasCategories() {
		log.info("[start] CategoriesController - getTodasCategories");
		List<CategoriesListResponse> categories = categoriesService.buscaTodasCategories();
		log.info("[finish] CategoriesController - getTodasCategories");
		return categories;
	}

}
