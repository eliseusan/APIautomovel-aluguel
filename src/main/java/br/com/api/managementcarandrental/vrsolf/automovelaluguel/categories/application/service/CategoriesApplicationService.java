package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.repository.CategoriesRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CategoriesApplicationService implements CategoriesService {

	private final CategoriesRepository categoriesRepository;

	@Override
	public CategoriesResponse criaCategories(@Valid CategoriesRequest categoriesRequest) {
		log.info("[start] CategoriesApplicationService - criaCategories ");
		Categories categories = categoriesRepository.salva(new Categories(categoriesRequest));
		log.info("[finish] CategoriesApplicationService - criaCategories ");
		return CategoriesResponse.builder()
				.id(categories.getId())
				.build();
	}

}
