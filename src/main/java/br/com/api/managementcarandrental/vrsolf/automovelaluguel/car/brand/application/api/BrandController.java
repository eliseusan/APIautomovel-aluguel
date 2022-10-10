package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.application.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class BrandController implements BrandAPI {

	private final BrandService brandService;

	@Override
	public BrandResponse postBrand(BrandRequest brandRequest) {
		log.info("[start] BrandController - postBrand");
		BrandResponse brandCriado = brandService.criaBrand(brandRequest);
		log.info("[finish] BrandController - postBrand");
		return brandCriado;
	}

	@Override
	public List<BrandListResponse> getTodosBrand() {
		log.info("[start] BrandController - getTodosBrand");
		List<BrandListResponse> brand = brandService.buscaTodosBrand();
		log.info("[finish] BrandController - getTodosBrand");
		return brand;
	}

	@Override
	public BrandDetalhadoResponse getBrandAtravesId(UUID id) {
		log.info("[start] BrandController - getBrandAtravesId");
		log.info("[idBrand] {}", id);
		BrandDetalhadoResponse brandDetalhado = brandService.buscaBrandAtravesId(id);
		log.info("[finish] BrandController - getBrandAtravesId");

		return brandDetalhado;
	}

	@Override
	public void deletaBrandAtravesId(UUID id) {
		log.info("[start] BrandController - deletaBrandAtravesId");
		log.info("[idBrand] {}", id);
		brandService.deletaBrandAtravesId(id);
		log.info("[finish] BrandController - deletaBrandAtravesId");

	}

	@Override
	public void patchAlteraBrand(UUID id, BrandAlteracaoRequest brandAlteracaoRequest) {
		log.info("[start] BrandController - patchAlteraBrand");
		log.info("[idBrand] {}", id);
		brandService.patchAlteraBrand(id, brandAlteracaoRequest);
		log.info("[finish] BrandController - patchAlteraBrand");
		
	}

}
