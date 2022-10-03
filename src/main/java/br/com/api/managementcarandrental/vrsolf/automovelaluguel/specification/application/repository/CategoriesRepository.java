package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;

public interface CategoriesRepository {

	Categories salva(Categories categories);

	List<Categories> buscaTodasCategories();

	Categories buscaCategoriesAtravesId(UUID id);

	void deletaCategories(Categories categories);

}
