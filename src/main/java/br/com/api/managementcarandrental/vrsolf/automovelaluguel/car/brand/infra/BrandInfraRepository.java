package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.repository.BrandRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BrandInfraRepository implements BrandRepository {

	private final BrandSpringDataJPARepository brandSpringDataJPARepository;

	@Override
	public Brand salva(Brand brand) {
		log.info("[start] BrandInfraRepository - salva");
		try {
			brandSpringDataJPARepository.save(brand);
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
		}
		log.info("[finish] BrandInfraRepository - salva");
		return brand;
	}

	@Override
	public List<Brand> buscaTodosBrand() {
		log.info("[start] BrandInfraRepository - buscaTodosBrand");
		List<Brand> todosBrand = brandSpringDataJPARepository.findAll();
		log.info("[finish] BrandInfraRepository - buscaTodosBrand");
		return todosBrand;
	}

	@Override
	public Brand buscaBrandAtravesId(UUID id) {
		log.info("[start] BrandInfraRepository - buscaBrandAtravesId");
		Brand brand = brandSpringDataJPARepository.findById(id)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Brand não encontrado !")) ;
		log.info("[finish] BrandInfraRepository - buscaBrandAtravesId");
		return brand;
	}

	@Override
	public void deletaBrand(Brand brand) {
		log.info("[start] BrandInfraRepository - deletaBrand");
		brandSpringDataJPARepository.delete(brand);
		log.info("[finish] BrandInfraRepository - deletaBrand");
	}

}
