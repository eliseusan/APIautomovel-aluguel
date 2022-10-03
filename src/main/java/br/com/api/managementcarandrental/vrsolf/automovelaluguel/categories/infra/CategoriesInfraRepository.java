package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.repository.CategoriesRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;
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
		
		log.info("[start] CategoriesSpringDataJPARepository - salva");
		try {
			categoriesSpringDataJPARepository.save(categories);
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
		}
		log.info("[finish] CategoriesSpringDataJPARepository - salva");
		return categories;

	}

	@Override
	public List<Categories> buscaTodasCategories() {
		log.info("[start] CategoriesSpringDataJPARepository - buscaTodasCategories");
		List<Categories> todasCategories = categoriesSpringDataJPARepository.findAll();
		log.info("[finish] CategoriesSpringDataJPARepository - buscaTodasCategories");
		return todasCategories;
	}

	@Override
	public Categories buscaCategoriesAtravesId(UUID id) {
		log.info("[start] CategoriesSpringDataJPARepository - buscaCategoriesAtravesId");
		Categories categories = categoriesSpringDataJPARepository.findById(id)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado !")) ;
		log.info("[finish] CategoriesSpringDataJPARepository - buscaCategoriesAtravesId");
		return categories;
	}

	@Override
	public void deletaCategories(Categories categories) {
		log.info("[start] CategoriesSpringDataJPARepository - deletaCategories");
		categoriesSpringDataJPARepository.delete(categories);
		log.info("[finish] CategoriesSpringDataJPARepository - deletaCategories");
	}

}
