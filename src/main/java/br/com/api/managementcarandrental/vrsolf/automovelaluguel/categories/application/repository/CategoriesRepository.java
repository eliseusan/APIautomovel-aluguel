package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.repository;

import java.util.List;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;

public interface CategoriesRepository {

	Categories salva(Categories categories);

	List<Categories> buscaTodasCategories();

}
