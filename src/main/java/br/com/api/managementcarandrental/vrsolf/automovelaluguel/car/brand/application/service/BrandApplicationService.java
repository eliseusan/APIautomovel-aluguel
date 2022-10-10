package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api.BrandResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.repository.BrandRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BrandApplicationService implements BrandService {

	private final BrandRepository brandRepository;

	@Override
	public BrandResponse criaBrand(BrandRequest brandRequest) {
		log.info("[start] BrandApplicationService - criaBrand ");
		Brand brand = brandRepository.salva(new Brand(brandRequest));
		log.info("[finish] BrandApplicationService - criaBrand ");
		return BrandResponse.builder()
				.id(brand.getId())
				.build();
	}

	@Override
	public List<BrandListResponse> buscaTodosBrand() {
		log.info("[start] BrandApplicationService - buscaTodosBrand ");
		List<Brand>brand = brandRepository.buscaTodosBrand();
		log.info("[finish] BrandApplicationService - buscaTodosBrand ");
		return BrandListResponse.converte(brand);
	}

	@Override
	public BrandDetalhadoResponse buscaBrandAtravesId(UUID id) {
		log.info("[start] BrandApplicationService - buscaBrandAtravesId ");
		Brand brand = brandRepository.buscaBrandAtravesId(id);
		log.info("[finish] BrandApplicationService - buscaBrandAtravesId ");
		return new BrandDetalhadoResponse(brand);
	}

	@Override
	public void deletaBrandAtravesId(UUID id) {
		log.info("[start] BrandApplicationService - deletaBrandAtravesId ");
		Brand brand = brandRepository.buscaBrandAtravesId(id);
		brandRepository.deletaBrand(brand);
		log.info("[finish] BrandApplicationService - deletaBrandAtravesId ");

	}

	@Override
	public void patchAlteraBrand(UUID id, BrandAlteracaoRequest brandAlteracaoRequest) {
		log.info("[start] BrandApplicationService - patchAlteraBrand ");
		Brand brand = brandRepository.buscaBrandAtravesId(id);
		brand.altera(brandAlteracaoRequest);
		brandRepository.salva(brand);
		log.info("[finish] BrandApplicationService - patchAlteraBrand ");
		
	}
}
