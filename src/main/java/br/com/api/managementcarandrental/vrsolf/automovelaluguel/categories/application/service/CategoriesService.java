package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.service;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesResponse;

public interface CategoriesService {

	CategoriesResponse criaCategories(@Valid CategoriesRequest categoriesRequest);

}
