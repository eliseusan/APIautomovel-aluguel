package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.application.api.CategoriesResponse;

public interface CategoriesService {

	CategoriesResponse criaCategories(@Valid CategoriesRequest categoriesRequest);

	List<CategoriesListResponse> buscaTodasCategories();

	CategoriesDetalhadoResponse getCategoriesAtravesId(UUID id);

	void deletaCategoriesAtravesId(UUID id);

	void patchAlteraCategories(UUID id, @Valid CategoriesAlteracaoRequest categoriesAlteracaoRequest);


}
