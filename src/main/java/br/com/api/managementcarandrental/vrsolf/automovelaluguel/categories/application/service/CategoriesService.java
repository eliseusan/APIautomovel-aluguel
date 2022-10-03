package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.service;

import java.util.List;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesResponse;

public interface CategoriesService {

	CategoriesResponse criaCategories(@Valid CategoriesRequest categoriesRequest);

	List<CategoriesListResponse> buscaTodasCategories();

}
