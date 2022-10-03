package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.infra;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.domain.Brand;
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

}
