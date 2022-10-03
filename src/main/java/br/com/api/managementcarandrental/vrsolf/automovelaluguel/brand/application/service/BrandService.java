package br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.service;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.brand.application.api.BrandResponse;

public interface BrandService {
	BrandResponse criaBrand(BrandRequest brandRequest);
	List<BrandListResponse> buscaTodosBrand();
	BrandDetalhadoResponse buscaBrandAtravesId(UUID id);
	void deletaBrandAtravesId(UUID id);
	void patchAlteraBrand(UUID id, BrandAlteracaoRequest brandAlteracaoRequest);
	
}
