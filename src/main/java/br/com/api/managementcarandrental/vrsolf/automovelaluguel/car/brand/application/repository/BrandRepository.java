package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;

public interface BrandRepository {
	Brand salva(Brand brand);
	List<Brand> buscaTodosBrand();
	Brand buscaBrandAtravesId(UUID id);
	void deletaBrand(Brand brand);
}
