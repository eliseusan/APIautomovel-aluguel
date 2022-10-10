package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.api.CategoriesResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.repository.CategoriesRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
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

	@Override
	public List<CategoriesListResponse> buscaTodasCategories() {
		log.info("[start] CategoriesApplicationService - buscaTodosCategories ");
		List<Categories>categories = categoriesRepository.buscaTodasCategories();
		log.info("[finish] CategoriesApplicationService - buscaTodosCategories ");
		return CategoriesListResponse.converte(categories);
	}

	@Override
	public CategoriesDetalhadoResponse getCategoriesAtravesId(UUID id) {
		log.info("[start] CategoriesApplicationService - getCategoriesAtravesId ");
		Categories categories = categoriesRepository.buscaCategoriesAtravesId(id);
		log.info("[start] CategoriesApplicationService - getCategoriesAtravesId ");
		return new CategoriesDetalhadoResponse(categories);
	}

	@Override
	public void deletaCategoriesAtravesId(UUID id) {
		log.info("[start] BrandApplicationService - deletaCategoriesAtravesId ");
		Categories categories = categoriesRepository.buscaCategoriesAtravesId(id);
		categoriesRepository.deletaCategories(categories);
		log.info("[finish] BrandApplicationService - deletaCategoriesAtravesId ");
		
	}

	@Override
	public void patchAlteraCategories(UUID id, @Valid CategoriesAlteracaoRequest categoriesAlteracaoRequest) {
		log.info("[start] BrandApplicationService - patchAlteraCategories ");
		Categories categories = categoriesRepository.buscaCategoriesAtravesId(id);
		categories.altera(categoriesAlteracaoRequest);
		categoriesRepository.salva(categories);
		log.info("[finish] BrandApplicationService - patchAlteraCategories ");
		
	}

}
