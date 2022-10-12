package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.application.repository.CategoriesRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CategoriesInfraRepository implements CategoriesRepository {
	private final CategoriesSpringDataJPARepository categoriesSpringDataJPARepository;
	
	@Override
	public Categories salva(Categories categories) {
		
		log.info("[start] CategoriesInfraRepository - salva");
		try {
			categoriesSpringDataJPARepository.save(categories);
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
		}
		log.info("[finish] CategoriesInfraRepository - salva");
		return categories;

	}

	@Override
	public List<Categories> buscaTodasCategories() {
		log.info("[start] CategoriesInfraRepository - buscaTodasCategories");
		List<Categories> todasCategories = categoriesSpringDataJPARepository.findAll();
		log.info("[finish] CategoriesInfraRepository - buscaTodasCategories");
		return todasCategories;
	}

	@Override
	public Categories buscaCategoriesAtravesId(UUID id) {
		log.info("[start] CategoriesInfraRepository - buscaCategoriesAtravesId");
		Categories categories = categoriesSpringDataJPARepository.findById(id)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Categories não encontrado !")) ;
		log.info("[finish] CategoriesInfraRepository - buscaCategoriesAtravesId");
		return categories;
	}

	@Override
	public void deletaCategories(Categories categories) {
		log.info("[start] CategoriesInfraRepository - deletaCategories");
		categoriesSpringDataJPARepository.delete(categories);
		log.info("[finish] CategoriesInfraRepository - deletaCategories");
	}

}
